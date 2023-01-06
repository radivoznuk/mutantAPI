package com.mutant.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Stat {

	int count_mutant_adn;
	int count_human_adn;
	float ratio;	
	

	public Stat(int countMutants, int countHumans) {
		this.count_mutant_adn = countMutants;
		this.count_human_adn = countHumans;
		this.ratio = (countHumans==0 ? 1 : countMutants / countHumans);
	}
}