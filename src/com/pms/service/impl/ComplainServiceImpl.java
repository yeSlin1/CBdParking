package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.bean.Complain;
import com.pms.mapper.ComplainMapper;
import com.pms.service.ComplainService;

@Service
public class ComplainServiceImpl implements ComplainService {

	@Resource
	ComplainMapper complainMapper;
	
	public List<Complain> findAll() {
		// TODO Auto-generated method stub
		return complainMapper.getAllComplain();
	}

}
