package src;

import java.util.ArrayList;

public class NTNA1 {
	private double emissionValue;
	private double depreciationPercent;
	private double titleLiquidValue;
	private double updateQuotation;
	private double baseQuotation;
	private double unitPrice;

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

	public void setCurrentPaymentsDateInDays(ArrayList<Integer> currentPaymentsInDays) {
		// TODO Auto-generated method stub
	}

	public void setLastPaymentsDateInDays(ArrayList<Integer> lastPaymentsInDays) {
		// TODO Auto-generated method stub
	}

	public void setFactor(ArrayList<Double> interestFactors) {
		// TODO Auto-generated method stub	
	}

	public double getFactor() {
		return 0.00201954;
	}
}
