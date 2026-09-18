package ar.edu.unju.fi.poo.model;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private CarritoDeCompras carrito;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String email, CarritoDeCompras carrito) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.carrito = carrito;
    }

    // Métodos del diagrama delegando funciones al CarritoDeCompras
    public void agregarAlCarrito(Producto p, int cantidad) {
        if (carrito != null) {
            carrito.agregar(p, cantidad);
        } else {
            System.out.println("El usuario no posee un carrito asignado.");
        }
    }

    public void removerDelCarrito(Producto p) {
        if (carrito != null) {
            carrito.remover(p);
        } else {
            System.out.println("El usuario no posee un carrito asignado.");
        }
    }

    public void verTotalCarrito() {
        if (carrito != null) {
            System.out.println("Importe total del carrito: $" + carrito.total());
        } else {
            System.out.println("El usuario no posee un carrito asignado.");
        }
    }

    public void mostrarCarrito() {
        if (carrito == null || carrito.getItems().isEmpty()) {
            System.out.println("El carrito de " + nombre + " está vacío.");
            return;
        }

        System.out.println("=== Detalle del Carrito de " + nombre + " ===");
        for (ItemCarrito item : carrito.getItems()) {
            System.out.println(item);
        }
        System.out.println("==========================================");
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CarritoDeCompras getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoDeCompras carrito) {
        this.carrito = carrito;
    }
}