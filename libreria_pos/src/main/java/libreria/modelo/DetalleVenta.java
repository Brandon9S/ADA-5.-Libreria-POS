package libreria.modelo;

import java.math.BigDecimal;

/** Renglón de una venta: un libro y la cantidad vendida. */
public class DetalleVenta {
    private final Libro libro;
    private final int cantidad;

    public DetalleVenta(Libro libro, int cantidad) {
        this.libro = libro;
        this.cantidad = cantidad;
    }

    public Libro getLibro() { return libro; }
    public int getCantidad() { return cantidad; }

    public BigDecimal getImporte() {
        return libro.getPrecio().multiply(BigDecimal.valueOf(cantidad));
    }
}
