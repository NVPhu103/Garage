package com.example.garage.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serNumber;
	private String serName;
	private double serPrice;
	private String serDescription;
	
	@OneToMany(mappedBy = "service", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RepairedCarSer> repairedCarService;

	public CarService(String serName, double serPrice, String serDescription) {
		super();
		this.serName = serName;
		this.serPrice = serPrice;
		this.serDescription = serDescription;
	}
	
	
}
