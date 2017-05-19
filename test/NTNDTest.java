package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.NTND;

public class NTNDTest {
	NTND ntnd;

	@Before
	public void setUp() throws Exception {
		ntnd = new NTND();
	}
		
	@Test
	public void testNominalValue(){
		ntnd.setUpdateQuotation(3.15);
		ntnd.setBaseQuotation(2.10);
		
		ntnd.calculateNominalValue();
		
		Assert.assertTrue(Math.abs(ntnd.getNominalValue() - 1500) < 1e-6);
	}
	
	@Test
	public void testFactor(){
		ntnd.setInterestRate(0.15);
		ntnd.setMonthsNumber(2);
		
		ntnd.calculateFactor();
		
		Assert.assertTrue(Math.abs(ntnd.getFactor() - 0.00025) < 1e-8);
	}
	
}
