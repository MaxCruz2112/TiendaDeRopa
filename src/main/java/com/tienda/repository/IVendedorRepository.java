package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entity.Vendedor;

@Repository
public interface IVendedorRepository extends JpaRepository<Vendedor, Long> {

}
