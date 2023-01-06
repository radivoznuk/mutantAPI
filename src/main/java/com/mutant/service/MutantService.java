package com.mutant.service;

import org.springframework.stereotype.Service;

import com.mutant.model.Mutant;
import com.mutant.repository.MutantRepository;

@Service
public class MutantService {
	//MINIMO_EQUAL_NITORGEN_BASE indica cuantas veces se debe repetir la base nitrogenada para ser un ADN de MUTANTE
	static final int MINIMO_EQUAL_NITORGEN_BASE = 4; 
	
	private MutantRepository mutantRepository;

	public boolean isMutant(String[] adn) {
		boolean isMutant = false;
		int i = 0;
		int j = 0;
		while (!isMutant && i < adn.length) {
			j = 0;
			while (!isMutant && j < adn[i].length()) {
				isMutant = verifyMutant(i, j, adn);
				j++;
			}
			i++;
		}
		return isMutant;
	}

	private boolean verifyMutant(int i, int j, String[] adn) {
		return (horizontalRepeated(i, j, adn) || verticalRepeated(i, j, adn) || diagonalRepeated(i, j, adn));
	}

	private boolean verticalRepeated(int i, int j, String[] adn) {
		int countEquals = 1;//cantidad repetidos
		//Mientras la fila a analizar más la cantidad necesaria para ser mutante sea menor al tamaño de filas de la matriz
		//y la cantidad de iguales sea menor a la cantidad de iguales necesarios para ser mutante
		//y el caracter en la posición (i,j) es igual al caracter en la posición (i+countEquals,j)
		while ((i+MINIMO_EQUAL_NITORGEN_BASE<adn.length) && (countEquals < MINIMO_EQUAL_NITORGEN_BASE) && (adn[i].charAt(j)==adn[i+countEquals].charAt(j))) {
			countEquals++;
		}
		return (countEquals==MINIMO_EQUAL_NITORGEN_BASE);
	}

	private boolean horizontalRepeated(int i, int j, String[] adn) {
		int countEquals = 1;//cantidad repetidos
		//Mientras la columna a analizar más la cantidad necesaria para ser mutante sea menor al tamaño de columnas de la matriz
		//y la cantidad de iguales sea menor a la cantidad de iguales necesarios para ser mutante
		//y el caracter en la posición (i,j) es igual al caracter en la posición (i,j+countEquals)
		while ((j+MINIMO_EQUAL_NITORGEN_BASE<adn[i].length()) && (countEquals < MINIMO_EQUAL_NITORGEN_BASE) && (adn[i].charAt(j)==adn[i].charAt(j+countEquals))) {
			countEquals++;
		}
		return (countEquals==MINIMO_EQUAL_NITORGEN_BASE);
	}

	private boolean diagonalRepeated(int i, int j, String[] adn) {
		int countEquals = 1;//cantidad repetidos
		//Mientras la columna y fila a analizar más la cantidad necesaria para ser mutante sean menor al tamaño de columnas de la matriz
		//y la cantidad de iguales sea menor a la cantidad de iguales necesarios para ser mutante
		//y el caracter en la posición (i,j) es igual al caracter en la posición (i+countEquals,j+countEquals)
		while ((i+MINIMO_EQUAL_NITORGEN_BASE<adn.length) && (j+MINIMO_EQUAL_NITORGEN_BASE<adn[i].length()) && (countEquals < MINIMO_EQUAL_NITORGEN_BASE) && (adn[i].charAt(j)==adn[i+countEquals].charAt(j+countEquals))) {
			countEquals++;
		}
		return (countEquals==MINIMO_EQUAL_NITORGEN_BASE);
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
}
