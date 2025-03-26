package com.tienda.service.imp;

import com.tienda.entity.Camisa;
import com.tienda.entity.Pantalon;
import com.tienda.repository.IPrendaRepository;
import com.tienda.service.IPrendaService;
import com.tienda.service.dto.CamisaDTO;
import com.tienda.service.dto.PantalonDTO;
import com.tienda.service.dto.mapper.PrendaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrendaServiceImpl implements IPrendaService {

    @Autowired
    private IPrendaRepository prendaRepository;

    @Autowired
    private PrendaMapper prendaMapper;

    @Override
    public CamisaDTO registrarCamisa(CamisaDTO camisaDTO) {
        Camisa camisa = prendaMapper.toCamisaEntity(camisaDTO);
        Camisa camisaGuardada = (Camisa) prendaRepository.save(camisa);
        return prendaMapper.toCamisaDTO(camisaGuardada);
    }

    @Override
    public PantalonDTO registrarPantalon(PantalonDTO pantalonDTO) {
        Pantalon pantalon = prendaMapper.toPantalonEntity(pantalonDTO);
        Pantalon pantalonGuardado = (Pantalon) prendaRepository.save(pantalon);
        return prendaMapper.toPantalonDTO(pantalonGuardado);
    }

}
