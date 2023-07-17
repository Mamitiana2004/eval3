package com.project.model;


import java.util.ArrayList;

import com.project.database.annotation.Column;
import com.project.database.annotation.Table;
import com.project.database.object.Entity;

@Table("admin")
public class Admin extends Entity{

	@Column(pk=true,autoComplete = true)
	Integer id;
	
	@Column
	String identifiant;
	
	@Column
	String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
