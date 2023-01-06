package com.mutant.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MutantServiceTest {
	MutantService mutantService;

	@Test
	@DisplayName("Es MUTANTE si tiene el primer código genético con alguna base nitrogenada repetida")
	void testIsMutante_BaseRepetidaPrimerGen() {		
		String[] adn = {"AAAAGA",
						"CAGTGC",
						"TTATGT",
						"AGAAGG",
						"CCCCTA",
						"TCACTG"};
		
		assertTrue(mutantService.isMutant(adn));
	}	
	
	@Test
	@DisplayName("Es MUTANTE si tiene el segundo código genético con alguna base nitrogenada repetida")
	void testIsMutante_BaseRepetidaSegundoGen() {		
		String[] adn = {"CAGTGC",
						"ATGGGG",
						"TTATGT",
						"AGAAGG",
						"CCCCTA",
						"TCACTG"};
		
		assertTrue(mutantService.isMutant(adn));
	}
	
	@Test
	@DisplayName("No es MUTANTE si tiene el tercer código genético con alguna base nitrogenada repetida no consecutivas")
	void testIsMutante_BaseRepetidaNoConsecutivaTercerGen() {		
		String[] adn = {"ATTGGA",
						"CAGTGC",
						"TTATGT",
						"AGACTG",
						"AAGCCA",
						"TCACTG"};
		
		assertFalse(mutantService.isMutant(adn));
	}

	@Test
	@DisplayName("Es MUTANTE si tiene el cuarto código genético con alguna base nitrogenada repetida")
	void testIsMutante_BaseRepetidaCuartoGen() {		
		String[] adn = {"CAGTGC",
						"ATGNGG",
						"TTATGT",
						"AGAAGG",
						"CCCCTA",
						"TCACTG"};
		
		assertTrue(mutantService.isMutant(adn));
	}
	
	@Test
	@DisplayName("Es MUTANTE si tiene el cuarto código genético con alguna base nitrogenada repetida")
	void testIsMutante5() {		
		String[] adn = {"CAGTGC",
						"ATGNGG",
						"CTATGT",
						"CGAAGG",
						"CCCGTA",
						"TCACTG"};

		assertTrue(mutantService.isMutant(adn));
	}
	
	@Test
	@DisplayName("NO Es MUTANTE si tiene el cuarto código genético con alguna base nitrogenada repetida")
	void testIsMutante6() {		
		String[] adn = {"CAGTGC",
						"ATGNGG",
						"CTATCT",
						"CGAAGG",
						"CCCGTA",
						"TCACTG"};

		assertFalse(mutantService.isMutant(adn));
	}
	
	@Test
	@DisplayName("ES MUTANTE tiene repetido base nitrogenada en DIAGONAL")
	void testIsMutante7() {		
		String[] adn = {"ATTGGA",
						"CAGTGC",
						"TTATGT",
						"AGAATG",
						"AAGCCA",
						"TCACTG"};
		
		assertTrue(mutantService.isMutant(adn));
	}
}
