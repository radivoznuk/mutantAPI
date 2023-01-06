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
		final int countEquals2BeMutant = 4;//se deja una constante que indica cuantos deben ser iguales para ser mutante
		return (horizontalRepeated(i, j, adn, countEquals2BeMutant) || verticalRepeated(i, j, adn, countEquals2BeMutant) || diagonalRepeated(i, j, adn, countEquals2BeMutant));
	}

	private boolean verticalRepeated(int i, int j, String[] adn, int countEquals2BeMutant) {
		int countEquals = 1;//cantidad repetidos
		//mientras la fila a analizar mas la cantidad necesaria para ser mutante sea menor al tamaño de filas de la matriz
		//y la cantidad de iguales sea menor a la cantidad de iguales necesarios para ser mutante
		//y el caracter en la posicion (i,j) es igual al caracter en la posicion (i+countEquals,j)
		while ((i+countEquals2BeMutant<adn.length) && (countEquals < countEquals2BeMutant) && (adn[i].charAt(j)==adn[i+countEquals].charAt(j))) {
			countEquals++;
		}
		return (countEquals==countEquals2BeMutant);
	}

	private boolean horizontalRepeated(int i, int j, String[] adn, int countEquals2BeMutant) {
		int countEquals = 1;//cantidad repetidos
		//mientras la columna a analizar mas la cantidad necesaria para ser mutante sea menor al tamaño de columnas de la matriz
		//y la cantidad de iguales sea menor a la cantidad de iguales necesarios para ser mutante
		//y el caracter en la posicion (i,j) es igual al caracter en la posicion (i,j+countEquals)
		while ((j+countEquals2BeMutant<adn[i].length()) && (countEquals < countEquals2BeMutant) && (adn[i].charAt(j)==adn[i].charAt(j+countEquals))) {
			countEquals++;
		}
		return (countEquals==countEquals2BeMutant);
	}

	private boolean diagonalRepeated(int i, int j, String[] adn, int countEquals2BeMutant) {
		int countEquals = 1;//cantidad repetidos
		//mientras la columna y fila a analizar mas la cantidad necesaria para ser mutante sean menor al tamaño de columnas de la matriz
		//y la cantidad de iguales sea menor a la cantidad de iguales necesarios para ser mutante
		//y el caracter en la posicion (i,j) es igual al caracter en la posicion (i+countEquals,j+countEquals)
		while ((i+countEquals2BeMutant<adn.length) && (j+countEquals2BeMutant<adn[i].length()) && (countEquals < countEquals2BeMutant) && (adn[i].charAt(j)==adn[i+countEquals].charAt(j+countEquals))) {
			countEquals++;
		}
		return (countEquals==countEquals2BeMutant);
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
