package src;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NTNA6 {
	private double commercialDollarQuotationBeforePayment;
	private double commercialDollarQuotationBeforeBaseDate;
	private double titleEmissionValue;
	private double updatedNominalValue;
	private double factor;
	private double interest;
	
	private ArrayList<Double> interestRate; 
	
	private ArrayList<Date> payDate;
	private ArrayList<Date> lastPayDate;
	
	public NTNA6() {}

	public double getCommercialDollarQuotationBeforePayment() {
		return commercialDollarQuotationBeforePayment;
	}
	
	public void setCommercialDollarQuotationBeforePayment(double commercialDollarQuotationBeforePayment) {
		this.commercialDollarQuotationBeforePayment = commercialDollarQuotationBeforePayment;
	}
	
	public double getCommercialDollarQuotationBeforeBaseDate() {
		return commercialDollarQuotationBeforeBaseDate;
	}
	
	public void setCommercialDollarQuotationBeforeBaseDate(double commercialDollarQuotationBeforeBaseDate) {
		this.commercialDollarQuotationBeforeBaseDate = commercialDollarQuotationBeforeBaseDate;
	}
	
	public double getTitleEmissionValue() {
		return titleEmissionValue;
	}
	
	public void setTitleEmissionValue(double titleEmissionValue) {
		this.titleEmissionValue = titleEmissionValue;
	}
	
	public double getUpdatedNominalValue() {
		return updatedNominalValue;
	}
	
	public void setUpdatedNominalValue(double updatedNominalValue) {
		this.updatedNominalValue = updatedNominalValue;
	}
	
	public ArrayList<Double> getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(ArrayList<Double> interestRate) {
		this.interestRate = interestRate;
	}

	public ArrayList<Date> getPayDate() {
		return payDate;
	}

	public void setPayDate(ArrayList<Date> payDate) {
		this.payDate = payDate;
	}

	public ArrayList<Date> getLastPayDate() {
		return lastPayDate;
	}

	public void setLastPayDate(ArrayList<Date> lastPayDate) {
		this.lastPayDate = lastPayDate;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public void calculateUpdatedNominalValue() {
		updatedNominalValue = (commercialDollarQuotationBeforeBaseDate /
				commercialDollarQuotationBeforePayment) * titleEmissionValue;
		
		updatedNominalValue = BigDecimal.valueOf(updatedNominalValue)
			    .setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
	}
	
	public void calculateFactor() {
		factor = 0;
		for(int i = 0; i < interestRate.size(); i++) {
			Calendar date1 = Calendar.getInstance();
			Calendar date2 = Calendar.getInstance();
			
			date1.setTime(lastPayDate.get(i));
			date2.setTime(payDate.get(i));
			
			int days = date2.get(Calendar.DAY_OF_YEAR) - 
					date1.get(Calendar.DAY_OF_YEAR);
			
			factor += ((days / 360.0) * (interestRate.get(i) / 100.0));
		}
		
		factor = BigDecimal.valueOf(factor)
			    .setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public void calculateInterest() {
		interest = factor * updatedNominalValue;
		
		interest = BigDecimal.valueOf(interest)
			    .setScale(8, BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}
}
