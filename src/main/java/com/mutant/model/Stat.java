package com.mutant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
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
}