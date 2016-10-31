package com.pms.servicetest;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.service.ManagerService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../applicationContext.xml")
public class ManagerServiceImplTest {
	@Resource
	private ManagerService ms;
	@Test
	public void testUpdateManagerInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddManager() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelManager() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateManager() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllManagerInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllManager() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllCompanyByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllCompanyByNamePage() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCompany() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelCompany() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllCompany() {
		fail("Not yet implemented");
	}

	@Test
	public void testParkingToCheck() {
		fail("Not yet implemented");
	}

	@Test
	public void testParkingToCheckPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckParking() {
		fail("Not yet implemented");
	}

	@Test
	public void testCDBNum() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testMutilCBDParkingAdd() {
		ms.mutilCBDParkingAdd(1, 20);
	}

	@Test
	public void testSignContract() {
		fail("Not yet implemented");
	}

	@Test
	public void testRenewContract() {
		fail("Not yet implemented");
	}

	@Test
	public void testReleaseContract() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllUndoComplain() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllUndoComplainPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testAcceptComplain() {
		fail("Not yet implemented");
	}

}
