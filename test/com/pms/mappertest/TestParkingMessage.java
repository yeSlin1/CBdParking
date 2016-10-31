package com.pms.mappertest;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.bean.Parking;
import com.pms.bean.ParkingMessage;
import com.pms.bean.Personal;
import com.pms.bean.RentLog;
import com.pms.mapper.ParkingMessageMapper;
/**
 * 测试ParkingMessageMapper类的方法
 * @author suisuinian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../applicationContext.xml")
public class TestParkingMessage {
	@Resource(name="parkingMessageMapper")
    private ParkingMessageMapper mapper;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
    /**
     * 测试增加租车位方法
     */
	@Test
	public void testAdd() {
		    ParkingMessage message=new ParkingMessage();
		    message.setStartTime(new Date());
		    message.setEndTime(new Date());
		    message.setPrice(new BigDecimal("4444"));
		    Parking parking=new Parking();
		    parking.setParkingId(1);
		    message.setParking(parking);		
		    mapper.addParkingMessage(message);
	}
	/**
	 * 测试删除租车位方法
	 */
	@Test
	  public void testDel(){
		  mapper.delParkingMessage(1);
	  }
	/**
	 * 测试修改租车位方法
	 */
	@Test
	public void testUpdate(){
		 ParkingMessage message=new ParkingMessage();
		 message.setParkingMsgId(2);
		 message.setEndTime(new Date());		
		 message.setStartTime(new Date());
		 message.setPrice(new BigDecimal("44"));
		 mapper.updateParkingMessage(message);
	}
	/**
	 * 测试获取全部租车位方法
	 */
	@Test
	public void testFindAll(){
	List<ParkingMessage> list=	mapper.getAllParkingMessage();
	System.out.println(list.size());
	}
	/**
	 * 测试根据ID查询租车位方法
	 */
	@Test
	public void testFindById(){
		ParkingMessage message=mapper.findById(2);
		System.out.println(message);
	}
	@Test
	public void testFindParkingMsgByPersonId(){
		List<ParkingMessage> list=mapper.findParkingMsgByPersonal(0, 5, 1, new Date());
		System.out.println(list.size());
	}
	@Test
	public void testParkingMsgPageNumber(){
		int a=mapper.ParkingMsgPageNumber(1, new Date());
		System.out.println(a);
	}
	@Test
	public void testFindParkingMessageByPersonId(){
		
		List<ParkingMessage> list=mapper.findParkingMessageByPersonId(0, 5, 1, 1);
		
		System.out.println(list.size());
	}
	
	@Test
	public void testParkingMesPageNumber(){
		int a=mapper.ParkingMesPageNumber(1, 1);
		System.out.println(a);
	}
	@Test
	public void testFindParkingMessageByTime(){
	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d="2016-03-02 14:31:47";
		try {
			Date	date=sdf.parse(d);
			System.out.println(date);
			List<ParkingMessage> list=mapper.findParkingMessageByTime(0, 5, date, new Date());
			System.out.println(list.size());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testParkingMessagePageNumber(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d="2016-03-02 14:31:47";
		Date date;
		try {
			date = sdf.parse(d);
			int a=mapper.ParkingMessagePageNumber(date, new Date());
			System.out.println(a);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test
	public void findParkingMessageByTentPersonIdTest(){	
//		System.out.println(mapper.findParkingMessageByTentPersonId(0,5).size());
		mapper.findParkingMessageByTentPersonId(1,0,5).size();
	}
	@Test
	public void findParkingMessageByTentPersonIdPageTest(){
		System.out.println(mapper.findParkingMessageByTentPersonIdPage(1));
	}
	
}
