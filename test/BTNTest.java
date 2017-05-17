package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.BTN;

public class BTNTest {
	BTN btn1;

	@Before
	public void setUp() throws Exception {
		btn1 = new BTN();
	}
	
	@Test
	public void testUnitPrice() {
		btn1.setUnitPriceBefore(5.123456);
		btn1.setReferencialRate(5.15);
		
		btn1.calculateUpdatedUnitPrice();
		
		Assert.assertTrue(Math.abs(btn1.getUpdatedUnitPrice() - 26.385798) < 1e-6);
	}
	
	@Test
    public void testInterest() {
        btn1.setUpdatedUnitPrice(30.123456);
        btn1.setTitleInterestRate(5.67);
        btn1.setNumberOfMonths(6);
    
        btn1.calculateInterestFactor();
        btn1.calculateInterest();
        
        Assert.assertTrue(Math.abs(btn1.getInterestFactor() - 0.02795914) < 1e-8);
        Assert.assertTrue(Math.abs(btn1.getInterest() - 0.842225) < 1e-6);
    }
}
