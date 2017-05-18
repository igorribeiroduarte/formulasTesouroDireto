package src;

public class NTNA1 {
	private double emissionValue;
	private double depreciationPercent;
	private double titleLiquidValue;
	
	public NTNA1(){ }
	
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
}
