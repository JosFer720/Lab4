import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la confirmación de un viaje o reserva.
 */
public class Confirmacion implements Base {
    private String numeroTarjeta;
    private int cantidadCuotas;
    private String claseVuelo;
    private String numeroAsiento;
    private int cantidadMaletas;
    private List<String> cuponesAplicados;

    /**
     * Constructor por defecto de la clase Confirmacion.
     */
    public Confirmacion() {
        this.cuponesAplicados = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVueloInicio() {
        System.out.println("Vuelo de inicio establecido.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVueloFinal() {
        System.out.println("Vuelo final establecido.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBoletos() {
        System.out.println("Cantidad de boletos establecida.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAerolinea() {
        System.out.println("Aerolínea establecida.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTarjeta() {
        System.out.println("Información de tarjeta de pago establecida.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ModificarContra() {
        System.out.println("Contraseña modificada.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCuotas() {
        System.out.println("Cantidad de cuotas establecida.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setClaseVuelo() {
        System.out.println("Clase de vuelo establecida.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void AsignacionAsiento() {
        System.out.println("Número de asiento asignado.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNumMaleta() {
        System.out.println("Cantidad de maletas establecida.");
    }

    /**
     * Obtiene el número de tarjeta de pago.
     *
     * @return El número de tarjeta de pago.
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece el número de tarjeta de pago.
     *
     * @param numeroTarjeta El número de tarjeta de pago a establecer.
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Obtiene la cantidad de cuotas para el pago.
     *
     * @return La cantidad de cuotas.
     */
    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    /**
     * Establece la cantidad de cuotas para el pago.
     *
     * @param cantidadCuotas La cantidad de cuotas a establecer.
     */
    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    /**
     * Obtiene la clase de vuelo.
     *
     * @return La clase de vuelo.
     */
    public String getClaseVuelo() {
        return claseVuelo;
    }

    /**
     * Establece la clase de vuelo.
     *
     * @param claseVuelo La clase de vuelo a establecer.
     */
    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    /**
     * Obtiene el número de asiento asignado.
     *
     * @return El número de asiento.
     */
    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    /**
     * Establece el número de asiento asignado.
     *
     * @param numeroAsiento El número de asiento a establecer.
     */
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * Obtiene la cantidad de maletas.
     *
     * @return La cantidad de maletas.
     */
    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    /**
     * Establece la cantidad de maletas.
     *
     * @param cantidadMaletas La cantidad de maletas a establecer.
     */
    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    /**
     * Obtiene la lista de cupones aplicados.
     *
     * @return La lista de cupones aplicados.
     */
    public List<String> getCuponesAplicados() {
        return cuponesAplicados;
    }

    /**
     * Establece la lista de cupones aplicados.
     *
     * @param cuponesAplicados La lista de cupones aplicados a establecer.
     */
    public void setCuponesAplicados(List<String> cuponesAplicados) {
        this.cuponesAplicados = cuponesAplicados;
    }

    /**
     * Imprime el itinerario de viaje.
     */
    public void imprimirItinerario() {
        // Implementa la lógica para imprimir el itinerario si es relevante para Confirmacion
        System.out.println("Itinerario de Viaje:");
        System.out.println("Número de Tarjeta: " + numeroTarjeta);
        System.out.println("Cantidad de Cuotas: " + cantidadCuotas);
        System.out.println("Clase de Vuelo: " + claseVuelo);
        System.out.println("Número de Asiento: " + numeroAsiento);
        System.out.println("Cantidad de Maletas: " + cantidadMaletas);
        System.out.println("Cupones Aplicados: " + cuponesAplicados);
    }
}