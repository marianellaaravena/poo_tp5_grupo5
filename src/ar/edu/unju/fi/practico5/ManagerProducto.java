package ar.edu.unju.fi.practico5;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.practico5.model.Producto;

public class ManagerProducto {
    private List<Producto> productos;

    public ManagerProducto() {
        this.productos = new ArrayList<>();
        inicializarProductos();
    }

    private void inicializarProductos() {
        productos.add(new Producto("P001", "Laptop Gamer", 1500000.0, true));
        productos.add(new Producto("P002", "Mouse Gamer", 65000.0, true));
        productos.add(new Producto("P003", "Teclado Mecánico", 50000.0, true));
        productos.add(new Producto("P004", "Monitor 27''", 187000.0, true));
        productos.add(new Producto("P005", "Auriculares Bluetooth", 32000.0, true));
    }

    public Producto buscarPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}