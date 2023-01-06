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

import com.mutant.model.Mutant;
import com.mutant.model.Stat;
import com.mutant.service.MutantService;
import com.mutant.wrapper.ADNWrapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MutantController {
	private final MutantService mutantService;
	private Mutant mutant;
		
	@PostMapping(value="/mutant/", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> isMutant(@NonNull @RequestBody ADNWrapper adnWrapper){
		if (adnWrapper.isEmpty()) {
			return new ResponseEntity<String>("ADN Vacío", HttpStatus.NO_CONTENT);		
		}
		if (!adnWrapper.isValid()) {
			return new ResponseEntity<String>("ADN Inválido", HttpStatus.BAD_REQUEST);		
		}
		
		this.mutant = adnWrapper.createtMutant(this.mutantService.isMutant(adnWrapper.getAdn()));
		mutantService.save(mutant);
		if (mutant.isMutant()){
			return new ResponseEntity<String>(adnWrapper.toString() + " ES un mutante", HttpStatus.OK);		
		}
		return new ResponseEntity<String>(adnWrapper.toString() + " NO ES un mutante", HttpStatus.FORBIDDEN);		
	}
	
	@GetMapping(value="/stats", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Stat> getStats(){
		Stat stat = new Stat(this.mutantService.countMutants(),this.mutantService.countHumans());
		return new ResponseEntity<Stat>(stat, HttpStatus.OK);		
	}
	
	
}
