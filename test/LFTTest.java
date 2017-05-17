package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LFTTest {
	LFT lft1;
	
	@Before
	public void setUp() throws Exception {
		lft1 = new LFT();
	}
	
	@Test
	public void testNominalValue() {
		lft1.setBaseDateNominalValue(5.123456);
		
		ArrayList<Double> selic = new ArrayList<>();
		selic.add(100.00);
		selic.add(110.00);
		selic.add(111.00);
		selic.add(108.00);
		
		lft1.calculateSelicRate(selic, 3);
		ArrayList<Double> selicRate = lft1.getSelicRate();
		Assert.assertTrue(Math.abs(selicRate.get(0) - 0.00275437) < 1e-8);
		Assert.assertTrue(Math.abs(selicRate.get(1) - 0.00294853) < 1e-8);
		Assert.assertTrue(Math.abs(selicRate.get(2) - 0.00296744) < 1e-8);

		lft1.calculateResultingFactor();
		Assert.assertTrue(Math.abs(lft1.getResultingFactor() - 1.00869541) < 1e-8);
		
		lft1.calculateUpdatedNominalValue();
		Assert.assertTrue(Math.abs(lft1.getUpdatedNominalValue() - 5.168006) < 1e-8);
	}
}
