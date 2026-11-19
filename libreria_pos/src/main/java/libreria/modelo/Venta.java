package libreria.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/** Venta en mostrador: subtotal, descuento, IVA y total. */
public class Venta {
    public static final BigDecimal TASA_IVA = new BigDecimal("0.16");

    private final List<DetalleVenta> detalles = new ArrayList<>();
    private Cliente cliente;
    private BigDecimal porcentajeDescuento = BigDecimal.ZERO;

    public void agregarLibro(Libro libro, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        if (cantidad > libro.getStock()) {
            throw new IllegalArgumentException("Stock insuficiente para: " + libro.getTitulo());
        }
        detalles.add(new DetalleVenta(libro, cantidad));
    }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Cliente getCliente() { return cliente; }
    public List<DetalleVenta> getDetalles() { return detalles; }

    /** Aplica un descuento porcentual (0 a 100) sobre el subtotal. */
    public void aplicarDescuento(BigDecimal porcentaje) {
        if (porcentaje.compareTo(BigDecimal.ZERO) < 0 || porcentaje.compareTo(new BigDecimal("100")) > 0) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
        }
        this.porcentajeDescuento = porcentaje;
    }

    public BigDecimal calcularSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (DetalleVenta d : detalles) {
            subtotal = subtotal.add(d.getImporte());
        }
        return subtotal;
    }

    public BigDecimal calcularDescuento() {
        return calcularSubtotal().multiply(porcentajeDescuento)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcularIva() {
        return calcularSubtotal().subtract(calcularDescuento())
                .multiply(TASA_IVA).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcularTotal() {
        return calcularSubtotal().subtract(calcularDescuento()).add(calcularIva());
    }
}
