package test;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.NTNA6;

public class NTNA6Test {
	NTNA6 ntna6;
	
	@Before
	public void setUp() throws Exception {
		ntna6 = new NTNA6();
	}
	
	@Test
	public void testUpdatedNominalValue() {
		ntna6.setCommercialDollarQuotationBeforePayment(3.123456);
		ntna6.setCommercialDollarQuotationBeforeBaseDate(3.273456);
		ntna6.setTitleEmissionValue(10.50);
		
		ntna6.calculateUpdatedNominalValue();
		Assert.assertTrue(Math.abs(ntna6.getUpdatedNominalValue() - 11.004249) < 1e-6);
	}
	
	@Test
	public void testInterest() {
		ArrayList<Double> interestRate = new ArrayList<>();
		interestRate.add(5.00);
		interestRate.add(5.15);
		interestRate.add(5.20);
		
		ArrayList<Date> payDate = new ArrayList<>();
		payDate.add(new Date(2017, 5, 1));
		payDate.add(new Date(2017, 5, 5));
		payDate.add(new Date(2017, 5, 11));
		
		ArrayList<Date> lastPayDate = new ArrayList<>();
		lastPayDate.add(new Date(2017, 4, 1));
		lastPayDate.add(new Date(2017, 4, 15));
		lastPayDate.add(new Date(2017, 4, 3));
		
		ntna6.setUpdatedNominalValue(11.004249);
		ntna6.setInterestRate(interestRate);
		ntna6.setPayDate(payDate);
		ntna6.setLastPayDate(lastPayDate);
		
		ntna6.calculateFactor();
		Assert.assertTrue(Math.abs(ntna6.getFactor() - 0.01294306) < 1e-8);
		
		ntna6.calculateInterest();
		Assert.assertTrue(Math.abs(ntna6.getInterest() - 0.142428) < 1e-6);
	}
}
