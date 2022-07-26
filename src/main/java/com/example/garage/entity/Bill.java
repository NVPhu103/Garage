package com.example.garage.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter 
@Entity
@Table(name = "bills")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Bill_number", columnDefinition = "BIGINT(19)")
	private Long billNumber;
	
	@Column(name = "Bill_method", columnDefinition = "NVARCHAR(50)")
	private String billMethod;
	
	@Column(name = "Bill_amount", columnDefinition = "BIGINT(19)")
	private Long billAmount;
	
	@Column(name = "Bill_date", columnDefinition = "DATE" )
	@Temporal(TemporalType.DATE)
	private Date billDate;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "ReCar_id")
//	private RepairedCar repairedCar;
	
}
