package com.pms.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.pms.bean.CBDParking;
import com.pms.bean.Company;
/*
 * 这个service主要是负责企业用户的业务其中包含企业用户资料维护，
 * 以及企业用户车位各种不同条件的查询分页等方法
 * 
 */
public interface CompanyService {
	static final int PAGE_NUM=5;
		
		/**
		 * 更新一条企业信息，注意数据的合法检查
		 * @param company 要更新的企业信息
		 * @return 是否更改成功 成功1 失败0
		 */
		public int updateCompany( Company company);
		
		/**
		 * 找出指定的一个公司拥有的CBDParking 分页显示
		 * @param company 需要查询的公司
		 * @param page 选中要显示的页数
		 * @return 当前页码的此公司所有的cbd停车位
		 */
		public List<CBDParking> findAllCBDParkingByCompany(Company company,int page);
		/**
		 * 上面方法的获取所有页数的方法
		 * @param company
		 * @return 页码总数
		 */
		
		public int findAllCBDParkingPageByCompany (@Param("company")Company company);
		
		/**
		 * 找出指定的一个公司闲置未签约的CBDParking 分页显示
		 * @param company 需要查询的公司
		 * @param page 选中要显示的页数
		 * @return 当前页码的此公司所有的闲置cbd停车位
		 */
		public List<CBDParking> findFreeCBDParkingByCompany(Company company,int page);
		/**
		 * 上面方法的获取所有页数的方法
		 * @param company
		 * @return 页码总数
		 */
		public int findFreeCBDParkingPageByCompany (Company company);
		
		/**
		 * 找出指定的一个公司从本平台租到的CBDParking 分页显示，也就是说company是需要租用停车位的企业。
		 * @param company 需要查询的公司
		 * @param page 选中要显示的页数
		 * @return 当前页码的此公司从本平台租到的cbd停车位
		 */
		public List<CBDParking> findRentedCBDParkingByCompany(Company company,int page);
		/**
		 * 上面方法的获取所有页数的方法
		 * @param company
		 * @return 页码总数
		 */
		public int findRentedCBDParkingPageByCompany (Company company);
		
		/**
		 *管理员查询 所有的企业信息
		 * @return
		 */
		public List<Company> findall();

}
