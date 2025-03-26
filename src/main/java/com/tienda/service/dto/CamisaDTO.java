package com.tienda.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CamisaDTO extends PrendaDTO {

    private String codigo;
    private String nombre;
    private double precioUnitario;
    private int cantidadStock;
    private String calidad;
    private String tipoManga;
    private String tipoCuello;
    
    @Override
    public double calcularPrecioFinal() {
        double precioBase = precioUnitario;

        // Rebaja del 10% si es manga corta
        if ("corta".equalsIgnoreCase(tipoManga)) {
            precioBase *= 0.90;
        }

        // Aumento del 3% si tiene cuello mao
        if ("mao".equalsIgnoreCase(tipoCuello)) {
            precioBase *= 1.03;
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
	public String getTipoManga() {
		return tipoManga;
	}
	public void setTipoManga(String tipoManga) {
		this.tipoManga = tipoManga;
	}
	public String getTipoCuello() {
		return tipoCuello;
	}
	public void setTipoCuello(String tipoCuello) {
		this.tipoCuello = tipoCuello;
	}
    
    
   
}
