package com.revature.planetservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.planetservice.models.Planet;


public interface PlanetRepo extends JpaRepository<Planet, Integer> {

	List<Planet> findAll();
}
