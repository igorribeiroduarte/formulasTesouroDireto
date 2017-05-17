package src;

import java.math.BigDecimal;
import java.util.ArrayList;

public class LFTB {
	private double baseDateNominalValue;
	private ArrayList<Double> selicRate = new ArrayList<>();
	private double resultingFactor;
	private double updatedNominalValue;
	
	public LFTB(){}
	
	public double getBaseDateNominalValue() {
		return baseDateNominalValue;
	}
	
	public void setBaseDateNominalValue(double baseDateNominalValue) {
		this.baseDateNominalValue = baseDateNominalValue;
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
		updatedNominalValue = baseDateNominalValue * resultingFactor;
		
		updatedNominalValue = BigDecimal.valueOf(updatedNominalValue)
			    .setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
	}
}
