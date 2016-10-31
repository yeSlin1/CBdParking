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
import com.pms.service.impl.CompanyServiceImpl;

@Controller
@RequestMapping("/company")
public class CompanyController {
	@Resource
	private CompanyServiceImpl impl;

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

}
