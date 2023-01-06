package com.mutant.model;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Adn {

	private String[] adn;

	public String toString() {
		return String.join(",", this.adn);
	}
	
	public boolean isEmpty() {
		return (this.adn.length == 0);
	}

	public Mutant createtMutant(boolean isMutant) {
		return new Mutant(String.join(",", this.adn), isMutant);
	}

	public boolean isValid() {
		return (isNitrogenBase() || isValidStructure());
	}

	private boolean isNitrogenBase() {
		//El ADN sólo puede contener las base nitrogenada del ADN sólo pueden ser: A, T, C y G
		String adn = String.join(",", this.adn);
		Pattern pattern = Pattern.compile("[ATCG]");
		Matcher matcher = pattern.matcher(adn);
		return matcher.matches();
	}

	private boolean isValidStructure() {
		//El ADN debe ser NxN
		boolean validStructure = true;
		int i = 0;
		while (validStructure && i < this.adn.length) {
			validStructure = (this.adn[i].length() == this.adn.length);
			i++;
		}
		return validStructure;
	}
}
