package com.eight.clinicals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eight.clinicals.entities.ClinicalData;

public interface ClinicalRepository extends JpaRepository<ClinicalData, Integer>{

}
