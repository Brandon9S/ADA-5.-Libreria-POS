package libreria.modelo;

/** Cliente registrado para asociar a los comprobantes de venta. */
public class Cliente {
    private final int id;
    private String nombre;
    private String correo;
    private String telefono;

    public Cliente(int id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
}
