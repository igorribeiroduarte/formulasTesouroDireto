package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.NTNA1;

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
}
