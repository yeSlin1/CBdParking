package com.pms.mappertest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.bean.Complain;
import com.pms.mapper.ComplainMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../applicationContext.xml")
public class TestComplain {
	@Resource
	private ComplainMapper comp;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	List<Complain>	list = comp.getComplainByType(1);
	for(int i=0;i<list.size();i++){
		System.out.println(list.get(i).getComplainId()+"   "+	list.get(i).getParkingMessage().getPrice());
	}
	}
	@Test
	public void test1() {
	List<Complain>	list = comp.getAllComplain();
	for(int i=0;i<list.size();i++){
		System.out.println(list.get(i).getComplainId()+"   "+list.get(i).getComplainFrom().getPersonalName()
			+	list.get(i).getParkingMessage().getEndTime());
	}
	}

}
