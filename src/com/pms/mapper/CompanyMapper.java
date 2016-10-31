package com.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.pms.bean.Company;
@Repository
public interface CompanyMapper {
	/**
	 * 增加一个企业
	 * @param company
	 * @return
	 * 已测试 可用
	 */
	@Insert("insert into company values (null,#{company.companyName},#{company.companyAddress},"
			+ "#{company.companyResponsible},#{company.companyPhone},#{company.user.userId}) ")
	public int addCompany(@Param("company") Company company);
	
	/**
	 * 通过ID删除公司
	 * @param companyId
	 * @return
	 * 已测试 可用
	 */
	@Delete("delete from company where company_id=#{companyId}")
	public int delCompany(@Param("companyId") int companyId);
	
	/**
	 * 更新公司
	 * @param company
	 * @return
	 * 已测试 可用
	 */
	@Update("update company set company_name=#{company.companyName},company_address=#{company.companyAddress},"
			+ "company_responsible=#{company.companyAddress},company_phone=#{company.companyPhone} "
			+ "where company_id=#{company.companyId}")
	public int updateCompany(@Param("company") Company company);
	
	/**
	 * 返回所有企业列表
	 * @return
	 * 
	 */
	@Select("select * from company")
	@Results({
		@Result(id=true,property="companyId",column="company_id"),
		@Result(property="companyName",column="company_name"),
		@Result(property="companyAddress",column="company_address"),
		@Result(property="companyResponsible",column="company_responsible"),
		@Result(property="companyPhone",column="company_phone"),
		@Result(property="userId",column="user_id"),
		@Result(property="userName",column="user_name"),
		@Result(property="userPassword",column="user_password"),
		@Result(property="userType",column="user_type"),
		@Result(property="contract",column="company_id",many=@Many(select="com.pms.mapper.ContractMapper.findContractByCompanyId")),
		@Result(property="cbdParking",column="company_id",many=@Many(select="com.pms.mapper.CBDParkingMapper.getCBDParkingByCompanyId"))	
	})
	public List<Company> findAllCompany();
	/**
	 * 通过companyById 找到一个企业对象
	 * @param companyById
	 * @return
	 * 已测试 通过
	 */
	@Select("select * from company where company_id=#{companyId}")
	@Results({
		@Result(id=true,property="companyId",column="company_id"),
		@Result(property="companyName",column="company_name"),
		@Result(property="companyAddress",column="company_address"),
		@Result(property="companyResponsible",column="company_responsible"),
		@Result(property="companyPhone",column="company_phone"),
		@Result(property="userId",column="user_id"),
		@Result(property="userId",column="user_id"),
		@Result(property="userName",column="user_name"),
		@Result(property="userPassword",column="user_password"),
		@Result(property="userType",column="user_type")
	})
	public Company getCompanyById(@Param("companyId")int companyId);
	
	/**
	 * 供其它方法调用
	 * @param companyId
	 * @return
	 */
	@Select("select * from  company c LEFT JOIN users u ON c.user_id=u.user_id where company_id=#{companyId}")
	@Results({
		@Result(id=true,property="companyId",column="company_id"),
		@Result(property="companyName",column="company_name"),
		@Result(property="companyAddress",column="company_address"),
		@Result(property="companyResponsible",column="company_responsible"),
		@Result(property="companyPhone",column="company_phone"),
		@Result(property="userId",column="user_id"),
		@Result(property="userName",column="user_name"),
		@Result(property="userPassword",column="user_password"),
		@Result(property="userType",column="user_type"),
		@Result(property="contract",column="company_id",many=@Many(select="com.pms.mapper.ContractMapper.findContractByCompanyId")),
		@Result(property="cbdParking",column="company_id",many=@Many(select="com.pms.mapper.CBDParkingMapper.getCBDParkingByCompanyId"))
	})
	public Company findCompanyById(@Param("companyId")int companyId);
	
	/**
	 * 查询企业 ，分页，模糊
	 * @param start
	 * @param row
	 * @param companyName
	 * @return
	 * 已测试 通过
	 */
	@Select("select * from company   where company_name like '%${companyName}%' LIMIT #{start},#{row}")	
	@Results({
		@Result(id=true,property="companyId",column="company_id"),
		@Result(property="companyName",column="company_name"),
		@Result(property="companyAddress",column="company_address"),
		@Result(property="companyResponsible",column="company_responsible"),
		@Result(property="companyPhone",column="company_phone"),
		@Result(property="userId",column="user_id"),
	})
	public List<Company> findCompanyByPage(@Param("start")int start,@Param("row")int row,@Param("companyName")String companyName);

	/**
	 * 总页数
	 * @param companyName
	 * @return
	 * 已测试 通过
	 */
	@Select("select count(*) from company   where company_name like '%${companyName}%'")
	public int getCompanyPage(@Param("companyName")String companyName);
	/**
	 * 通过userId返回一个Company对象
	 * @param userId
	 * @return
	 */
	@Select("SELECT * FROM company c LEFT JOIN users u ON c.user_id=u.user_id WHERE c.user_id=#{userId}")
	@Results({
		@Result(id=true,property="companyId",column="company_id"),
		@Result(property="companyName",column="company_name"),
		@Result(property="companyAddress",column="company_address"),
		@Result(property="companyResponsible",column="company_responsible"),
		@Result(property="companyPhone",column="company_phone"),
		@Result(property="userId",column="user_id"),
		@Result(property="userId",column="user_id"),
		@Result(property="userName",column="user_name"),
		@Result(property="userPassword",column="user_password"),
		@Result(property="userType",column="user_type")
	})
	public Company findCompanyByUserId(int userId);
}
