package com.pms.mappertest;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.bean.CBDParking;
import com.pms.mapper.CBDParkingMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("../../../applicationContext.xml"))
public class test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Resource(name="CBDParkingMapper")
	private CBDParkingMapper mapper;
	@Test
	public void test() {
	mapper.delCBDParking(6);
	
	
	}

}
