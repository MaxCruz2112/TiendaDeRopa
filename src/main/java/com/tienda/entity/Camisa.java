package com.tienda.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("CAMISA")
public class Camisa extends Prenda {
    
    @Column(name = "pre_tipo_manga")
    private String tipoManga; // "corta" o "larga"

    @Column(name = "pre_tipo_cuello")
    private String tipoCuello; // "mao" o "común"

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
