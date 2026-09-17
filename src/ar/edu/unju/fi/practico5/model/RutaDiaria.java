package ar.edu.unju.fi.practico5.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RutaDiaria {
    private Date fecha;
    private Vehiculo vehiculo;
    private List<Envio> envios;
    
    public RutaDiaria(Date fecha, Vehiculo vehiculo) { 
		this.fecha = fecha; 
		this.vehiculo = vehiculo; 
		this.envios = new ArrayList<>(); 
	}
    
    // Metodo para agregar un envio
    public void agregarEnvio(Envio envio) { 
		this.envios.add(envio); 
	}
    
    // ========= Metodos Auxiliares =========
    // Calcula el peso acumulado
    public double getPesoActualTotal() { 
		double pesoAcumulado = 0.0; 
		for (Envio e : envios) { 
			pesoAcumulado += e.getPesoTotal(); 
		} 
		return pesoAcumulado; 
	}
    
    // Getters
    public Date getFecha() { return fecha; } 
	public Vehiculo getVehiculo() { return vehiculo; } 
	public List<Envio> getEnvios() { return envios; }
}