package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entity.DetalleCotizacion;

@Repository
public interface IDetalleCotizacionRepository extends JpaRepository<DetalleCotizacion, Long> {

}
