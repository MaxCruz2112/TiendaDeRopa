package com.tienda.service.dto.mapper;

import com.tienda.entity.Camisa;
import com.tienda.entity.Pantalon;
import com.tienda.entity.Prenda;
import com.tienda.service.dto.CamisaDTO;
import com.tienda.service.dto.PantalonDTO;
import com.tienda.service.dto.PrendaDTO;
import org.springframework.stereotype.Service;

@Service
public class PrendaMapper {

    // Método para convertir una entidad Prenda a un DTO Prenda
    public PrendaDTO toDTO(Prenda prenda) {
        if (prenda instanceof Pantalon) {
            return toPantalonDTO((Pantalon) prenda);
        } else if (prenda instanceof Camisa) {
            return toCamisaDTO((Camisa) prenda);
        }
        throw new IllegalArgumentException("Tipo de prenda no soportado: " + prenda.getClass().getName());
    }

    // Método para convertir una entidad Pantalon a un DTO PantalonDTO
    public PantalonDTO toPantalonDTO(Pantalon pantalon) {
        PantalonDTO dto = new PantalonDTO();
        mapCommonFields(dto, pantalon);
        dto.setTipoPantalon(pantalon.getTipoPantalon());
        return dto;
    }

    // Método para convertir una entidad Camisa a un DTO CamisaDTO
    public CamisaDTO toCamisaDTO(Camisa camisa) {
        CamisaDTO dto = new CamisaDTO();
        mapCommonFields(dto, camisa);
        dto.setTipoManga(camisa.getTipoManga());
        dto.setTipoCuello(camisa.getTipoCuello());
        return dto;
    }

    // Método para mapear los campos comunes entre Prenda y PrendaDTO
    private void mapCommonFields(PrendaDTO dto, Prenda prenda) {
        dto.setCodigo(prenda.getCodigo());
        dto.setNombre(prenda.getNombre());
        dto.setPrecioUnitario(prenda.getPrecioUnitario());
        dto.setCantidadStock(prenda.getCantidadStock());
        dto.setCalidad(prenda.getCalidad());
        dto.setTipoPrenda(prenda.getTipoPrenda());
    }

    // Método para convertir un DTO Prenda a una entidad Prenda
    public Prenda toEntity(PrendaDTO dto) {
        if ("PANTALON".equalsIgnoreCase(dto.getTipoPrenda())) {
            return toPantalonEntity((PantalonDTO) dto);
        } else if ("CAMISA".equalsIgnoreCase(dto.getTipoPrenda())) {
            return toCamisaEntity((CamisaDTO) dto);
        }
        throw new IllegalArgumentException("Tipo de prenda no soportado: " + dto.getTipoPrenda());
    }

    // Método para convertir un DTO PantalonDTO a una entidad Pantalon
    public Pantalon toPantalonEntity(PantalonDTO dto) {
        Pantalon pantalon = new Pantalon();
        mapCommonFields(pantalon, dto);
        pantalon.setTipoPantalon(dto.getTipoPantalon());
        return pantalon;
    }

    // Método para convertir un DTO CamisaDTO a una entidad Camisa
    public Camisa toCamisaEntity(CamisaDTO dto) {
        Camisa camisa = new Camisa();
        mapCommonFields(camisa, dto);
        camisa.setTipoManga(dto.getTipoManga());
        camisa.setTipoCuello(dto.getTipoCuello());
        return camisa;
    }

    // Método para mapear los campos comunes entre PrendaDTO y Prenda
    private void mapCommonFields(Prenda prenda, PrendaDTO dto) {
        prenda.setCodigo(dto.getCodigo());
        prenda.setNombre(dto.getNombre());
        prenda.setPrecioUnitario(dto.getPrecioUnitario());
        prenda.setCantidadStock(dto.getCantidadStock());
        prenda.setCalidad(dto.getCalidad());
        prenda.setTipoPrenda(dto.getTipoPrenda());
    }
}
