package com.tienda.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("PANTALON")
public class Pantalon extends Prenda {

    @Column(name = "pre_tipo_pantalon")
    private String tipoPantalon; // "común" o "chupín"

    @Override
    public double calcularPrecioFinal() {
        double precioBase = precioUnitario;

        // Rebaja del 12% si es chupín
        if ("chupin".equalsIgnoreCase(tipoPantalon)) {
            precioBase *= 0.88;
        }

        return aplicarReglasCalidad(precioBase);
    }

	public String getTipoPantalon() {
		return tipoPantalon;
	}

	public void setTipoPantalon(String tipoPantalon) {
		this.tipoPantalon = tipoPantalon;
	}

	
}
