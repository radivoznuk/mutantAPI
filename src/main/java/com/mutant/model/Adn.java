package com.mutant.model;

public class Adn {

	private String[] code;
	
	public Adn(String[] code) {
		this.code = code;
	}

	public String[] getCode() {
		return code;
	}

	public void setAdn(String[] code) {
		this.code = code;
	}

	public String toString() {
		return String.join(",", this.code);
	}
	
	public boolean isEmpty() {
		return (this.code.length == 0);
	}

	public Mutant createtMutant(boolean isMutant) {
		return new Mutant(String.join(",", this.code), isMutant);
	}

	public boolean isValid() {
		return (isNitrogenBase() && isValidStructure());
	}

	private boolean isNitrogenBase() {
		//El ADN sólo puede contener las base nitrogenada del ADN sólo pueden ser: A, T, C y G
		String adn = String.join(",", this.code).toUpperCase().replace(",", "");
		return (adn.matches("[ATCG]+"));
	}

	private boolean isValidStructure() {
		//El ADN debe ser NxN
		boolean validStructure = true;
		int i = 0;
		while (validStructure && i < this.code.length) {
			validStructure = (this.code[i].length() == this.code.length);
			i++;
		}
		return validStructure;
	}
}
