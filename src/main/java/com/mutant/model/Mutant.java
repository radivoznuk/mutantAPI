package com.mutant.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("mutants")
public class Mutant {

	@Id
	private String adn;
	private boolean isMutant;

	public Mutant(String adn, boolean isMutant) {
		this.adn = adn;
		this.isMutant = isMutant;
	}

	public Mutant() {}
					

	public String getAdn() {
		return adn;
	}

	public void setAdn(String adn) {
		this.adn = adn;
	}

	public boolean isMutant() {
		return isMutant;
	}

	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}
	
}
