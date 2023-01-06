package com.mutant.model;

import java.util.Objects;

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

	public Mutant() {
	}

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

	 @Override
	    public boolean equals(Object object) {
	        if (this == object) {
	            return true;
	        }
	        if (object == null) {
	            return false;
	        }
	        if (!(object instanceof Mutant)) {
	            return false;
	        }
	        Mutant that = (Mutant) object;
	        return Objects.equals(this.adn, that.adn)
	            && Objects.equals(this.isMutant, that.isMutant);
	    }
}
