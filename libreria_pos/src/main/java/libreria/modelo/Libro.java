package libreria.modelo;

import java.math.BigDecimal;

/** Libro del catálogo de la librería. */
public class Libro {
    private final String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private String categoria;
    private BigDecimal precio;
    private int stock;

    public Libro(String isbn, String titulo, String autor, String editorial,
                 String categoria, BigDecimal precio, int stock) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getEditorial() { return editorial; }
    public String getCategoria() { return categoria; }
    public BigDecimal getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public void setStock(int stock) { this.stock = stock; }
}
