package pdev.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "CREDIT")
public class Credit implements Serializable {

	private static final long serialVersionUID = -3619989487395029338L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="Amount")
	private float amount;
	
	@Column(name="Period")
	private int period;
	
	@Column(name="Periodicity")
	private String periodicity;

	@Column(name="Interest")
	private float interest;
	
	@Column(name="Installment")
	private int installment;
	
	@Column(name="Amount_of_Installment")
	private float amountinstallment;
	
	@Column(name="Bank_Name")
	private String bankname;
	
	/*@ManyToOne
	 * user User;
	 */
	
public Credit() {		
	}

	public Credit (float amount, int period, String periodicity, float interest,
				   int installment, float amountinstallment, int id, String bankname){
		this.id=id;
		this.amount = amount;
		this.period = period;
		this.periodicity = periodicity;
		this.interest = interest;
		this.installment = installment;
		this.amountinstallment = amountinstallment;
		this.bankname = bankname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public int getInstallment() {
		return installment;
	}

	public void setInstallment(int installment) {
		this.installment = installment;
	}

	public float getAmountinstallment() {
		return amountinstallment;
	}

	public void setAmountinstallment(float amountinstallment) {
		this.amountinstallment = amountinstallment;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

}