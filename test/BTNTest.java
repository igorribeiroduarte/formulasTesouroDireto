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
	
	@Test
	public void testMainWithPUus() {
		btn1.setPUus(3.58);
		btn1.setQte(20);
		
		btn1.calculateMainWithPUus();
		Assert.assertTrue(Math.abs(btn1.getMain() - 71.60) < 1e-2);
	}
	
	@Test
	public void testMainWithPUusWhenQteEqualsZero() {
		btn1.setPUus(5.15);
		btn1.setQte(0);
		
		btn1.calculateMainWithPUus();
		Assert.assertTrue(Math.abs(btn1.getMain() - 0) < 1e-2);
	}
	
	@Test
	public void testMainWithPUusWhenPUusEqualsZero() {
		btn1.setPUus(0.00);
		btn1.setQte(15);
		
		btn1.calculateMainWithPUus();
		Assert.assertTrue(Math.abs(btn1.getMain() - 0) < 1e-2);
	}
	
	@Test
	public void testMainWithPUat() {
		btn1.setPUat(7.32);
		btn1.setQte(30);
		
		btn1.calculateMainWithPUat();
		Assert.assertTrue(Math.abs(btn1.getMain() - 219.60) < 1e-2);
	}
}
