package src;

import java.math.BigDecimal;

public class BTN {
	private double unitPriceBefore;
	private double referencialRate;
	private double updatedUnitPrice;
	private double titleInterestRate;
	private int numberOfMonths;
	private double interestFactor;
	private double interest;
	
	public BTN() {}
	
	public double getTitleInterestRate() {
		return titleInterestRate;
	}

	public void setTitleInterestRate(double titleInterestRate) {
		this.titleInterestRate = titleInterestRate;
	}

	public double getNumberOfMonths() {
		return numberOfMonths;
	}

	public void setNumberOfMonths(int numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}
	
	public double getUnitPriceBefore() {
		return unitPriceBefore;
	}
	
	public void setUnitPriceBefore(double unitPriceBefore) {
		this.unitPriceBefore = unitPriceBefore;
	}
	
	public double getReferencialRate() {
		return referencialRate;
	}
	
	public void setReferencialRate(double referencialRate) {
		this.referencialRate = referencialRate;
	}
	
	public void setUpdatedUnitPrice(double updatedUnitPrice) {
		this.updatedUnitPrice = updatedUnitPrice;
	}

	public double getUpdatedUnitPrice() {
		return updatedUnitPrice;
	}
	
	public double getInterestFactor() {
		return interestFactor;
	}

	public void setInterestFactor(double interestFactor) {
		this.interestFactor = interestFactor;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public void calculateUpdatedUnitPrice() {
		updatedUnitPrice = unitPriceBefore *referencialRate;
		
		updatedUnitPrice = BigDecimal.valueOf(updatedUnitPrice)
			    .setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
	}
	
	public void calculateInterestFactor() {
		interestFactor = Math.pow((1 + titleInterestRate / 100.0), 
				numberOfMonths / 12.0) - 1;
		
		interestFactor = BigDecimal.valueOf(interestFactor)
			    .setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public void calculateInterest() {
		interest = interestFactor * updatedUnitPrice;
		
		interest = BigDecimal.valueOf(interest)
			    .setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
	}
	
}
