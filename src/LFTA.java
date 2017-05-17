package src;

import java.math.BigDecimal;
import java.util.ArrayList;

public class LFTA {
	private double emissionNominalValue;
	private ArrayList<Double> selicRate = new ArrayList<>();
	private double resultingFactor;
	private double ratingOfIncrease;
	private int numberOfWorkingDaysUntilWantedDate;
	private int numberOfWorkingDaysUntilPayDay;
	private int numberOfInstallments;
	private int numberOfAmortizedInstallments;
	private double updatedNominalValue;
	
	public LFTA() {}

	public double getEmissionNominalValue() {
		return emissionNominalValue;
	}
	
	public void setEmissionNominalValue(double emissionNominalValue) {
		this.emissionNominalValue = emissionNominalValue;
	}
	
	public ArrayList<Double> getSelicRate() {
		return selicRate;
	}
	
	public void setSelicRate(ArrayList<Double> selicRate) {
		this.selicRate = selicRate;
	}
	
	public double getResultingFactor() {
		return resultingFactor;
	}
	
	public void setResultingFactor(double resultingFactor) {
		this.resultingFactor = resultingFactor;
	}
	
	public double getRatingOfIncrease() {
		return ratingOfIncrease;
	}
	
	public void setRatingOfIncrease(double ratingOfIncrease) {
		this.ratingOfIncrease = ratingOfIncrease;
	}
	
	public int getNumberOfWorkingDaysUntilWantedDate() {
		return numberOfWorkingDaysUntilWantedDate;
	}
	
	public void setNumberOfWorkingDaysUntilWantedDate(int numberOfWorkingDaysUntilWantedDate) {
		this.numberOfWorkingDaysUntilWantedDate = numberOfWorkingDaysUntilWantedDate;
	}
	
	public int getNumberOfWorkingDaysUntilPayDay() {
		return numberOfWorkingDaysUntilPayDay;
	}
	
	public void setNumberOfWorkingDaysUntilPayDay(int numberOfWorkingDaysUntilPayDay) {
		this.numberOfWorkingDaysUntilPayDay = numberOfWorkingDaysUntilPayDay;
	}
	
	public int getNumberOfInstallments() {
		return numberOfInstallments;
	}
	
	public void setNumberOfInstallments(int numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}
	
	public int getNumberOfAmortizedInstallments() {
		return numberOfAmortizedInstallments;
	}
	
	public void setNumberOfAmortizedInstallments(int numberOfAmortizedInstallments) {
		this.numberOfAmortizedInstallments = numberOfAmortizedInstallments;
	}
	
	public double getUpdatedNominalValue() {
		return updatedNominalValue;
	}
	
	public void setUpdatedNominalValue(double updatedNominalValue) {
		this.updatedNominalValue = updatedNominalValue;
	}
	
	public void calculateSelicRate(ArrayList<Double> selic, int n) {
		for(int i = 0; i < n; i++) {
			selicRate.add(Math.pow(selic.get(i) / 100.0 + 1, 1 / 252.0) - 1);
			
			selicRate.set(i, BigDecimal.valueOf(selicRate.get(i)).
					setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue());
		}
	}
	
	public void calculateResultingFactor(int n) {
		resultingFactor = 1;
		
		for(int i = 0; i < n; i++) {
			resultingFactor *= (1 + selicRate.get(i)); 
		}
		
		resultingFactor = BigDecimal.valueOf(resultingFactor)
			    .setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public void calculateUpdatedNominalValue() {
		updatedNominalValue = resultingFactor * emissionNominalValue *
				Math.pow(1 + ratingOfIncrease / 100.0, 
						numberOfWorkingDaysUntilWantedDate * 1.0 / 
						numberOfWorkingDaysUntilPayDay) - resultingFactor * 
				emissionNominalValue * Math.pow(1 + ratingOfIncrease, 
						numberOfWorkingDaysUntilWantedDate * 1.0 / 
						numberOfWorkingDaysUntilPayDay) * 1.0 / 
				(numberOfInstallments - numberOfAmortizedInstallments);
		
		updatedNominalValue = BigDecimal.valueOf(updatedNominalValue)
			    .setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
	}
	
}
