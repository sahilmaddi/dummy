package com.jpa.fuddu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*import javax.persistence.OneToMany;*/


import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="add_id")
	private Long addId;
	private String city;
	private String addressType;
	/*
	 * @OneToMany(mappedBy="address") private Employee employee;
	 */
}
