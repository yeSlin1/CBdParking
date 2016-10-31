package com.pms.mappertest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.bean.ParkingMessage;
import com.pms.bean.Personal;
import com.pms.bean.RentLog;
import com.pms.mapper.RentLogMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../applicationContext.xml")
public class testlog {

	@Resource
	
	
	private Personal per;
	private ParkingMessage park;
	private RentLog log;
	
	@Test
	public void testadd() {
		log=new RentLog();
		log.setTenantMsg("aaaa");
		log.setRentLogType(1);
		per=new Personal();
		per.setPersonalId(1);
		log.setPersonal(per);
		park=new ParkingMessage();
		park.setParkingMsgId(1);
		log.setParkingMsg(park);
		
				
	}
	
	@Test
	public void testupdate() {
		log=new RentLog();
		log.setRentLogId(15);
		log.setTenantMsg("bbbb");
		log.setRentLogType(1);
		per=new Personal();
		per.setPersonalId(1);
		log.setPersonal(per);
		park=new ParkingMessage();
		park.setParkingMsgId(1);
		log.setParkingMsg(park);
		

	}
	
	@Test
	public void testfind() {
		
	}
	
	@Test
	public void testdel() {
		
	}
	
	@Test
	public void getRentLogByParkingMessageId() {
		
		//System.out.println(service.getRentLogByParkingMessageId2(0,2,1));
	
	}


}
