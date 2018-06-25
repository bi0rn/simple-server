package ch.bearware.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Elefant {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	private String name;

	// Default constructor for JPA
	public Elefant() {
	}

	public Elefant(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
