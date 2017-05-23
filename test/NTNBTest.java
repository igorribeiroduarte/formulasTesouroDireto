package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.NTNB;

public class NTNBTest {
	NTNB ntnb;

	@Before
	public void setUp() throws Exception {
		ntnb = new NTNB();
	}
	
	@Test
	public void testFactor() {
		ntnb.setIPCA1(5.15);
		ntnb.setIPCA0(5.10);
		ntnb.setDc(20);
		ntnb.setDct(15);
		
		ntnb.calculateFactor();
		
		Assert.assertTrue(Math.abs(ntnb.getFactor() - 1.01309320) < 1e-8);
	}
	
	@Test
	public void testUpdatedNominalValue() {
		ntnb.setIPCA1(5);
		ntnb.setIPCA0(4.75);
		ntnb.setFactor(1.12345678);
		ntnb.setEmissionNominalValue(1000);
		
		ntnb.calculateUpdatedNominalValue();
		
		Assert.assertTrue(Math.abs(ntnb.getUpdatedNominalValue() - 1182.586084) < 1e-6);
	}
	
	@Test
	public void testInterestFactor(){
		ntnb.setMonthsNumber(3);
		ntnb.setDcp(736373);
		ntnb.setNextPaymentDateInDays(736343);
		ntnb.setInterestRate(1.25);
		
		ntnb.calculateInterestFactor();
		
		Assert.assertTrue(Math.abs(ntnb.getInterestFactor() - 1.00311058) < 1e-8);
	}
	
	@Test
	public void testInterestFactor2(){
		ntnb.setMonthsNumber(12);
		ntnb.setDcp(736125);
		ntnb.setNextPaymentDateInDays(736250);
		ntnb.setInterestRate(1);
		
		ntnb.calculateInterestFactor();
		
		Assert.assertTrue(Math.abs(ntnb.getInterestFactor() - 1.00999829) < 1e-8);
	}
}
