package com.tienda.controller;

import com.tienda.service.IPrendaService;
import com.tienda.service.dto.CamisaDTO;
import com.tienda.service.dto.PantalonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prendas")
@Tag(name = "Prendas", description = "Operaciones relacionadas con prendas")
public class PrendaController {

    @Autowired
    private IPrendaService prendaService;

    @Operation(
            summary = "Registrar una nueva camisa",
            description = "Crea una nueva camisa en el sistema"
    )
    @ApiResponse(responseCode = "201", description = "Camisa registrada exitosamente")
    @PostMapping("/camisas")
    public ResponseEntity<CamisaDTO> registrarCamisa(@RequestBody CamisaDTO camisaDTO) {
        CamisaDTO camisaRegistrada = prendaService.registrarCamisa(camisaDTO);
        return ResponseEntity.status(201).body(camisaRegistrada);
    }

    @Operation(
            summary = "Registrar un nuevo pantalón",
            description = "Crea un nuevo pantalón en el sistema"
    )
    @ApiResponse(responseCode = "201", description = "Pantalón registrado exitosamente")
    @PostMapping("/pantalones")
    public ResponseEntity<PantalonDTO> registrarPantalon(@RequestBody PantalonDTO pantalonDTO) {
        PantalonDTO pantalonRegistrado = prendaService.registrarPantalon(pantalonDTO);
        return ResponseEntity.status(201).body(pantalonRegistrado);
    }
   
}