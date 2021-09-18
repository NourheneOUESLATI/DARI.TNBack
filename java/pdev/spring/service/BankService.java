package pdev.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pdev.spring.entity.Bank;
import pdev.spring.repository.BankRepository;

@Service 
public class BankService {
	@Autowired
	private BankRepository bankRepository;  
	//getting all banks
	public List<Bank> getAllBanks()   
	{  
		return (List<Bank>) bankRepository.findAll();
	} 
	
	//Add a bank
	public Bank saveBank(Bank bank){
		return bankRepository.save(bank);
	}
	//displaying bank info
	public Bank getBankByName(String name) 
	{  
		return bankRepository.findByName(name);
	}
	public Optional<Bank> getBankById(int id)
	{
		return bankRepository.findById(id);
	}
	
	//deleting a bank
	public void deleteBank(int id)   
	{  
	bankRepository.deleteById(id);
	}
	//updating a record  
	public Bank updateBank(Bank bank)   
	{  
		return bankRepository.save(bank);  
	}
}
