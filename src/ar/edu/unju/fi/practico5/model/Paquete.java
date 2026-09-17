package ar.edu.unju.fi.practico5.model;

public class Paquete {
    private String codigoPaquete; 
    private String descripcion;
    private double peso;
    private double volumen;
    
    public Paquete(String codigoPaquete, String descripcion, double peso, double volumen) {
		this.codigoPaquete = codigoPaquete;
		this.descripcion = descripcion;
		this.peso = peso;
		this.volumen = volumen;
	}
    
    // Getters
    public String getCodigo() { return codigoPaquete; } 
	public String getDescripcion() { return descripcion; } 
	public double getPeso() { return peso; } 
	public double getVolumen() { return volumen; } 
	
	@Override 
	public String toString() { 
		return "Paquete[" + codigoPaquete + " | " + descripcion + " | " + peso + "kg | " + volumen + "dm3]"; 
	}
}