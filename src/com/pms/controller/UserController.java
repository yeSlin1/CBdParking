package com.pms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pms.bean.Company;
import com.pms.bean.Manager;
import com.pms.bean.Personal;
import com.pms.bean.User;
import com.pms.service.impl.UserServiceImpl;

@Controller
public class UserController {
	@Resource
	UserServiceImpl userService;

	@RequestMapping("check")
	public String login(User user, ModelMap model,HttpServletRequest req) {
		HttpSession session;
		System.out.println(user.toString());
		User ucheck = userService.login(user);
		if (ucheck !=null) {
			model.addAttribute("user", ucheck);
		}
//		System.out.println(ucheck.toString());
		if (ucheck != null) {
			switch (ucheck.getUserType()) {
			// 0超级管理员 1企业用户 2个人用户 3操作员
			// 正常登陆
			case 0:
				Manager superManager = (Manager) ucheck;

				return "redirect:/manager/managers?managerId="+superManager.getManagerId();
			case 1:
				Company company = (Company) ucheck;
				session = req.getSession();
				session.setAttribute("company", company);
				return "/company";
			case 2:
				Personal personal = (Personal) ucheck;
				session = req.getSession();
				session.setAttribute("personal", personal);
				return "/personal";
			case 3:
				Manager manager = (Manager) ucheck;
				session = req.getSession();
				session.setAttribute("manager", manager);
				return "/manager";
			}
		}
		return "/login";
	}
	
	
}
