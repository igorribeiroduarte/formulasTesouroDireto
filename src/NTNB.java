package src;

public class NTNB {
	private int Dc;
	private int Dct;
	private double IPCA1;
	private double IPCA0;
	private double factor;
	private double emissionNominalValue;
	private double updatedNominalValue;
	private int dcp;
	private int monthsNumber;
	private double nextPaymentDateInDays;
	private double interestRate;
	private double interestFactor;
	
	public void calculateFactor(){
		this.factor = Math.pow( (this.IPCA1 / this.IPCA0), (this.Dc * 1.0 / this.Dct * 1.0) );
	}
	
	public void calculateUpdatedNominalValue(){
		this.updatedNominalValue = this.factor * (this.IPCA1 / this.IPCA0) * this.emissionNominalValue;
	}
	
	public double getEmissionNominalValue() {
		return emissionNominalValue;
	}

	public void setEmissionNominalValue(double emissionNominalValue) {
		this.emissionNominalValue = emissionNominalValue;
	}

	public double getUpdatedNominalValue() {
		return updatedNominalValue;
	}

	public void setUpdatedNominalValue(double updatedNominalValue) {
		this.updatedNominalValue = updatedNominalValue;
	}
	
	public int getDc() {
		return Dc;
	}
	public void setDc(int dc) {
		Dc = dc;
	}
	public int getDct() {
		return Dct;
	}
	public void setDct(int dct) {
		Dct = dct;
	}
	public double getIPCA1() {
		return IPCA1;
	}
	public void setIPCA1(double iPCA1) {
		IPCA1 = iPCA1;
	}
	public double getIPCA0() {
		return IPCA0;
	}
	public void setIPCA0(double iPCA0) {
		IPCA0 = iPCA0;
	}
	public double getFactor() {
		return factor;
	}
	public void setFactor(double factor) {
		this.factor = factor;
	}
	
	public void setMonthsNumber(int monthsNumber) {
		this.monthsNumber = monthsNumber;
	}

	public void setDcp(int dcp) {
		this.dcp = dcp;
	}

	public void setNextPaymentDateInDays(int nextPaymentDateInDays) {
		this.nextPaymentDateInDays = nextPaymentDateInDays;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void calculateInterestFactor() {
		double exponent = this.dcp / this.nextPaymentDateInDays;
		this.interestFactor = Math.pow(Math.pow((this.interestRate / 100.0) + 1, this.monthsNumber / 12.0 ),
				exponent);
	}

	public double getInterestFactor() {
		return this.interestFactor;
	}
}
