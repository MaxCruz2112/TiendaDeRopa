package com.tienda.service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CotizacionRequestDTO {

    private Long vendedorId; // ID del vendedor
    private Long sucursalId; // ID de la sucursal
    private List<DetalleCotizacionDTO> detalles; // Detalles de la cotización
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetalleCotizacionDTO {
        private Long prendaId; // ID de la prenda
        private Integer cantidad; // Cantidad de la prenda
        
		public Long getPrendaId() {
			return prendaId;
		}
		public void setPrendaId(Long prendaId) {
			this.prendaId = prendaId;
		}
		public Integer getCantidad() {
			return cantidad;
		}
		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}
        
        
    }

	public Long getVendedorId() {
		return vendedorId;
	}

	public void setVendedorId(Long vendedorId) {
		this.vendedorId = vendedorId;
	}

	public Long getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}

	public List<DetalleCotizacionDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleCotizacionDTO> detalles) {
		this.detalles = detalles;
	}
    
    
}
