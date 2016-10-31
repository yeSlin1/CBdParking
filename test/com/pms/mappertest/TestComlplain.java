package com.pms.mappertest;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.bean.Complain;
import com.pms.bean.ParkingMessage;
import com.pms.bean.Personal;
import com.pms.mapper.ComplainMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../applicationContext.xml")
public class TestComlplain {

	@Resource
	private ComplainMapper mapper;
	
	private Personal per;
	private ParkingMessage park;
	private Complain com;
	
	
	@Test
	public void testfind() {
		System.out.println(mapper.getAllComplain().get(0).getParkingMessage().getPrice());
	}
	
	@Test
	public void update(){
		com=new Complain();
		com.setComplainId(1);
		com.setComplainTime(new Date());
		com.setComplain("bb");
		com.setComplainType(0);
		per =new Personal();
		per.setPersonalId(1);
		com.setComplainFrom(per);
		com.setComplainTo(per);
		park=new ParkingMessage();
		park.setParkingMsgId(1);
		com.setParkingMessage(park);
		
		mapper.updateComplain(com);
	}
	
	
	@Test
	public void del(){
		mapper.delComplain(1);
	}
	
	@Test
	public void add(){
		com=new Complain();
		com.setComplainTime(new Date());
		com.setComplain("bb");
		com.setComplainType(0);
		per =new Personal();
		per.setPersonalId(1);
		com.setComplainFrom(per);
		com.setComplainTo(per);
		park=new ParkingMessage();
		park.setParkingMsgId(1);
		com.setParkingMessage(park);
		
		mapper.addComplain(com);
	}

}
