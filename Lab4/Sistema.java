import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Clase que representa el sistema de reservas.
 */
public class Sistema {
    private List<Usuario> usuariosRegistrados;
    private List<Reserva> reservasConfirmadas;
    private Usuario usuarioActual;
    private Scanner scanner;
    private Reserva reservaActual;

    /**
     * Constructor por defecto de la clase Sistema.
     * Inicializa las listas de usuarios registrados y reservas confirmadas, así como el scanner y carga los usuarios desde un archivo CSV.
     */
    public Sistema() {
        usuariosRegistrados = new ArrayList<>();
        reservasConfirmadas = new ArrayList<>();
        scanner = new Scanner(System.in);
        cargarUsuarios();
    }

    /**
     * Carga los usuarios desde un archivo CSV al iniciar el sistema.
     */
    private void cargarUsuarios() {
        String archivo = "usuarios.csv"; 
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                if (valores.length >= 3) {
                    String nombreUsuario = valores[0];
                    String estatus = valores[1];
                    String contrasena = valores[2];
                    Usuario usuario = new Usuario(nombreUsuario, contrasena, estatus);
                    usuariosRegistrados.add(usuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicia el sistema y muestra el menú principal.
     */
    public void iniciar() {
        mostrarMenuPrincipal();
    }

    /**
     * Muestra el menú principal del sistema.
     */
    private void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("Bienvenido al Sistema de Reservas");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    /**
     * Crea un nuevo usuario y lo agrega a la lista de usuarios registrados.
     */
    private void crearUsuario() {
        System.out.println("Crear Nuevo Usuario");
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();

        System.out.print("Seleccione el plan (1 para Base, 2 para Premium): ");
        int eleccionPlan = scanner.nextInt();
        scanner.nextLine(); 

        String tipoPlan = (eleccionPlan == 2) ? "premium" : "base";
        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena, tipoPlan);
        usuariosRegistrados.add(nuevoUsuario);

        guardarUsuarioEnCSV(nuevoUsuario);

        System.out.println("Usuario creado exitosamente.");
    }

    /**
     * Inicia sesión de un usuario registrado en el sistema.
     */
    private void iniciarSesion() {
        System.out.println("Iniciar Sesión");
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();

        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                usuarioActual = usuario;
                System.out.println("Inicio de sesión exitoso.");
                mostrarMenuUsuario();
                return;
            }
        }

        System.out.println("Nombre de usuario o contraseña incorrecta.");
    }

