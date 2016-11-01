package com.pms.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pms.bean.CBDParking;
import com.pms.bean.Company;
import com.pms.bean.User;
import com.pms.service.UserService;
import com.pms.service.impl.CompanyServiceImpl;

@Controller
@RequestMapping("/company")
public class CompanyController {
	@Resource
	private CompanyServiceImpl impl;
  
	@Resource
	private UserService userService;
	
	// 以下就是各自需要写的方法，注意命名规范。
	@RequestMapping(path = "/kongxianCBDParking")
	public @ResponseBody List<CBDParking> kongxianCBDParking(String companyId,
			String page) {
		int pageNum = Integer.parseInt(page);
		int c = Integer.parseInt(companyId);
		Company cc = new Company();
		cc.setCompanyId(c);
		List<CBDParking> list = impl.findFreeCBDParkingByCompany(cc, pageNum);
		System.out.println(list);

		return list;
 
	 }

	@RequestMapping("/list")
	@ResponseBody
	public List<Company> list() {

		return impl.findall();
	}

	@RequestMapping(path = "/kongxianAllCBDParking")
	public @ResponseBody int kongxianAllCBDParking(String companyId) {
		int c = Integer.parseInt(companyId);
		Company cc = new Company();
		cc.setCompanyId(c);
		System.out.println(impl.findFreeCBDParkingPageByCompany(cc));
		return impl.findFreeCBDParkingPageByCompany(cc);

	}

   @RequestMapping("/save")
	@ResponseBody
	public String Save(Company company ,User user){
	   try {
		
		   user.setUserType(2);
		   userService.add(user);
		   User user2 = userService.fingbyName(user.getUserName());
		   company.setUserId(user2.getUserId());
		   company.setCbdParking(null);
		   company.setContract(null);
		   impl.save(company);
	  } catch (Exception e) {
		// TODO: handle exception
		  e.printStackTrace();
		  return "1";
	  }
	   
	   return "0";
   }
}
