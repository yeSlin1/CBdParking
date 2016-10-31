package com.pms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pms.bean.Complain;
import com.pms.service.ComplainService;

@Controller
@RequestMapping("/Complain")
public class ComplainController {
	
	@Resource
	ComplainService  ComplainService;
	
	@RequestMapping("/list")
    @ResponseBody
    public List<Complain> list(){
		
		
		return ComplainService.findAll();
	}
}
