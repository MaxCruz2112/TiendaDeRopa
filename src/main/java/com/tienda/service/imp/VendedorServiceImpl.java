package com.tienda.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.entity.Vendedor;
import com.tienda.repository.IVendedorRepository;
import com.tienda.service.IVendedorService;
import com.tienda.service.dto.VendedorDTO;
import com.tienda.service.dto.mapper.VendedorMapper;
import com.tienda.entity.Sucursal;
import com.tienda.repository.ISucursalRepository;

import java.util.Optional;

@Service
public class VendedorServiceImpl implements IVendedorService {

    @Autowired
    private IVendedorRepository vendedorRepository;

    @Autowired
    private ISucursalRepository sucursalRepository;

    @Autowired
    private VendedorMapper vendedorMapper;
    
    @Override
    public VendedorDTO crearVendedor(VendedorDTO vendedorDTO) {
        // Mapear el DTO a la entidad
        Vendedor vendedor = vendedorMapper.toEntity(vendedorDTO);

        // Si sucursalId no es null, buscamos la sucursal y la asignamos al vendedor
        if (vendedorDTO.getSucursalId() != null) {
            Optional<Sucursal> sucursal = sucursalRepository.findById(vendedorDTO.getSucursalId());
            sucursal.ifPresent(vendedor::setSucursal); // Asignamos la sucursal al vendedor
        }

        // Guardamos el vendedor en la base de datos
        Vendedor nuevoVendedor = vendedorRepository.save(vendedor);

        // Mapear la entidad a DTO para la respuesta
        return vendedorMapper.toDTO(nuevoVendedor);
    }
       
}
