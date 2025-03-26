package com.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tienda.entity.Cotizacion;
import com.tienda.service.ICotizacionService;
import com.tienda.service.dto.CotizacionRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/cotizaciones")
@Tag(name = "Cotizaciones", description = "Operaciones relacionadas con cotizaciones")
public class CotizacionController {

    @Autowired
    private ICotizacionService cotizacionService;

    @Operation(
            summary = "Registrar una nueva cotización",
            description = "Crea una nueva cotización en el sistema"
    )
    @ApiResponse(responseCode = "201", description = "Cotización registrada exitosamente")
    @PostMapping
    public ResponseEntity<Void> crearCotizacion(@RequestBody CotizacionRequestDTO request) {
        cotizacionService.crearCotizacion(request);
        return ResponseEntity.status(201).build(); // Código HTTP 201 Created
    }

    @Operation(
            summary = "Obtener una cotización por ID de vendedor y código",
            description = "Devuelve los detalles de una cotización específica"
    )
    @ApiResponse(responseCode = "200", description = "Cotización encontrada")
    @ApiResponse(responseCode = "404", description = "Cotización no encontrada")
    @GetMapping("/vendedor/{vendedorId}/codigo/{codigo}")
    public ResponseEntity<Cotizacion> obtenerCotizacionPorVendedorYCodigo(
            @PathVariable Long vendedorId,
            @PathVariable String codigo) {
        Cotizacion cotizacion = cotizacionService.buscarCotizacionPorVendedorYCodigo(vendedorId, codigo);
        return ResponseEntity.ok(cotizacion);
    }

}
