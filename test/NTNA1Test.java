package test;

import java.util.ArrayList;

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
	
	@Test
	public void testUnitPrice(){
		ntna1.setUpdateQuotation(3.15);
		ntna1.setBaseQuotation(3.10);
		ntna1.setTitleLiquidValue(1000);
		
		ntna1.calculateUnitPrice();
		
		Assert.assertTrue(Math.abs(ntna1.getUnitPrice() - 1016.129032) < 1e-6);
	}
	
	public void testFactorWithManyValues(){
		ArrayList<Integer> currentPaymentsInDays = new ArrayList<>();
		currentPaymentsInDays.add(736373);
		currentPaymentsInDays.add(736433);
		ntna1.setCurrentPaymentsDateInDays(currentPaymentsInDays);
		
		ArrayList<Integer> lastPaymentsInDays = new ArrayList<>();
		lastPaymentsInDays.add(736343);
		lastPaymentsInDays.add(736403);
		ntna1.setLastPaymentsDateInDays(lastPaymentsInDays);
		
		ArrayList<Double> interestFactors = new ArrayList<>();
		interestFactors.add(0.3);
		interestFactors.add(2.12345678);	
		ntna1.setFactor(interestFactors);
		
		Assert.assertTrue(Math.abs(ntna1.getFactor() - 0.00201954) < 1e-8);
	}
	
	public void testFactorWithOneValue(){
		ArrayList<Integer> currentPaymentsInDays = new ArrayList<>();
		currentPaymentsInDays.add(736418);
		ntna1.setCurrentPaymentsDateInDays(currentPaymentsInDays);
		
		ArrayList<Integer> lastPaymentsInDays = new ArrayList<>();
		lastPaymentsInDays.add(736373);
		ntna1.setLastPaymentsDateInDays(lastPaymentsInDays);
		
		ArrayList<Double> interestFactors = new ArrayList<>();
		interestFactors.add(0.7);	
		ntna1.setFactor(interestFactors);
		
		Assert.assertTrue(Math.abs(ntna1.getFactor() - 0.000875) < 1e-8);
	}
}
