package pdev.spring.service;

import java.util.List;

import pdev.spring.entity.Bank;

public interface IBankService {
  
		public List<Bank> getAllBanks();
		public Bank getBankById(int id);
		public void saveBank(Bank bank);
		public void deleteBank(int id) ;
		public void updateBank(Bank bank);
		public Bank getBankByName(String name);
		
		
}
