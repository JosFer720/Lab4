import java.util.Scanner;

/**
 * Clase que representa una reserva de vuelo.
 */
public class Reserva implements Base {
    private String fechaViaje;
    private int cantidadBoletos;
    private String aerolinea;
    private String numeroAsiento;
    private int cantidadMaletas;
    private String claseVuelo;
    private int cantidadCuotas;
    private String cuponDescuento;

    /**
     * Constructor de la clase Reserva.
     */
    public Reserva() {
    }

    @Override
    public void setVueloInicio() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el vuelo de inicio: ");
        String vueloInicio = scanner.nextLine();
    }

    @Override
    public void setVueloFinal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el vuelo final: ");
        String vueloFinal = scanner.nextLine();
    }

    @Override
    public void setBoletos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de boletos: ");
        int cantidadBoletos = scanner.nextInt();
    }

    @Override
    public void setAerolinea() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la aerolínea: ");
        String aerolinea = scanner.nextLine();
    }

    @Override
    public void setTarjeta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la información de la tarjeta de pago: ");
        String informacionTarjeta = scanner.nextLine();
    }

    @Override
    public void ModificarContra() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la nueva contraseña: ");
        String nuevaContrasena = scanner.nextLine();
    }

    @Override
    public void setCuotas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de cuotas: ");
        int cantidadCuotas = scanner.nextInt();
    }

    @Override
    public void setClaseVuelo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la clase de vuelo (Económica/Business): ");
        String claseVuelo = scanner.nextLine();
    }

    @Override
    public void AsignacionAsiento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de asiento: ");
        String numeroAsiento = scanner.nextLine();
    }

    @Override
    public void setNumMaleta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de maletas: ");
        int cantidadMaletas = scanner.nextInt();
    }

    /**
     * Establece la fecha de viaje de la reserva.
     *
     * @param fechaViaje La fecha de viaje a asignar.
     */
    public void setFechaViaje(String fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    /**
     * Establece la cantidad de boletos de la reserva.
     *
     * @param cantidadBoletos La cantidad de boletos a asignar.
     */
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    /**
     * Establece la aerolínea de la reserva.
     *
     * @param aerolinea La aerolínea a asignar.
     */
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    /**
     * Establece el número de asiento de la reserva.
     *
     * @param numeroAsiento El número de asiento a asignar.
     */
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * Establece la cantidad de maletas de la reserva.
     *
     * @param cantidadMaletas La cantidad de maletas a asignar.
     */
    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    /**
     * Establece la clase de vuelo de la reserva.
     *
     * @param claseVuelo La clase de vuelo a asignar.
     */
    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    /**
     * Establece la cantidad de cuotas de la reserva.
     *
     * @param cantidadCuotas La cantidad de cuotas a asignar.
     */
    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    /**
     * Aplica un cupón de descuento a la reserva.
     *
     * @param cuponDescuento El cupón de descuento a aplicar.
     */
    public void aplicarCuponDescuento(String cuponDescuento) {
        this.cuponDescuento = cuponDescuento;
    }

    /**
     * Genera un itinerario de la reserva con información detallada.
     *
     * @return Una cadena con el itinerario de la reserva.
     */
    public String generarItinerario() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha de Viaje: ").append(fechaViaje).append("\n");
        sb.append("Cantidad de Boletos: ").append(cantidadBoletos).append("\n");
        sb.append("Aerolínea: ").append(aerolinea).append("\n");
        sb.append("Número de Asiento: ").append(numeroAsiento).append("\n");
        sb.append("Cantidad de Maletas: ").append(cantidadMaletas).append("\n");
        sb.append("Clase de Vuelo: ").append(claseVuelo).append("\n");
        sb.append("Cantidad de Cuotas: ").append(cantidadCuotas).append("\n");
        sb.append("Cupón de Descuento: ").append(cuponDescuento).append("\n");
        return sb.toString();
    }
}