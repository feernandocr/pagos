package com.banco.base.pagosbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.base.pagosbase.entity.PagoEntity;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, Long> {

}
