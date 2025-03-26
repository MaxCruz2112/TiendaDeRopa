package com.tienda.service.dto;

import lombok.Data;

@Data
public class PantalonDTO extends PrendaDTO {
    private String codigo;
    private String nombre;
    private double precioUnitario;
    private int cantidadStock;
    private String calidad;
    private String tipoPantalon;
    
    @Override
    public double calcularPrecioFinal() {
        double precioBase = precioUnitario;

        // Rebaja del 12% si es chupín
        if ("chupin".equalsIgnoreCase(tipoPantalon)) {
            precioBase *= 0.88;
        }

        return aplicarReglasCalidad(precioBase);
    }
    
    protected double aplicarReglasCalidad(double precioBase) {
        if ("standard".equalsIgnoreCase(calidad)) {
            return precioBase * 1.02; // Aumento del 2% para calidad standard
        } else if ("premium".equalsIgnoreCase(calidad)) {
            return precioBase * 1.15; // Aumento del 15% para calidad premium
        }
        return precioBase;
    }
    
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getCantidadStock() {
		return cantidadStock;
	}
	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
	public String getCalidad() {
		return calidad;
	}
	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}
	public String getTipoPantalon() {
		return tipoPantalon;
	}
	public void setTipoPantalon(String tipoPantalon) {
		this.tipoPantalon = tipoPantalon;
	}
    
    
}
