package com.pms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pms.bean.RentLog;
import com.pms.service.RentlogsService;
import com.pms.service.impl.UserServiceImpl;


@Controller
@RequestMapping("/Rentlogs")
public class RentlogsConroller {

	@Resource
	RentlogsService rentlogsService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<RentLog> list(){
		
		List<RentLog> logs =  rentlogsService.findAll();
		
		
		return logs;
	}
	
	
}
