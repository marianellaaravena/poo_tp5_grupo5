package ar.edu.unju.fi.practico5.model;

import java.util.ArrayList;
import java.util.List;

public class Envio {
    private int idEnvio;
    private String remitente;
    private String destinatario;
    private String direccionEntrega;
    private String estado; 
    private List<Paquete> paquetes;
    
    public Envio(int idEnvio, String remitente, String destinatario, String direccionEntrega) { 
		this.idEnvio = idEnvio; 
		this.remitente = remitente; 
		this.destinatario = destinatario; 
		this.direccionEntrega = direccionEntrega; 
		this.estado = "GENERADO";
		this.paquetes = new ArrayList<>();
	}
    
    // Metodo para agregar un paquete
    public void agregarPaquete(Paquete paquete) { 
		if (paquete != null) { 
			this.paquetes.add(paquete); 
		} 
	}
    
    // Metodo para cambiar el estado de un envio cuando se despache
    public void despachar() {
	    this.estado = "EN_RUTA";
	}
    
    // Metodo para cambiar el estado de un envio cuando se devolva
    public void devolver() {
	    this.estado = "DEVUELTO";
	}
    
    // Metodo para asignar una ruta a un envio
    public void asignarRuta(RutaDiaria ruta) {
	    ruta.agregarEnvio(this);
	}
    
    // Metodo para mostrar detalle del envio
    public void mostrarInfo() { 
		System.out.println("====== DETALLE DEL ENVÍO #" + idEnvio + " ======"); 
		System.out.println("Remitente: " + remitente); 
		System.out.println("Destinatario: " + destinatario); 
		System.out.println("Dirección de Entrega: " + direccionEntrega); 
		System.out.println("Estado Actual: " + estado); 
		System.out.println("Peso Total: " + getPesoTotal() + " kg"); 
		System.out.println("Paquetes asociados (" + paquetes.size() + "):"); 
		for (Paquete p : paquetes) { 
			System.out.println(" - " + p); 
		} 
		System.out.println("========================================="); 
	}
    
    // ========= Metodos Auxiliares =========
    // Valida si el envio tiene al menos un pequete asignado
    public boolean tienePaquetes() { return !paquetes.isEmpty(); }
    
    // Calcula el peso total del envio
    public double getPesoTotal() { 
		double pesoTotal = 0.0; 
		for (Paquete p : paquetes) { 
			pesoTotal += p.getPeso(); 
		} 
		return pesoTotal; 
	}
    
    // Getters
    public int getId() { return idEnvio; } 
	public String getRemitente() { return remitente; } 
	public String getDestinatario() { return destinatario; } 
	public String getDireccionEntrega() { return direccionEntrega; } 
	public String getEstado() { return estado; } 
	public List<Paquete> getPaquetes() { return paquetes; }
	
}