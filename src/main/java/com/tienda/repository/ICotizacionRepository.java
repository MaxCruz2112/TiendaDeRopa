package com.tienda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tienda.entity.Cotizacion;

@Repository
public interface ICotizacionRepository extends JpaRepository<Cotizacion, Long> {

    // Buscar una cotización por código y vendedor
    @Query("SELECT c FROM Cotizacion c WHERE c.codigo = :codigo AND c.vendedor.id = :vendedorId")
    Optional<Cotizacion> findByCodigoAndVendedorId(String codigo, Long vendedorId);

    // Obtener el último código de cotización registrado
    @Query("SELECT MAX(c.codigo) FROM Cotizacion c")
    Optional<String> findUltimoCodigo();
}
