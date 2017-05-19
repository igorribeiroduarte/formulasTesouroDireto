package src;

public class NTND {
	private double nominalValue;
	private double updateQuotation;
	private double baseQuotation;
	
	public NTND(){ }
	
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
