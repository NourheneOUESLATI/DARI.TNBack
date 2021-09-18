package pdev.spring.service;

import java.util.List;

import pdev.spring.entity.Credit;

public interface ICreditService {

	List<Credit> getAllCredits();
	Credit getCreditById(int id);
	void savecredit(Credit credit);
	void deleteCredit(int id) ;
	void updateCredit(Credit credit);
	int Count(String name);
	Credit savecreditdetails(Credit credit);
}
