package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.bean.CBDParking;
import com.pms.bean.Company;
import com.pms.mapper.CBDParkingMapper;
import com.pms.mapper.CompanyMapper;
import com.pms.service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService{


	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private CBDParkingMapper mapper;
	
	
	/**
	 * 更新一条企业信息，注意数据的合法检查
	 * @param company 要更新的企业信息
	 * @return 是否更改成功 成功1 失败0
	 */
	@Override
	public int updateCompany(Company company) {
		
		if(companyMapper.updateCompany(company)==1){
			return 1;
		}else{
			
			return 0;
		}		
	}

	/**
	 * 找出指定的一个公司拥有的CBDParking 分页显示
	 * @param company 需要查询的公司
	 * @param page 选中要显示的页数
	 * @return 当前页码的此公司所有的cbd停车位
	 */
	@Override
	public List<CBDParking> findAllCBDParkingByCompany(Company company, int page) {
		return mapper.findCBDParkingByCompanyId(page, PAGE_NUM, company.getCompanyId());
	}

	/**
	 * 上面方法的获取所有页数的方法
	 * @param company
	 * @return 页码总数
	 */
	@Override
	public int findAllCBDParkingPageByCompany(Company company) {
		// TODO Auto-generated method stub
		int allnum=mapper.CBDParkingPage(company.getCompanyId());
		int num=(allnum%PAGE_NUM==0)?(allnum/PAGE_NUM):(allnum/PAGE_NUM+1);
		return num;
	}

	/**
	 * 找出指定的一个公司闲置未签约的CBDParking 分页显示
	 * @param company 需要查询的公司
	 * @param page 选中要显示的页数
	 * @return 当前页码的此公司所有的闲置cbd停车位
	 */
	@Override
	public List<CBDParking> findFreeCBDParkingByCompany(Company company, int page) {
		// TODO Auto-generated method stub
		return mapper.findFreeCBDParkingByCompanyId(page, PAGE_NUM, company.getCompanyId());
	}

	/**
	 * 上面方法的获取所有页数的方法
	 * @param company
	 * @return 页码总数
	 */
	@Override
	public int findFreeCBDParkingPageByCompany(Company company) {
		// TODO Auto-generated method stub
		int allnum2=mapper.FreeCBDParkingPage(company.getCompanyId());
		int num2=(allnum2%PAGE_NUM==0)?(allnum2/PAGE_NUM):(allnum2/PAGE_NUM+1);
		return num2;
	}


	/**
	 * 找出指定的一个公司从本平台租到的CBDParking 分页显示，也就是说company是需要租用停车位的企业。
	 * @param company 需要查询的公司
	 * @param page 选中要显示的页数
	 * @return 当前页码的此公司从本平台租到的cbd停车位
	 */                     
	@Override
	public List<CBDParking> findRentedCBDParkingByCompany(Company company, int page) {	  
		int start=(page-1)*5;
		int CompanyId=company.getCompanyId();
		List<CBDParking> list=mapper.findRentCBDParkingByCompanyId(start, PAGE_NUM, CompanyId);
		return list;
	}                                                   

	/**
	 * 上面方法的获取所有页数的方法
	 * @param company
	 * @return 页码总数
	 */
	@Override
	public int findRentedCBDParkingPageByCompany(Company company) {
		int companyId=company.getCompanyId();
		int i=mapper.RentCBDParkingPage(companyId);
		return i%PAGE_NUM==0?i/PAGE_NUM:(i/PAGE_NUM)+1;
	}                          


}
