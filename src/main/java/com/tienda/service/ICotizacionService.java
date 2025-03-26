package com.tienda.service;

import com.tienda.entity.Cotizacion;
import com.tienda.service.dto.CotizacionRequestDTO;

public interface ICotizacionService {

    // Crear una nueva cotización
    Cotizacion crearCotizacion(CotizacionRequestDTO request);

    // Buscar una cotización por vendedor y código
    Cotizacion buscarCotizacionPorVendedorYCodigo(Long vendedorId, String codigo);   
}
