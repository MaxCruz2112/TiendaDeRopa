package com.tienda.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorColumn(name = "tipo_prenda", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "prendas")
public abstract class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pre_id")
    protected Long id;
    
    @Column(name = "pre_codigo")
    protected String codigo;
    
    @Column(name = "pre_nombre")
    protected String nombre;

    @Column(name = "pre_precio_unitario")
    protected double precioUnitario;

    @Column(name = "pre_cantidad")
    protected int cantidadStock;

    @Column(name = "pre_calidad")
    protected String calidad; // "standard" o "premium"

    @Column(name = "tipo_prenda", insertable = false, updatable = false)
    protected String tipoPrenda; // "CAMISA" o "PANTALON"

    protected double aplicarReglasCalidad(double precioBase) {
        if ("standard".equalsIgnoreCase(calidad)) {
            return precioBase * 1.02; // Aumento del 2% para calidad standard
        } else if ("premium".equalsIgnoreCase(calidad)) {
            return precioBase * 1.15; // Aumento del 15% para calidad premium
        }
        return precioBase;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTipoPrenda() {
		return tipoPrenda;
	}

	public void setTipoPrenda(String tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}

	public abstract double calcularPrecioFinal();
	
}
