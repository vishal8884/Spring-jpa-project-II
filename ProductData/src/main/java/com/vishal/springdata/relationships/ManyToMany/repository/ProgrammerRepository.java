package com.vishal.springdata.relationships.ManyToMany.repository;

import org.springframework.data.repository.CrudRepository;

import com.vishal.springdata.relationships.ManyToMany.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer>{

}
