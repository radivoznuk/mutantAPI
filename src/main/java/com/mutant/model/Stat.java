package com.mutant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stat {

	@JsonProperty("Count Mutant ADN")
	int countMutantAdn;
	@JsonProperty("Count Human ADN")
	int countHumanAdn;
	@JsonProperty("Ratio")
	float ratio;		

	public Stat(int countMutants, int countHumans) {
		this.countMutantAdn = countMutants;
		this.countHumanAdn = countHumans;
		this.ratio = (countHumans==0 ? 1 : (float)countMutants / (float)countHumans);
	}

	public int getCountMutantAdn() {
		return countMutantAdn;
	}

	public void setCountMutantAdn(int countMutantAdn) {
		this.countMutantAdn = countMutantAdn;
	}

	public int getCountHumanAdn() {
		return countHumanAdn;
	}

	public void setCountHumanAdn(int countHumanAdn) {
		this.countHumanAdn = countHumanAdn;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}	
}