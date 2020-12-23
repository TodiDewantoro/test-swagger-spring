package com.swaggerspring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_entity")
public class UsersEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "first_name",length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "last_name",length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "kode_leads",length = 50, nullable = false, unique = true)
	private String kodeLeads;
	
	@Column
    @JsonIgnore
    private boolean isActive;
}
