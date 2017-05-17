package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LFTATest {
	LFTA lfta1;
	
	@Before
	public void setUp() throws Exception {
		lfta1 = new LFTA();
		lfta1.setSelicRate(new ArrayList<>());
	}
	
	@Test
	public void testNominalValue() {
		lfta1.setEmissionNominalValue(5.123456);
		
		ArrayList<Double> selic = new ArrayList<>();
		selic.add(100.00);
		selic.add(110.00);
		selic.add(111.00);
		selic.add(108.00);
		
		lfta1.calculateSelicRate(selic, 3);
		ArrayList<Double> selicRate = lfta1.getSelicRate();
		Assert.assertTrue(Math.abs(selicRate.get(0) - 0.00275437) < 1e-8);
		Assert.assertTrue(Math.abs(selicRate.get(1) - 0.00294853) < 1e-8);
		Assert.assertTrue(Math.abs(selicRate.get(2) - 0.00296744) < 1e-8);
		
		lfta1.calculateResultingFactor(3);
		Assert.assertTrue(Math.abs(lfta1.getResultingFactor() - 1.00869541) < 1e-8);
		
		lfta1.setRateOfIncrase(0.0245);
		lfta1.setNumberOfWorkingDaysUntilWantedDate(5);
		lfta1.setNumberOfWorkingDaysUntilPayDay(6);
		lfta1.setNumberOfInstallments(30);
		lfta1.setNumberOfAmortizedInstallments(8);
		
		lfta1.calculateUpdatedNominalValue();
		Assert.assertTrue(Math.abs(lfta1.getUpdatedNominalValue() - 4.929365) < 1e-8);
	}
}
