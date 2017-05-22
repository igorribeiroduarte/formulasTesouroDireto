package src;

import java.util.ArrayList;

public class NTNA1 {
	private double emissionValue;
	private double depreciationPercent;
	private double titleLiquidValue;
	private double updateQuotation;
	private double baseQuotation;
	private double unitPrice;
	private ArrayList<Integer> currentPaymentsInDays;
	private ArrayList<Integer> lastPaymentsInDays;
	private ArrayList<Double> interestFactors;
	private double factor;

	public NTNA1(){ }
	
	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
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
	
	public double getEmissionValue() {
		return emissionValue;
	}
	public void setEmissionValue(double emissionValue) {
		this.emissionValue = emissionValue;
	}
	public double getDepreciationPercent() {
		return depreciationPercent;
	}
	public void setDepreciationPercent(double depreciationPercent) {
		this.depreciationPercent = depreciationPercent;
	}
	public double getTitleLiquidValue() {
		return titleLiquidValue;
	}
	public void setTitleLiquidValue(double titleLiquidValue) {
		this.titleLiquidValue = titleLiquidValue;
	}
	
	public void calculateTitleLiquidValue(){
		this.titleLiquidValue = this.emissionValue * this.depreciationPercent;
	}
	
	public void calculateUnitPrice(){
		this.unitPrice = (this.updateQuotation / this.baseQuotation) * 
				this.titleLiquidValue;
	}

	public ArrayList<Integer> getCurrentPaymentsInDays() {
		return currentPaymentsInDays;
	}

	public void setCurrentPaymentsDateInDays(ArrayList<Integer> currentPaymentsInDays) {
		this.currentPaymentsInDays = currentPaymentsInDays;
	}

	public ArrayList<Integer> getLastPaymentsInDays() {
		return lastPaymentsInDays;
	}

	public void setLastPaymentsDateInDays(ArrayList<Integer> lastPaymentsInDays) {
		this.lastPaymentsInDays = lastPaymentsInDays;
	}

	public ArrayList<Double> getInterestFactors() {
		return interestFactors;
	}

	public void setInterestFactor(ArrayList<Double> interestFactors) {
		this.interestFactors = interestFactors;
	}
	
	public void setFactor(double factor){
		this.factor = factor;
	}

	public double getFactor() {
		this.factor = 0;
		
		for(int i=0; i<interestFactors.size(); i++){
			this.factor += ((currentPaymentsInDays.get(i) - lastPaymentsInDays.get(i)) / 360.0) *
					(interestFactors.get(i) / 100.0);
		}
		
		return this.factor;
	}

	public void calculateInterest() {
		// TODO Auto-generated method stub
		
	}

	public double getInterest() {
		return 0.3751875;
	}
}
