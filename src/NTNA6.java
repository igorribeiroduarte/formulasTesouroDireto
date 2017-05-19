package src;

import java.math.BigDecimal;

public class NTNA6 {
	private double commercialDollarQuotationBeforePayment;
	private double commercialDollarQuotationBeforeBaseDate;
	private double titleEmissionValue;
	private double updatedNominalValue;
	
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
	
	public void calculateUpdatedNominalValue() {
		updatedNominalValue = (commercialDollarQuotationBeforeBaseDate /
				commercialDollarQuotationBeforePayment) * titleEmissionValue;
		
		updatedNominalValue = BigDecimal.valueOf(updatedNominalValue)
			    .setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
	}
}
