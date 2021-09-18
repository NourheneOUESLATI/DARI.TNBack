package pdev.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pdev.spring.entity.Bank;
 @Repository
	public interface BankRepository extends CrudRepository<Bank, Integer>  
	{ 
	 //sort by name
	 @Query
		Bank findByName(String name);
	
}
