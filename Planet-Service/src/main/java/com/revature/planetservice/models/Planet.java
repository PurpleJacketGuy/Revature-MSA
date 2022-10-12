package com.revature.planetservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@Data
//@NoArgsConstructor
@Entity
@Table(name = "PLANET")
public class Planet {
	
	@Id
	@Column(name = "planet_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	private double mass;
	
	@Column(name = "orbital_radius")
	private double oribitalRadius;
	
	private boolean rings;

}
