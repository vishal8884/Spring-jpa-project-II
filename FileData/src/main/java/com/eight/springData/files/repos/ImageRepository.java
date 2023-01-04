package com.eight.springData.files.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eight.springData.files.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
