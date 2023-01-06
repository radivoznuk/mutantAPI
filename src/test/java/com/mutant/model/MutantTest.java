package com.mutant.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MutantTest {	
	
	@Test
	@DisplayName("Compara dos mutantes")
	void testEqualMutants() {		
		String[] code = {"AAAAGA",
						"CAGCCA",
						"TTATGT",
						"AGAAGG",
						"CCCCTA",
						"TCACTG"};
		Mutant mutanteEsperado =  new Mutant(String.join(",", code), false);

		Mutant mutante =  new Mutant(String.join(",", code), false);
	
		assertEquals(mutanteEsperado, mutante);
	}
}
