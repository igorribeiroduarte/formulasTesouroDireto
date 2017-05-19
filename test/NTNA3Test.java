package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.NTNA3;

public class NTNA3Test {
	NTNA3 ntna3;

	@Before
	public void setUp() throws Exception {
		ntna3 = new NTNA3();
	}
		
	@Test
	public void testNominalValue(){
		ntna3.setUpdateQuotation(3.15);
		ntna3.setBaseQuotation(2.10);
		
		ntna3.calculateNominalValue();
		
		Assert.assertTrue(Math.abs(ntna3.getNominalValue() - 1500) < 1e-6);
	}
	
	@Test
	public void testFactor(){
		ntna3.setInterestRate(0.15);
		ntna3.setMonthsNumber(2);
		
		ntna3.calculateFactor();
		
		Assert.assertTrue(Math.abs(ntna3.getFactor() - 0.00025) < 1e-8);
	}
	
	@Test
	public void testInterest(){
		ntna3.setNominalValue(1500.75);
		ntna3.setFactor(2.12345678);
		
		ntna3.calculateInterest();
		
		Assert.assertTrue(Math.abs(ntna3.getInterest() - 3186.777762585) < 1e-8);
	}
}
