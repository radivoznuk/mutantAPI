package com.mutant.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AdnTest {
	
	
	@Test
	@DisplayName("Es un código de ADN Válido")
	void testIsValid_AdnValido() {		
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
	@DisplayName("Es un código de ADN Inválido por no contener A, T, C o G")
	void testIsValid_AdnInvalidoPorBasesNitrogenadasInvalidas() {		
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
