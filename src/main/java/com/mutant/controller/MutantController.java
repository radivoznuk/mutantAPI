package com.mutant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutant.model.Adn;
import com.mutant.model.Mutant;
import com.mutant.model.Stat;

import com.mutant.service.MutantService;

@RestController
@RequestMapping("/")
public class MutantController {
	private final MutantService mutantService = new MutantService();
		
	@PostMapping(value="/mutant/", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> isMutant(@NonNull @RequestBody Adn code){
		Mutant mutant;
		
		if (code.isEmpty()) {
			return new ResponseEntity<>("ADN Vacío", HttpStatus.NO_CONTENT);		
		}
		if (!code.isValid()) {
			return new ResponseEntity<>("ADN Inválido", HttpStatus.BAD_REQUEST);		
		}
		
		mutant = code.createtMutant(this.mutantService.isMutant(code.getCode()));
		mutantService.save(mutant);
		if (mutant.isMutant()){
			return new ResponseEntity<>(code.toString() + " ES un mutante", HttpStatus.OK);		
		}
		return new ResponseEntity<>(code.toString() + " NO ES un mutante", HttpStatus.FORBIDDEN);		
	}
	
	@GetMapping(value="/stats", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Stat> getStats(){
		Stat stat = new Stat(this.mutantService.countMutants(),this.mutantService.countHumans());
		return new ResponseEntity<>(stat, HttpStatus.OK);		
	}
	
	
}
