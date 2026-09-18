package ar.edu.unju.fi.practico5.model;

public class ItemCarrito {
    private int id;
    private Producto producto;
    private int cantidad;

    public ItemCarrito() {
    }

    public ItemCarrito(int id, Producto producto, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Métodos propios de la clase
    public double subTotal() {
        return producto != null ? producto.getPrecio() * cantidad : 0.0;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Item " + id + ": " + producto.getNombre() + " x" + cantidad + " - Subtotal: $" + subTotal();
    }
}