package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.NTNA1;

public class NTNA1Test {
	NTNA1 ntna1;

	@Before
	public void setUp() throws Exception {
		ntna1 = new NTNA1();
	}
	
	@Test
	public void testTitleLiquidValue() {
		ntna1.setEmissionValue(100.15);	
		ntna1.setDepreciationPercent(0.15);
		
		ntna1.calculateTitleLiquidValue();
		
		Assert.assertTrue(Math.abs(ntna1.getTitleLiquidValue() - 15.0225) < 1e-6);
	}
}
