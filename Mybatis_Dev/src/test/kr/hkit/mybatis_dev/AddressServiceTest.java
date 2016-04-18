package kr.hkit.mybatis_dev;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.hkit.mybatis_dev.dto.Address;
import kr.hkit.mybatis_dev.services.AddressService;

public class AddressServiceTest {
	private static AddressService addressService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		addressService = AddressService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		addressService = null;
	}

	@Test
	public void testFindAddressResult() {
		Address address = addressService.findAddressResult(1);
		Assert.assertNotNull(address);
		System.out.println("findAddressResult" + address);
	}

}
