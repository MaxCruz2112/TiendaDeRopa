package com.tienda.service.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.tienda.entity.Vendedor;
import com.tienda.service.dto.VendedorDTO;

@Mapper(componentModel = "spring")
public interface VendedorMapper {
	
	@Mappings({
        @Mapping(source = "sucursal.id", target = "sucursalId")
    })
    VendedorDTO toDTO(Vendedor vendedor);
	
    @Mappings({
        @Mapping(target = "id", ignore = true), 
        @Mapping(source = "sucursalId", target = "sucursal.id")
    })
    Vendedor toEntity(VendedorDTO vendedorDTO);
       
}
