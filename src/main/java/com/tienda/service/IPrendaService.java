package com.tienda.service;

import com.tienda.service.dto.CamisaDTO;
import com.tienda.service.dto.PantalonDTO;

public interface IPrendaService {
	
    // Registrar una nueva camisa
    CamisaDTO registrarCamisa(CamisaDTO camisaDTO);

    // Registrar un nuevo pantalón
    PantalonDTO registrarPantalon(PantalonDTO pantalonDTO);

}
