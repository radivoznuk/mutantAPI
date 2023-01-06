package com.mutant.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("mutants")
public class Mutant {

	@Id
	private String adn;
	private boolean isMutant;

	public Mutant(String adn, boolean isMutant) {
		this.adn = adn;
		this.isMutant = isMutant;
	}
}
