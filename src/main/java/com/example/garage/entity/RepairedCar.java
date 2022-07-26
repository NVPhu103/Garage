package com.example.garage.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairedCar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReCar_id")
	private Long reCarId;

	@Column(name = "ReCar_startingdate")
	private LocalDateTime reCarStartingDate;

	@Column(name = "ReCar_endingdate")
	private LocalDateTime reCarEndingDate;

	@Column(name = "ReCar_description")
	private String reCarDescription;

	@Column(name = "ReCar_type")
	private String reCarType;

	@Column(name = "ReCar_number")
	private String reCarNumber;

	@Column(name = "ReCar_status")
	private String reCarStatus;

	@OneToMany(mappedBy = "repairedCar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RepairedCarSer> repairedCarService;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cus_id", nullable = false) 
	private Customer customer;
	 

	@OneToOne(mappedBy = "repairedCar", fetch = FetchType.LAZY, cascade =CascadeType.ALL) 
	private Bill bill;
	 

	@OneToMany(mappedBy = "repairedCar", fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private Set<GoodsCar> goodsCars;

}
