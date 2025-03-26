package com.tienda.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tienda.service.ISucursalService;
import com.tienda.service.dto.SucursalDTO;

@RestController
@RequestMapping("/api/v1/sucursales")
@Tag(name = "Sucursales", description = "Operaciones relacionadas con sucursales")
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;

    @Operation(
        summary = "Registrar una nueva sucursal",
        description = "Crea una nueva sucursal en el sistema"
    )
    @ApiResponse(responseCode = "201", description = "Sucursal registrada exitosamente")
    @PostMapping
    public ResponseEntity<SucursalDTO> registrarSucursal(@RequestBody SucursalDTO sucursalDTO) {
        SucursalDTO nuevaSucursal = sucursalService.crearSucursal(sucursalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSucursal);
    }

}
