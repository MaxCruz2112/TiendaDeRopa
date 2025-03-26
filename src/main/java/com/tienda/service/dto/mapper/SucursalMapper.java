package com.tienda.service.dto.mapper;

import org.mapstruct.Mapper;

import com.tienda.entity.Sucursal;
import com.tienda.service.dto.SucursalDTO;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SucursalMapper {
	
	SucursalDTO toDTO(Sucursal sucursal);
	
    @Mapping(target = "id", ignore = true)
	Sucursal toEntity(SucursalDTO sucursalDTO);
    
}
