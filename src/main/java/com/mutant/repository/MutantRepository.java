package com.mutant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mutant.model.Mutant;

@Repository
public interface MutantRepository extends MongoRepository<Mutant, String> {
	
	int countFindByIsMutant(boolean isMutant);

}