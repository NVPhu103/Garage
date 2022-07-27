package com.example.garage.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "repairedCars")
@Data
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cus_id", columnDefinition = "BIGINT(19)")
	private Long cusID;
	
	@Column(name = "Cus_firstname", columnDefinition = "NVARCHAR(50)", nullable = false)
	private String cusFirstName;
	
	@Column(name = "Cus_lastname", columnDefinition = "NVARCHAR(50)")
	private String cusLastName;
	
	@Column(name = "Cus_address", columnDefinition = "NVARCHAR(255)")
	private String cusAddress;
	
	@Column(name = "Cus_phone", columnDefinition = "VARCHAR(12)")
	private String cusPhone;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RepairedCar> repairedCars;
	
}
