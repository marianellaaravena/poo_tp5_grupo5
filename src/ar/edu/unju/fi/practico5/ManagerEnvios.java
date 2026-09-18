package ar.edu.unju.fi.practico5;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.practico5.model.Envio;
import ar.edu.unju.fi.practico5.model.Vehiculo;
import ar.edu.unju.fi.practico5.model.RutaDiaria;

public class ManagerEnvios {
    private List<Envio> envios;
    private List<Vehiculo> vehiculos;

    public ManagerEnvios() {
        this.envios = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }

    public void registrarEnvio(Envio envio) {
        this.envios.add(envio);
        System.out.println("Envio " + envio.getId() + " registrado");
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
        System.out.println("Vehiculo " + vehiculo.getPatente() + " registrado");
    }

    public void asignarEnvioARuta(RutaDiaria ruta, Envio envio) {
        if (!envio.tienePaquetes()) {
            System.out.println("El envio " + envio.getId() + " no tiene paquetes asociados.");
            return;
        }

        double pesoProyectado = ruta.getPesoActualTotal() + envio.getPesoTotal();
        
        if (pesoProyectado > ruta.getVehiculo().getCapacidadPeso()) {
            System.out.println("ERROR AL ASIGNAR: El envio " + envio.getId() + 
                               " excede la capacidad de peso del vehiculo (" + ruta.getVehiculo().getCapacidadPeso() + "kg).");
            return;
        }
        envio.asignarRuta(ruta);
        System.out.println("ÉXITO: Envio " + envio.getId() + " fue asignado correctamente a la ruta");
    }
}