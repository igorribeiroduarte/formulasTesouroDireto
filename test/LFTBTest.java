package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class LFTBTest {
	LFTB lftb1;
	
	@Before
	public void setUp() throws Exception {
		lftb1 = new LFTB();
		lftb1.setSelicRate(new ArrayList<>());
	}

	@Test
	public void testNominalValue() {
		lftb1.setBaseDateNominalValue(5.123456);
		
		ArrayList<Double> selic = new ArrayList<>();
		selic.add(100.00);
		selic.add(110.00);
		selic.add(111.00);
		selic.add(108.00);
		
		lftb1.calculateSelicRate(selic, 3);
		ArrayList<Double> selicRate = lftb1.getSelicRate();
		Assert.assertTrue(Math.abs(selicRate.get(0) - 0.00275437) < 1e-8);
		Assert.assertTrue(Math.abs(selicRate.get(1) - 0.00294853) < 1e-8);
		Assert.assertTrue(Math.abs(selicRate.get(2) - 0.00296744) < 1e-8);

		lftb1.calculateResultingFactor(3);
		Assert.assertTrue(Math.abs(lftb1.getResultingFactor() - 1.00869541) < 1e-8);
		
		lftb1.calculateUpdatedNominalValue();
		Assert.assertTrue(Math.abs(lftb1.getUpdatedNominalValue() - 5.168006) < 1e-8);
	}
}
