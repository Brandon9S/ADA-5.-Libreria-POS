package libreria;

import java.math.BigDecimal;
import libreria.modelo.Libro;
import libreria.modelo.Venta;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("9780307474728", "Cien años de soledad", "Gabriel García Márquez",
                "Sudamericana", "Novela", new BigDecimal("250.00"), 10);
        Libro libro2 = new Libro("9788437604947", "Rayuela", "Julio Cortázar",
                "Cátedra", "Novela", new BigDecimal("180.00"), 5);

        Venta venta = new Venta();
        venta.agregarLibro(libro1, 2);
        venta.agregarLibro(libro2, 1);
        venta.aplicarDescuento(new BigDecimal("10"));

        System.out.println("Subtotal:  $" + venta.calcularSubtotal());
        System.out.println("Descuento: $" + venta.calcularDescuento());
        System.out.println("IVA (16%): $" + venta.calcularIva());
        System.out.println("Total:     $" + venta.calcularTotal());
    }
}
