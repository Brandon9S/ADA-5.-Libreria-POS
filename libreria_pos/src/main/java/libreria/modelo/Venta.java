package libreria.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Venta en mostrador. Versión inicial: solo agrega libros y calcula el subtotal. */
public class Venta {
    private final List<DetalleVenta> detalles = new ArrayList<>();
    private Cliente cliente;

    public void agregarLibro(Libro libro, int cantidad) {
        detalles.add(new DetalleVenta(libro, cantidad));
    }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Cliente getCliente() { return cliente; }
    public List<DetalleVenta> getDetalles() { return detalles; }

    public BigDecimal calcularSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (DetalleVenta d : detalles) {
            subtotal = subtotal.add(d.getImporte());
        }
        return subtotal;
    }
}
