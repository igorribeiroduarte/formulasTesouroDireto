package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.LTN;

public class LTNTest {
	LTN ltn;

	@Before
	public void setUp() throws Exception {
		ltn = new LTN();
	}
	
	@Test
	public void testUnitPrice() {
		ltn.setSelicRate(5.15);	
		ltn.calculateUnitPrice();
		
		Assert.assertTrue(Math.abs(ltn.getUnitPrice() - 992.817773) < 1e-6);
	}
}
