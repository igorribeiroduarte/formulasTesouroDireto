package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
		
		ntna1.calculateTitileLiquidValue();
		
		Assert.assertTrue(Math.abs(ntna1.getTitleLiquidValue() - 15.015) < 1e-6);
	}
}
