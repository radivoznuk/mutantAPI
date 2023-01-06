package com.mutant.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MutantServiceTest {
	MutantService mutantService = new MutantService();

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
	@DisplayName("Es MUTANTE si tiene alguna base nitrogenada repetida verticalmente")
	void BaseRepetidaVerticalmente() {		
		String[] adn = {"CAGTGC",
						"ATGNGG",
						"CTATGT",
						"CGAAGG",
						"CCCGTA",
						"TCACTG"};

		assertTrue(mutantService.isMutant(adn));
	}
	
	@Test
	@DisplayName("NO Es MUTANTE si tiene alguna base nitrogenada repetida verticalmente no consecutiva")
	void testIsMutante_BaseRepetidaVerticalmenteNoConsecutiva() {		
		String[] adn = {"CAGTGC",
						"ATGNGG",
						"CTATCT",
						"CGAAGG",
						"CCCGTA",
						"TCACTG"};

		assertFalse(mutantService.isMutant(adn));
	}
	
	@Test
	@DisplayName("ES MUTANTE tiene repetida alguna base nitrogenada digonalmente")
	void testIsMutante_BaseRepetidaDiagonalmente() {		
		String[] adn = {"ATTGGA",
						"CAGTGC",
						"TTATGT",
						"AGAATG",
						"AAGCCA",
						"TCACTG"};
		
		assertTrue(mutantService.isMutant(adn));
	}
}
