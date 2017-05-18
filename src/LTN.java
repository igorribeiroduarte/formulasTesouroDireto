package src;

public class LTN {
	private double selicRate;
	private double unitPrice;
	
	public LTN() {}
	
	public double getSelicRate() {
		return selicRate;
	}
	public void setSelicRate(double selicRate) {
		this.selicRate = selicRate;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public void calculateUnitPrice(){
		double denominator = Math.pow(1.0 + this.selicRate, 1.0 / 252);
		this.unitPrice = 1000 / denominator;
	}
}
