/**
 * Representa una factura de un artículo vendido en una ferretería.
 */
public class Factura {

    private String numeroPieza;
    private String descripcion;
    private int cantidad;
    private double precioPorArticulo;

    public Factura(String numeroPieza, String descripcion, int cantidad, double precioPorArticulo) {
        this.numeroPieza = numeroPieza;
        this.descripcion = descripcion;
        setCantidad(cantidad);
        setPrecioPorArticulo(precioPorArticulo);
    }

    public String obtenerNumeroPieza() {
        return numeroPieza;
    }

    public void establecerNumeroPieza(String numeroPieza) {
        this.numeroPieza = numeroPieza;
    }

    public String obtenerDescripcion() {
        return descripcion;
    }

    public void establecerDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int obtenerCantidad() {
        return cantidad;
    }

    /** Si la cantidad no es positiva, se establece en 0. */
    public void establecerCantidad(int cantidad) {
        this.cantidad = cantidad > 0 ? cantidad : 0;
    }

    public double obtenerPrecioPorArticulo() {
        return precioPorArticulo;
    }

    /** Si el precio no es positivo, se establece en 0.0. */
    public void establecerPrecioPorArticulo(double precioPorArticulo) {
        this.precioPorArticulo = precioPorArticulo > 0 ? precioPorArticulo : 0.0;
    }

    public double obtenerMontoFactura() {
        return cantidad * precioPorArticulo;
    }

    // Métodos privados auxiliares para que el constructor reutilice las validaciones
    private void setCantidad(int cantidad) {
        establecerCantidad(cantidad);
    }

    private void setPrecioPorArticulo(double precio) {
        establecerPrecioPorArticulo(precio);
    }
}
