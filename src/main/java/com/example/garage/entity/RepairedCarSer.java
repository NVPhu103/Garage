package com.example.garage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RepairedCarSer {
	
	@EmbeddedId
	private CompositePK id = new CompositePK();
	
	@ManyToOne
	@MapsId("ReCar_id")
	@JoinColumn(name = "ReCar_id")
	private RepairedCar repairedCar;
	
	@ManyToOne
	@MapsId("ser_number")
	@JoinColumn(name = "ser_number")
	private Service service;
	
	private double serPrice;
	
	
	
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class CompositePK implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Column(name = "ReCar_id")
		private Long reCarId;
		@Column(name = "ser_number")
		private Long serNumber;
	}
}
