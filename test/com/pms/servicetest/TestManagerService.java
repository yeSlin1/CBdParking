package com.pms.servicetest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.bean.CBDParking;
import com.pms.bean.Company;
import com.pms.bean.Complain;
import com.pms.bean.Contract;
import com.pms.bean.Manager;
import com.pms.bean.Parking;
import com.pms.bean.Power;
import com.pms.bean.User;
import com.pms.mapper.CBDParkingMapper;
import com.pms.mapper.ContractMapper;
import com.pms.service.ManagerService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../applicationContext.xml")
public class TestManagerService {
@Resource
private ManagerService service;

	private Manager m;
	private User u;
	private Power p;
	private Company c;
	@Resource
	private CBDParkingMapper cbd;
	 
	@Resource
	private ContractMapper c1;
	@Test
	public void test() {
		//System.out.println(service.getAllManager());
		m=new Manager();
		m.setManagerName("sd");
		m.setManagerId(2);
		m.setManagerNo(56);
		m.setManagerPhone("123");
		u=new User();
		u.setUserId(1);
//		m.setUser(u);
		
		List<Power> list = new ArrayList<Power>();
		p=new Power();
		p.setPowerId(2);
		list.add(p);
		m.setPower(list);
		
		//service.addManager(m);
		
		service.updateManager(m);
		
		//service.updateManagerInfo(m);
		
		//System.out.println(service.getAllCompanyByName("", 1).size());
		
		//System.out.println(service.getAllCompanyByNamePage(""));
		
		c=new Company();
		c.setCompanyId(2);
		c.setCompanyName("ddd");
		c.setCompanyPhone("dsff");
		c.setCompanyAddress("vbvbcg");
		c.setCompanyResponsible("asfdwef");
//		c.setUser(u);
		
		//service.addCompany(c);
		 
		//service.delCompany(c);
		
		
		
	}
	@Test
	public void mutilCBDParkingAdd(){
		int i = service.mutilCBDParkingAdd(1, 5);
		System.out.println(i);
		
	}
	@Test
	public void getAllCompany(){
		List<Company> list = service.getAllCompany();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getCompanyName());
		}
	}
	@Test
	public void parkingToCheck(){
		List<Parking> list = service.parkingToCheck(2);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getParkingNo());
		}
	}
	@Test
	public void parkingToCheckPage(){
		int list = service.parkingToCheckPage();
		System.out.println(list);
	}
	@Test
	public void checkParking(){
		Parking p = new Parking();
		p.setParkingType(1);
		p.setParkingId(1);
		int list = service.checkParking(p);
		System.out.println(list);
	}
	@Test
	public void releaseContract(){
		Contract c = new Contract();
		c.setContractId(1);
		
		service.releaseContract(c);
	}
	@Test
	public void renewContract(){
		Contract c = new Contract();
		c.setContractId(1);
		service.renewContract(c, Date.valueOf("1998-1-1"), Date.valueOf("1998-1-1"), "12");
	}
	@Test
	public void signContract(){
		Contract c = new Contract();
		c.setContractNo("12");
		Company company = new Company();
		company.setCompanyId(1);
		c.setCompany(company);
		service.signContract(c);
	}
	
	

}
