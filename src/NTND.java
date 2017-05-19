package src;

public class NTND {
	private double nominalValue;
	private double updateQuotation;
	private double baseQuotation;
	private double interestRate;
	private int monthsNumber;
	private double factor; 
	private double interest;
	
	public NTND(){ }
	
	public void calculateInterest(){
		this.interest = this.nominalValue * this.factor;
	}
	
	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}
		
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getMonthsNumber() {
		return monthsNumber;
	}

	public void setMonthsNumber(int monthsNumber) {
		this.monthsNumber = monthsNumber;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}
	
	public void calculateFactor(){
		this.factor = (this.interestRate / 100.0) * (this.monthsNumber / 12.0);
	}
	
	public double getNominalValue() {
		return nominalValue;
	}
	public void setNominalValue(double nominalValue) {
		this.nominalValue = nominalValue;
	}
	public double getUpdateQuotation() {
		return updateQuotation;
	}
	public void setUpdateQuotation(double updateQuotation) {
		this.updateQuotation = updateQuotation;
	}
	public double getBaseQuotation() {
		return baseQuotation;
	}
	public void setBaseQuotation(double baseQuotation) {
		this.baseQuotation = baseQuotation;
	}
	
	public void calculateNominalValue(){
		this.nominalValue = (this.updateQuotation / this.baseQuotation) *  1000;
	}
}
