package pdev.spring.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pdev.spring.entity.Credit;
import pdev.spring.repository.CreditRepository;
import pdev.spring.service.BankService;

@Service 
public class CreditService {
	@Autowired
	private CreditRepository creditRepository;
	@Autowired
	private BankService bankService;
	
	//Get All Credits
	public List<Credit> getAllCredits()   
	{  
		return (List<Credit>) creditRepository.findAll();
	}  
	
	//Add a credit
	public Credit saveCredit(Credit credit){
		
		return creditRepository.save(credit);
	}
	
	//displaying credit info
	public Credit getCreditById(int id)   
	{  
		return creditRepository.findById(id).get();
	}
	
	//deleting a credit
	public void deleteCredit(int id)   
	{  
	creditRepository.deleteById(id);
	}
	
	//updating a credit  
	public Credit updateCredit(Credit credit)   
	{  
		return creditRepository.save(credit);  
	}
	
	//Credit simulation with pdf attachment email
	public Credit savecreditdetails(Credit credit){
		float int_bank;
		float amount_credit = 0;
		String bankname = credit.getBankname();
        int_bank = bankService.getBankByName(bankname).getInterest();
		int period_credit;
		String periodicity_credit;
		int Number_Installments = 0;
		float amount_int=0;
		float installment_credit=0;
		period_credit = credit.getPeriod();
		periodicity_credit = credit.getPeriodicity();
		if (periodicity_credit.equals("monthly")){
			Number_Installments = period_credit*12;
		}
		if (periodicity_credit.equals("termly")){
			Number_Installments = period_credit*4;
		}
		if (periodicity_credit.equals("biannual")){
			Number_Installments = period_credit*2;
		}
		if (periodicity_credit.equals("annual")){
			Number_Installments = period_credit;
		}
		amount_credit = credit.getAmount();
		//bankname = bankService.getBankByName(name).getName();
		//credit.setBankname(bankname);
		amount_int = amount_credit+((amount_credit*int_bank)/100);
		installment_credit = amount_int/Number_Installments;
		credit.setAmountinstallment(installment_credit);
		credit.setInstallment(Number_Installments);
		credit.setInterest(int_bank);
	
	    return creditRepository.save(credit);	
	}
	
	//count credit by bank name
	public int Count(String name){
		int Occ = 0;
		String bankname; 
		bankname = bankService.getBankByName(name).getName();
		Occ = creditRepository.countByBankname(bankname);
		return Occ;	
	}
	//List Bank Stat
	public ArrayList<Integer> barGraph() {
		ArrayList<Integer> surveyMap = new ArrayList<Integer>();
		
			surveyMap.add (creditRepository.countByBankname("Banque de tunisie"));
			surveyMap.add(creditRepository.countByBankname("Banque de l'habitat"));
			surveyMap.add(creditRepository.countByBankname("Attijari Bank"));
			surveyMap.add(creditRepository.countByBankname("Amen Bank"));
			surveyMap.add(creditRepository.countByBankname("Banque Zitouna"));
			surveyMap.add(creditRepository.countByBankname("Société Tunisienne de Banque"));
			surveyMap.add(creditRepository.countByBankname("Banque Nationale Agricole"));
			surveyMap.add(creditRepository.countByBankname("Union Internationale de Banque"));
			surveyMap.add(creditRepository.countByBankname("Banque de Financement des Petites et Moyennes entreprises"));

		/*
		surveyMap.put("BH", creditRepository.countByBankname("Banque de l'habitat"));
		surveyMap.put("Attijari Bank", creditRepository.countByBankname("Attijari Bank"));
		surveyMap.put("Amen Bank", creditRepository.countByBankname("Amen Bank"));
		surveyMap.put("Banque Zitouna", creditRepository.countByBankname("Banque Zitouna"));
		surveyMap.put("STB", creditRepository.countByBankname("Société Tunisienne de Banque"));
		surveyMap.put("BNA", creditRepository.countByBankname("Banque Nationale Agricole"));
		surveyMap.put("UIB", creditRepository.countByBankname("Union Internationale de Banque"));
		surveyMap.put("BFPME", creditRepository.countByBankname("Banque de Financement des Petites et Moyennes entreprises"));*/
		return surveyMap;
	}
}
