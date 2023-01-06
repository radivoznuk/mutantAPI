package com.mutant.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AdnTest {
	
	
	@Test
	@DisplayName("Es un código de ADN Válido")
	void testIsValid_CodigoAdnValido() {		
		String[] code =  {"AAAAGA",
				"CAGTGC",
				"TTATGT",
				"AGAAGG",
				"CCCCTA",
				"TCACTG"};
		Adn adn = new Adn(code);
	
		assertTrue(adn.isValid());
	}
	
	@Test
	@DisplayName("Es un código de ADN Inválido")
	void testIsValid_CodigoAdnInvalido() {		
		String[] code = {"AAAAGA",
						"CAGHRH",
						"TTATGT",
						"AGAAGG",
						"CCCCTA",
						"TCACTG"};
		Adn adn = new Adn(code);
	
		assertFalse(adn.isValid());
	}
}
