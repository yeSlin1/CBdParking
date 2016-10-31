package com.pms.mappertest;

import java.util.List;
import static org.junit.Assert.*;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.bean.Parking;
import com.pms.bean.Personal;
import com.pms.mapper.ParkingMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../applicationContext.xml")
public class TestParking {
	
	@Resource(name="parkingMapper")
	private ParkingMapper parkingMapper;
	@Test
	public void addParkingTest(){
		Parking parking=new Parking();
		parking.setPropertyNo("113059855");
		parking.setParkingAddress("s");
		parking.setParkingNo("24315");
		parking.setParkingPicture("djsdk");
		Personal personal=new Personal();
		personal.setPersonalId(1);
		System.out.println(parking.getPersonal().getPersonalId());
		
        parking.setPersonal(personal);
        
		parkingMapper.addParking(parking);
	}
	@Test
	public void delParkingTest(){
		parkingMapper.delParking(2);
	}
	@Test
	public void updateParkingTest(){
		Parking parking=new Parking();
		parking.setPropertyNo("11305983");
		parking.setParkingAddress("dshd");
		parking.setParkingNo("24315");
		parking.setParkingId(12);
		parking.setParkingPicture("djsdk");	
		parking.setParkingType(0);
	
		parkingMapper.updateParking(parking);
	}	
	@Test
	public void getAllParkingTest(){
		
		System.out.println(parkingMapper.getAllParking().get(0).getParkingAddress());
	}	
	@Test
	public void parkingPageNumberTest(){
		System.out.println(parkingMapper.parkingPageNumber());
	}
	@Test
	public void findParkingByPageTest(){
		System.out.println(parkingMapper.findParkingByPage(2, 3).get(0).getParkingAddress());
	}
	@Test
	public void findParkingByIdTest(){
		System.out.println(parkingMapper.findParkingById(3).getParkingPicture());
	}
	@Test
	public void getParkingByPersonIdTest(){
		System.out.println(parkingMapper.getParkingByPersonId(1).size());
	}
	@Test
	public void findParkingByPersonIdTest(){
		System.out.println(parkingMapper.findParkingByPersonId(0, 4, 1).size());
	}
	@Test
	public void ParkingPageNumberByPersonIdTest(){
		System.out.println(parkingMapper.ParkingPageNumberByPersonId(1));
	}
//	@Test
//	public void fingParkingByPersonIdTest(){
//		System.out.println(parkingMapper.fingParkingByPersonId(1, 0).size());
//	}
	@Test
	public void findParkingByParkingTypeTest(){
		System.out.println(parkingMapper.findParkingByParkingType(0, 3, 1).size());
	}
	@Test
	public void parkingByParkingTypePageNumber(){
		System.out.println(parkingMapper.parkingByParkingTypePageNumber(0));
	}
}
