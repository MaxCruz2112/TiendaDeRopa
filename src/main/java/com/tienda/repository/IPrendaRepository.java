package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entity.Prenda;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long> {

}
