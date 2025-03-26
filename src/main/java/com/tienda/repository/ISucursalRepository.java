package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entity.Sucursal;

@Repository
public interface ISucursalRepository extends JpaRepository<Sucursal, Long> {

}
