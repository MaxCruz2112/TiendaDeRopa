package com.tienda.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tienda.service.IVendedorService;
import com.tienda.service.dto.VendedorDTO;

@RestController
@RequestMapping("/api/v1/vendedores")
@Tag(name = "Vendedores", description = "Operaciones relacionadas con vendedores")
public class VendedorController {

    @Autowired
    private IVendedorService vendedorService;

    @Operation(
        summary = "Registrar un nuevo vendedor",
        description = "Crea un nuevo vendedor en el sistema"
    )
    @ApiResponse(responseCode = "201", description = "Vendedor registrado exitosamente")
    @PostMapping
    public ResponseEntity<VendedorDTO> registrarVendedor(@RequestBody VendedorDTO vendedorDTO) {
        VendedorDTO nuevoVendedor = vendedorService.crearVendedor(vendedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVendedor);
    }

}
