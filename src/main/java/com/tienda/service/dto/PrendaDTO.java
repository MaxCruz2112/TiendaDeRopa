package com.tienda.service.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipoPrenda")
@JsonSubTypes({
	@JsonSubTypes.Type(value = PantalonDTO.class, name = "PANTALON"),
	@JsonSubTypes.Type(value = CamisaDTO.class, name = "CAMISA")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PrendaDTO {
	protected String tipoPrenda;
	protected String codigo;
    protected String nombre;
    protected double precioUnitario;
    protected int cantidadStock;
    protected String calidad;
        
    public abstract double calcularPrecioFinal();
    
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
	public String getTipoPrenda() {
		return tipoPrenda;
	}
	public void setTipoPrenda(String tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}
	
	
				
}
