package com.tienda.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.entity.Sucursal;
import com.tienda.repository.ISucursalRepository;
import com.tienda.service.ISucursalService;
import com.tienda.service.dto.SucursalDTO;
import com.tienda.service.dto.mapper.SucursalMapper;

@Service
public class SucursalServiceImpl implements ISucursalService {

    @Autowired
    private ISucursalRepository sucursalRepository;

    @Autowired
    private SucursalMapper sucursalMapper;

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursalDTO) {
        // Mapear DTO a Entidad
        Sucursal sucursal = sucursalMapper.toEntity(sucursalDTO);

        // Guardar la sucursal en la base de datos
        Sucursal nuevaSucursal = sucursalRepository.save(sucursal);

        // Mapear la entidad de vuelta a DTO
        return sucursalMapper.toDTO(nuevaSucursal);
    }
 
}
