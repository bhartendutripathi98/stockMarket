package com.bhartendu.companyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhartendu.companyservice.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

}
