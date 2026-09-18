package ar.edu.unju.fi.practico5.main;

import ar.edu.unju.fi.practico5.ManagerProducto;
import ar.edu.unju.fi.practico5.model.CarritoDeCompras;
import ar.edu.unju.fi.practico5.model.Producto;
import ar.edu.unju.fi.practico5.model.Usuario;

public class MainEcommerce {
    public static void main(String[] args) {
        // ii. Instanciar ManagerProducto (se inicializan 5 productos)
        ManagerProducto manager = new ManagerProducto();

        // iv. Instanciar a un usuario con su correspondiente carrito de compras
        CarritoDeCompras carritoUsuario = new CarritoDeCompras(101);
        Usuario usuario = new Usuario("U001", "María González", "maria@email.com", carritoUsuario);

        System.out.println("--- 1. AGREGANDO PRODUCTOS ---");
        // v. Buscar productos y agregarlos al carrito
        Producto p1 = manager.buscarPorCodigo("P001"); // Laptop
        Producto p2 = manager.buscarPorCodigo("P002"); // Mouse
        Producto p3 = manager.buscarPorCodigo("P005"); // Auriculares

        usuario.agregarAlCarrito(p1, 1);
        usuario.agregarAlCarrito(p2, 1);
        usuario.agregarAlCarrito(p3, 1);

        System.out.println("\n--- 2. CONSULTA DE ESTADO ---");
        // vi. Mostrar el importe total
        usuario.verTotalCarrito();

        // vii. Mostrar el carrito
        usuario.mostrarCarrito();

        System.out.println("\n--- 3. REMOVIENDO PRODUCTO ---");
        // viii. Buscar un producto y removerlo del carrito
        Producto pARemover = manager.buscarPorCodigo("P002"); // Mouse
        usuario.removerDelCarrito(pARemover);

        System.out.println("\n--- 4. CONSULTA DE ESTADO TRAS REMOVER ---");
        // ix. Mostrar el importe total
        usuario.verTotalCarrito();
        usuario.mostrarCarrito();

        System.out.println("\n--- 5. VACIANDO CARRITO ---");
        // x. Vaciar el carrito
        usuario.getCarrito().vaciar();
        usuario.mostrarCarrito();
    }
}
