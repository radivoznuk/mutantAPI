package com.mutant.service;

import org.springframework.stereotype.Service;

import com.mutant.model.Mutant;
import com.mutant.repository.MutantRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@Data
@RequiredArgsConstructor
public class MutantService {
	private final MutantRepository mutantRepository;

	public boolean isMutant(String[] adn) {
		boolean isMutant = false;
		int i, j;
		i = j = 0;
		while (!isMutant && i < adn.length) {
			while (!isMutant && j < adn[i].length()) {
				isMutant = verifyMutant(i, j, adn);
				j++;
			}
			j = 0;
			i++;
		}
		return isMutant;
	}

	public void save(Mutant mutant) {
		mutantRepository.save(mutant);
	}
	
	public int countHumans() {
		return mutantRepository.countFindByIsMutant(false);
	}
	
	public int countMutants() {
		return mutantRepository.countFindByIsMutant(true);
	}

	private boolean verifyMutant(int i, int j, String[] adn) {
		return (horRepeated(i, j, adn) || verRepeated(i, j, adn) || diagRepeated(i, j, adn));
	}

	private boolean verRepeated(int i, int j, String[] adn) {
		if (i < adn.length - 3)
			return ((adn[i].charAt(j) == adn[i + 1].charAt(j)) && (adn[i + 1].charAt(j) == adn[i + 2].charAt(j))
					&& (adn[i + 2].charAt(j) == adn[i + 3].charAt(j)));
		else
			return false;

	}

	private boolean horRepeated(int i, int j, String[] adn) {
		if (j < adn[i].length() - 3)
			return ((adn[i].charAt(j) == adn[i].charAt(j + 1)) && (adn[i].charAt(j + 1) == adn[i].charAt(j + 2))
					&& (adn[i].charAt(j + 2) == adn[i].charAt(j + 3)));
		else
			return false;
	}

	private boolean diagRepeated(int i, int j, String[] adn) {
		if ((j < adn[i].length() - 3) && (i < adn.length - 3))
			return ((adn[i].charAt(j) == adn[i + 1].charAt(j + 1))
					&& (adn[i + 1].charAt(j + 1) == adn[i + 2].charAt(j + 2))
					&& (adn[i + 2].charAt(j + 2) == adn[i + 3].charAt(j + 3)));
		else
			return false;
	}

	public Object getCountMutants() {
		// TODO Auto-generated method stub
		return null;
	}

}
