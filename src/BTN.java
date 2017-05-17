package src;

import java.text.DecimalFormat;

public class BTN {
	private double unitPriceBefore;
	private double referencialRate;
	
	public BTN() {}
	
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

	public double getUpdatedUnitPrice() {
		return unitPriceBefore * referencialRate;
	}
}