    /**
     * Muestra el menú de opciones para el usuario que ha iniciado sesión.
     */
    private void mostrarMenuUsuario() {
        if (usuarioActual == null) {
            System.out.println("No hay ningún usuario iniciado sesión.");
            return;
        }

        while (true) {
            System.out.println("Menú de Usuario - " + (usuarioActual.getTipoPlan().equalsIgnoreCase("premium") ? "Premium" : "Base"));
            System.out.println("1. Hacer Reservación");
            System.out.println("2. Cambiar contraseña");
            if (!usuarioActual.getTipoPlan().equalsIgnoreCase("premium")) {
                System.out.println("3. Cambiar a plan premium");
            }
            System.out.println("4. Imprimir itinerario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    manejarReservacion();
                    break;
                case 2:
                    cambiarContrasena();
                    break;
                case 3:
                    if (!usuarioActual.getTipoPlan().equalsIgnoreCase("premium")) {
                        cambiarAPlanPremium();
                    } else {
                        System.out.println("Opción no válida para usuarios Premium");
                    }
                    break;
                case 4:
                    imprimirItinerario();
                    break;
                case 5:
                    return; 
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    /**
     * Actualiza los datos de un usuario en el archivo CSV.
     */
    private void actualizarDatosUsuarioEnCSV(Usuario usuario) {
        String archivo = "usuarios.csv";

        List<String> lineasActualizadas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                if (valores.length >= 3) {
                    String nombreUsuario = valores[0];
                    if (nombreUsuario.equals(usuario.getNombreUsuario())) {
                        String nuevaLinea = usuario.getNombreUsuario() + "," + usuario.getTipoPlan() + "," + usuario.getContrasena();
                        lineasActualizadas.add(nuevaLinea);
                    } else {
                        lineasActualizadas.add(linea);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (String linea : lineasActualizadas) {
                pw.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cambia la contraseña del usuario actual.
     */
    private void cambiarContrasena() {
        System.out.print("Ingrese la nueva contraseña: ");
        String nuevaContrasena = scanner.nextLine();
        usuarioActual.setContrasena(nuevaContrasena);
        
        actualizarDatosUsuarioEnCSV(usuarioActual);

        System.out.println("Contraseña actualizada con éxito.");
    }

    /**
     * Guarda un nuevo usuario en el archivo CSV de usuarios.
     */
    private void guardarUsuarioEnCSV(Usuario usuario) {
        List<String> lineas = new ArrayList<>();
        String archivo = "usuarios.csv";
        boolean usuarioExistente = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(usuario.getNombreUsuario() + ",")) {
                    String nuevaLinea = usuario.getNombreUsuario() + "," + usuario.getTipoPlan() + "," + usuario.getContrasena();
                    lineas.add(nuevaLinea);
                    usuarioExistente = true;
                } else {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!usuarioExistente) {
            lineas.add(usuario.getNombreUsuario() + "," + usuario.getTipoPlan() + "," + usuario.getContrasena());
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (String linea : lineas) {
                pw.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   

    /**
     * Cambia al usuario actual al plan Premium.
     */
    private void cambiarAPlanPremium() {
        usuarioActual.setTipoPlan("premium");
        System.out.println("Cambiado a plan Premium.");
        
        actualizarDatosUsuarioEnCSV(usuarioActual);
    }

    /**
     * Imprime el itinerario de la reserva actual.
     */
    private void imprimirItinerario() {
        if (reservaActual != null) {
            String itinerario = reservaActual.generarItinerario();
            System.out.println("Itinerario de la reserva:");
            System.out.println(itinerario);
        } else {
            System.out.println("No hay reservaciones activas.");
        }
    }

    /**
     * Maneja el proceso de hacer una reserva.
     */
    private void manejarReservacion() {
        Reserva reservaActual = new Reserva(); 

        while (true) {
            System.out.println("Menú de Reservación");
            System.out.println("1. Definir fecha de viaje");
            System.out.println("2. Definir cantidad de boletos");
            System.out.println("3. Definir aerolínea");
            if (usuarioActual.getTipoPlan().equalsIgnoreCase("premium")) {
                System.out.println("4. Seleccionar número de asiento");
                System.out.println("5. Definir cantidad de maletas");
            } else {
                System.out.println("4. Definir clase de vuelo");
                System.out.println("5. Definir cantidad de cuotas");
                System.out.println("6. Aplicar cupón de descuento");
            }
            System.out.println("7. Confirmar Reservación");
            System.out.println("8. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la fecha de viaje (formato YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();
                    reservaActual.setFechaViaje(fecha);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad de boletos: ");
                    int cantidadBoletos = scanner.nextInt();
                    scanner.nextLine();
                    reservaActual.setCantidadBoletos(cantidadBoletos);
                    break;
                case 3:
                    System.out.print("Ingrese la aerolínea: ");
                    String aerolinea = scanner.nextLine();
                    reservaActual.setAerolinea(aerolinea);
                    break;
                case 4:
                    if (usuarioActual.getTipoPlan().equalsIgnoreCase("premium")) {
                        System.out.print("Ingrese el número de asiento: ");
                        String numeroAsiento = scanner.nextLine();
                        reservaActual.setNumeroAsiento(numeroAsiento);
                    } else {
                        System.out.print("Ingrese la clase de vuelo (Económica/Business): ");
                        String claseVuelo = scanner.nextLine();
                        reservaActual.setClaseVuelo(claseVuelo);
                    }
                    break;
                case 5:
                    if (usuarioActual.getTipoPlan().equalsIgnoreCase("premium")) {
                        System.out.print("Ingrese la cantidad de maletas: ");
                        int cantidadMaletas = scanner.nextInt();
                        scanner.nextLine();
                        reservaActual.setCantidadMaletas(cantidadMaletas);
                    } else {
                        System.out.print("Ingrese la cantidad de cuotas: ");
                        int cantidadCuotas = scanner.nextInt();
                        scanner.nextLine();
                        reservaActual.setCantidadCuotas(cantidadCuotas);
                    }
                    break;
                case 6:
                    if (!usuarioActual.getTipoPlan().equalsIgnoreCase("premium")) {
                        System.out.print("Ingrese el código del cupón de descuento: ");
                        String cupon = scanner.nextLine();
                        reservaActual.aplicarCuponDescuento(cupon);
                    }
                    break;
                case 7:
                    confirmarReservacion(reservaActual);
                    return; 
                case 8:
                    return; 
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    /**
     * Confirma una reservación y la guarda en un archivo CSV.
     */
    private void confirmarReservacion(Reserva reserva) {
        String archivoReservas = "reservas.csv"; 

        try {
            File archivo = new File(archivoReservas);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            FileWriter fw
            FileWriter fw = new FileWriter(archivoReservas, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            out.println(reserva.toString()); // Guardar la reserva en el archivo
            System.out.println("Reservación confirmada y guardada exitosamente.");

            out.close();
        } catch (IOException e) {
            System.err.println("Ocurrió un error al guardar la reservación: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.iniciar();
    }
}