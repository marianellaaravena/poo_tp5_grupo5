package ar.edu.unju.fi.practico5.main;

import java.util.Date;
import ar.edu.unju.fi.practico5.ManagerEnvios;
import ar.edu.unju.fi.practico5.model.Envio;
import ar.edu.unju.fi.practico5.model.Paquete;
import ar.edu.unju.fi.practico5.model.RutaDiaria;
import ar.edu.unju.fi.practico5.model.Vehiculo;

public class MainEnvios {
    public static void main(String[] args) {
        ManagerEnvios manager = new ManagerEnvios();

        Vehiculo camioneta = new Vehiculo("AB123CD", 100.0, 300.0);
        manager.registrarVehiculo(camioneta);

        RutaDiaria rutaHoy = new RutaDiaria(new Date(), camioneta);

        Envio envioNormal = new Envio(1, "Libreria Sur", "Juan Perez", "Av Sarmiento 900");
        Envio envioVacio = new Envio(2, "Tienda Norte", "Ana Gomez", "Av Juan Domingo Peron 742");
        Envio envioPesado = new Envio(3, "Fabrica de Metales", "Taller Central", "Ruta 9 KM 12");

        envioNormal.agregarPaquete(new Paquete("P001", "Caja de libros", 15.0, 10.0));
        envioNormal.agregarPaquete(new Paquete("P002", "Resmas de papel", 10.0, 5.0)); 
        
        envioPesado.agregarPaquete(new Paquete("P003", "Yunque de acero", 85.0, 20.0)); 

        manager.registrarEnvio(envioNormal);
        manager.registrarEnvio(envioVacio);
        manager.registrarEnvio(envioPesado);

        System.out.println("\n--- PRUEBAS DE VALIDACION DE REGLAS ---");
        
        System.out.println("\n>> Intentando asignar envio vacio");
        manager.asignarEnvioARuta(rutaHoy, envioVacio);

        System.out.println("\n>> Intentando asignar envio normal");
        manager.asignarEnvioARuta(rutaHoy, envioNormal);

        System.out.println("\n>> Intentando asignar envio pesado");
        manager.asignarEnvioARuta(rutaHoy, envioPesado);

        System.out.println("\n--- PRUEBAS DE OPERACIONES DE NEGOCIO ---");
        envioNormal.mostrarInfo();
        
        System.out.println("\n>> Despachando envío...");
        envioNormal.despachar();
        envioNormal.mostrarInfo();
        
        System.out.println("\n>> Marcando envío como devuelto...");
        envioNormal.devolver();
        envioNormal.mostrarInfo();
    }
}