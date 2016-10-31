package com.pms.mappertest;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.bean.Personal;
import com.pms.mapper.PersonalMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../applicationContext.xml")
public class PersonalMapperTest {

	@Resource(name="personalMapper")
	private PersonalMapper mapper;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDel() {
		mapper.delPersonal(1);
	}
	
	@Test
	public void Add(){
		Personal p=new Personal();
		p.setPersonalName("zhangsan");
		p.setPersonalRealName("longer");
		p.setPersonalPhone("1234567890123");
		p.setPersonalIdCard("123456789");
		p.setPersonalAddress("天府之国");
		p.setPersonalJob("员工");
		p.setTenantReputation(1);
		p.setRenterReputation(2);
	}
	
	@Test
	public void findAll(){
		System.out.println((mapper.getAllPersonal()).get(0).getParkList().size());
	}
	
	@Test
	public void update(){
		Personal p=new Personal();
		p.setPersonalName("zhangsan");
		p.setPersonalRealName("longer");
		mapper.updatePersonal(p);
	}
	
	@Test
	public void testFindById(){
		mapper.findPersonalById(2);
	}
	@Test
	public void findPersonalByUserIdTest(){
		System.out.println(mapper.findPersonlByUserId(1).getUserName());
	}

}
