import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa a un usuario del sistema.
 */
public class Usuario implements Base {
    private String nombreUsuario;
    private String nombre;
    private String contrasena;
    private String tipoPlan;
    private String informacionPago;
    private List<String> cuponesAplicados;
    private List<String> reservasRealizadas;

    /**
     * Constructor de la clase Usuario.
     *
     * @param nombreUsuario Nombre de usuario del usuario.
     * @param contrasena    Contraseña del usuario.
     * @param tipoPlan      Tipo de plan del usuario (base o premium).
     */
    public Usuario(String nombreUsuario, String contrasena, String tipoPlan) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.tipoPlan = tipoPlan;
        this.cuponesAplicados = new ArrayList<>();
        this.reservasRealizadas = new ArrayList<>();
    }

    // Implementación de métodos de la interfaz Base con comentarios Javadoc

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVueloInicio() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el vuelo de inicio: ");
        String vueloInicio = scanner.nextLine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVueloFinal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el vuelo final: ");
        String vueloFinal = scanner.nextLine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBoletos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de boletos: ");
        int cantidadBoletos = scanner.nextInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAerolinea() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la aerolínea: ");
        String aerolinea = scanner.nextLine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTarjeta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la información de la tarjeta de pago: ");
        String informacionTarjeta = scanner.nextLine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ModificarContra() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la nueva contraseña: ");
        String nuevaContrasena = scanner.nextLine();
        this.contrasena = nuevaContrasena;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCuotas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de cuotas: ");
        int cantidadCuotas = scanner.nextInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setClaseVuelo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la clase de vuelo (Económica/Business): ");
        String claseVuelo = scanner.nextLine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void AsignacionAsiento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de asiento: ");
        String numeroAsiento = scanner.nextLine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNumMaleta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de maletas: ");
        int cantidadMaletas = scanner.nextInt();
    }

   /**
     * Cambia el plan del usuario a uno nuevo.
     *
     * @param nuevoPlan El nuevo plan a asignar (base o premium).
     */
    public void cambiarPlan(String nuevoPlan) {
        if (nuevoPlan.equalsIgnoreCase("base") || nuevoPlan.equalsIgnoreCase("premium")) {
            this.tipoPlan = nuevoPlan;
            System.out.println("Plan cambiado a: " + nuevoPlan);
        } else {
            System.out.println("Plan no válido.");
        }
    }

    /**
     * Aplica un descuento al usuario mediante un código de cupón.
     *
     * @param codigoCupon El código del cupón a aplicar.
     */
    public void aplicarDescuento(String codigoCupon) {
        cuponesAplicados.add(codigoCupon);
        System.out.println("Cupón aplicado: " + codigoCupon);
    }

    /**
     * Cambia la contraseña del usuario.
     *
     * @param nuevaContrasena La nueva contraseña a asignar.
     */
    public void cambiarContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
        System.out.println("Contraseña cambiada exitosamente.");
    }

    /**
     * Comprueba si el usuario tiene un plan premium.
     *
     * @return true si el usuario tiene un plan premium, false de lo contrario.
     */
    public boolean esPremium() {
        return this.tipoPlan.equalsIgnoreCase("premium");
    }

    // Métodos getter y setter con comentarios Javadoc

    /**
     * Obtiene el nombre de usuario del usuario.
     *
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario del usuario.
     *
     * @param nombreUsuario El nuevo nombre de usuario a asignar.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena La nueva contraseña a asignar.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el tipo de plan del usuario.
     *
     * @return El tipo de plan del usuario (base o premium).
     */
    public String getTipoPlan() {
        return tipoPlan;
    }

    /**
     * Establece el tipo de plan del usuario.
     *
     * @param tipoPlan El nuevo tipo de plan a asignar.
     */
    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    /**
     * Obtiene la información de pago del usuario.
     *
     * @return La información de pago del usuario.
     */
    public String getInformacionPago() {
        return informacionPago;
    }

    /**
     * Establece la información de pago del usuario.
     *
     * @param informacionPago La nueva información de pago a asignar.
     */
    public void setInformacionPago(String informacionPago) {
        this.informacionPago = informacionPago;
    }

    /**
     * Obtiene la lista de cupones aplicados por el usuario.
     *
     * @return La lista de cupones aplicados.
     */
    public List<String> getCuponesAplicados() {
        return cuponesAplicados;
    }

    /**
     * Establece la lista de cupones aplicados por el usuario.
     *
     * @param cuponesAplicados La nueva lista de cupones aplicados.
     */
    public void setCuponesAplicados(List<String> cuponesAplicados) {
        this.cuponesAplicados = cuponesAplicados;
    }

    /**
     * Obtiene la lista de reservas realizadas por el usuario.
     *
     * @return La lista de reservas realizadas.
     */
    public List<String> getReservasRealizadas() {
        return reservasRealizadas;
    }

    /**
     * Establece la lista de reservas realizadas por el usuario.
     *
     * @param reservasRealizadas La nueva lista de reservas realizadas.
     */
    public void setReservasRealizadas(List<String> reservasRealizadas) {
        this.reservasRealizadas = reservasRealizadas;
    }
}
