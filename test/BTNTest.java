package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
		
		Assert.assertTrue(Math.abs(btn1.getUpdatedUnitPrice() - 26.3857984) < 1e-9);
	}
}
