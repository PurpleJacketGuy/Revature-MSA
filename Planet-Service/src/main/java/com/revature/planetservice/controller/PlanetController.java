package com.revature.planetservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.planetservice.models.Planet;
import com.revature.planetservice.repo.PlanetRepo;

@RestController
@RequestMapping("/api")
public class PlanetController {

	@Autowired
	PlanetRepo planetRepo;
	
	@GetMapping("/planets")
	public List<Planet> getAllPlanets(){
		return this.planetRepo.findAll();
	}
}
