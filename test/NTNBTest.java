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
		
		Assert.assertTrue(Math.abs(ntnb.getUpdatedNominalValue() - 1185.586084) < 1e-6);
	}
}
