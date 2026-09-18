package ar.edu.unju.fi.poo.model;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private int id;
    private List<ItemCarrito> items;
    private static int contadorItems = 1;

    public CarritoDeCompras() {
        this.items = new ArrayList<>();
    }

    public CarritoDeCompras(int id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    // Métodos principales del diagrama
    public void agregar(Producto p, int cantidad) {
        if (p == null) {
            System.out.println("El producto no existe.");
            return;
        }
        if (!p.isActivo()) {
            System.out.println("El producto " + p.getNombre() + " no está activo.");
            return;
        }

        for (ItemCarrito item : items) {
            if (item.getProducto().getCodigo().equalsIgnoreCase(p.getCodigo())) {
                item.setCantidad(item.getCantidad() + cantidad);
                System.out.println("Se actualizó la cantidad de " + p.getNombre() + " en el carrito.");
                return;
            }
        }

        items.add(new ItemCarrito(contadorItems++, p, cantidad));
        System.out.println("Se agregó " + p.getNombre() + " al carrito.");
    }

    public void remover(Producto p) {
        if (p == null) return;
        boolean removido = items.removeIf(item -> item.getProducto().getCodigo().equalsIgnoreCase(p.getCodigo()));
        if (removido) {
            System.out.println("Se removió el producto " + p.getNombre() + " del carrito.");
        } else {
            System.out.println("El producto " + p.getNombre() + " no estaba en el carrito.");
        }
    }

    public double total() {
        double total = 0.0;
        for (ItemCarrito item : items) {
            total += item.subTotal();
        }
        return total;
    }

    public void vaciar() {
        items.clear();
        System.out.println("El carrito ha sido vaciado.");
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }
}