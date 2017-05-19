package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NTNA6Test {
	NTNA6 ntna6;
	
	@Before
	public void setUp() throws Exception {
		ntna6 = new NTNA6();
	}
	
	@Test
	public void testUpdatedNominalValue() {
		ntna6.setCommercialDollarQuotationBeforePayment(3.123456);
		ntna6.setCommercialDollarQuotationBeforeBaseDate(3.273456);
		ntna6.setTitleEmissionValue(10.50);
		
		ntna6.calculateUpdatedNominalValue();
		Assert.assertTrue(Math.abs(ntna6.getUpdatedNominalValue(), 11.004249) < 1e-6);
	}
}
