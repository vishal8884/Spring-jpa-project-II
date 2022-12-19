package com.vishal.springdata.relationships.oneToOne.repository;

import org.springframework.data.repository.CrudRepository;

import com.vishal.springdata.relationships.oneToOne.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long>{

}
