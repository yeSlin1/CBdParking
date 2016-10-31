package com.pms.servicetest;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.pms.bean.Complain;
import com.pms.bean.Parking;
import com.pms.bean.ParkingMessage;
import com.pms.bean.Personal;
import com.pms.bean.RentLog;
import com.pms.service.PersonalService;

import com.pms.service.impl.PersonalServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../applicationContext.xml")
public class PersonalServiceImplTest {
    
	@Resource(name="personalServiceImpl")
	private PersonalService impl=new PersonalServiceImpl();

	@Test
	public void testPersonalLogin() {
		Personal personal=impl.personalLogin(1);
		System.out.println(personal.getPersonalAddress());
		assertNotNull(personal);
	}

	@Test
	public void testUpdatePersonal() {
		Personal personal=new Personal();
		personal.setPersonalName("wodeleier");
		personal.setPersonalRealName("wodehuanger");
		personal.setPersonalPhone("18543658421");
		personal.setPersonalIdCard("511524557485");
		personal.setPersonalAddress("高新区");
		personal.setPersonalJob("lol");
		personal.setTenantReputation(-1.5);
		personal.setRenterReputation(2.5);
		personal.setPersonalId(1);
	    int i=impl.updatePersonal(personal);
	    assertEquals(1, i);
	}

	@Test
	public void testGetmyParking() {
		Personal personal=new Personal();
		personal.setPersonalId(1);
		int i=impl.getmyParking(3, personal).size();
		assertEquals(5, i);
	}

	@Test
	public void testGetmyParkingPage() { 
		Personal personal=new Personal();
		personal.setPersonalId(1);
		int i=impl.getmyParkingPage(personal);	
		assertEquals(4, i);
	}

	@Test
	public void testAddParking() {
		Parking parking=new Parking();
		parking.setPropertyNo("12452151");
		parking.setParkingPicture("mypicture");
		parking.setParkingAddress("高新区");
		parking.setParkingNo("1452");
		parking.setParkingType(0);
		Personal personal=new Personal();
		personal.setPersonalId(1);
		parking.setPersonal(personal);
		int i=impl.addParking(parking);
		assertEquals(1, i);
	}

	@Test
	public void testAddParkingMessage() {
		ParkingMessage parkingmessage = new ParkingMessage();
		parkingmessage.setPrice(new BigDecimal(100));
		impl.addParkingMessage(parkingmessage);
	}

	@Test
	public void testGetMyParkingMessage() {
		Personal p=new Personal();
		p.setPersonalId(2);
		assertNotNull(impl.getMyParkingMessage(p, 2));
	}

	@Test
	public void testGetMyParkingMessagePage() {
		Personal p=new Personal();
		p.setPersonalId(2);
		assertNotNull(impl.getMyParkingMessagePage(p));
	}

	@Test
	public void testGetMyRentlogByParkingMessage() {
		ParkingMessage pmessage=new ParkingMessage();
		String t="2016-3-14";
		SimpleDateFormat date =new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1= date.parse(t);
			pmessage.setStartTime(date1);
			assertNotNull(impl.getMyRentlogByParkingMessage(pmessage, 1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMyRentlogByParkingMessagePage() {

		ParkingMessage parkingMessage=new ParkingMessage();
		parkingMessage.setParkingMsgId(1);
		int i=impl.getMyRentlogByParkingMessagePage(parkingMessage);

	}

	@Test
	public void testGetDealWhitRentlog() {
		RentLog rentLog = new RentLog();
		rentLog.setRentLogType(1);
		
	}

	@Test
	public void testGetMyDealOutParkingMessage() {
		Personal personal=new Personal();
		personal.setPersonalId(1);
		      int a=impl.getMyDealOutParkingMessage(personal, 1).size();
		      System.out.println(a);
	}

	@Test
	public void testGetMyDealOutParkingMessagePage() {
		Personal personal=new Personal();
		     personal.setPersonalId(1);
		  int a=   impl.getMyDealOutParkingMessagePage(personal);
		  assertEquals(1, a);
	}

	@Test
	public void testGetMyDealInParkingMessage() {
		 Personal personal=new Personal();
		   personal.setPersonalId(1);
		   int i= impl.getMyDealInParkingMessage(personal, 1).size();  
		   assertEquals(1, i);
	}

	@Test
	public void testGetMyDealInParkingMessagePage() {
		   Personal personal=new Personal();
		   personal.setPersonalId(1);
		int a=impl.getMyDealInParkingMessagePage(personal);
		assertEquals(1, a);
	}

	@Test
	public void testAddComplain() {
		  Complain complain=new Complain();
	       ParkingMessage parkingMessage=new ParkingMessage();
	       parkingMessage.setParkingMsgId(1);
	         Personal personal=new Personal();
	         Personal personal2=new Personal();
	         personal2.setPersonalId(1);
	         personal.setPersonalId(1);
	      complain.setComplainFrom(personal);
	      complain.setComplainTo(personal2);
	       complain.setComplainType(1);
	       complain.setComplainTime(new Date());
	       complain.setComplain("s5654");
	       complain.setParkingMessage(parkingMessage);		       
	       impl.addComplain(complain);
		}

	@Test
	public void testFindParkingMessageTopark() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d="2016-03-02 14:31:47";
		Date date;
		try {
			date = sdf.parse(d);
			List<ParkingMessage> a=impl.findParkingMessageTopark(date, new Date(), 1);
			int b=a.size();
			assertEquals(5, b);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		      
	}

	@Test
	public void testFindParkingMessageToparkPage() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d="2016-03-02 14:31:47";
		Date date;
		try {
			date = sdf.parse(d);
		int a=	impl.findParkingMessageToparkPage(date, new Date());
		assertEquals(1, a);
			//System.out.println(impl.findParkingMessageToparkPage(date, new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	public void testOrderAparkingMessage() {
		RentLog rentlog=new RentLog();
		ParkingMessage message=new ParkingMessage();
		Personal personal=new Personal();
		message.setParkingMsgId(1);
		personal.setPersonalId(1);
		rentlog.setPersonal(personal);
		rentlog.setParkingMsg(message);
		rentlog.setRentLogType(1);
		rentlog.setTenantMsg("dddd");
		assertNotNull(impl.orderAparkingMessage(rentlog));
	}
	
	@Test
	public void testfindRentParkingMessage() {
		int i=1;
		List<ParkingMessage> list=impl.findRentParkingMessage(i);
		System.out.println(list.size());
		System.out.println(list.get(0).getParkingMsgId());
		System.out.println(list.get(0).getParking().getParkingPicture());
		System.out.println(list.get(0).getParking().getParkingAddress());
	    System.out.println(list.get(1).getParking().getPersonal().getPersonalRealName());
	    int page=impl.findRentParkingMessagePage();
	    System.out.println(page);
		
	}

}
