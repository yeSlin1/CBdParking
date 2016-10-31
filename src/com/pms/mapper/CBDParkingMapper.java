package com.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.pms.bean.CBDParking;

@Repository("cBDParkingMapper")
public interface CBDParkingMapper {

	/**
	 * 增加一个cbd停车位
	 * @param cbdParking对象
	 * @return int
	 */

	@Insert("insert into cbdparking values(null,#{cbdParking.cbdNo},#{cbdParking.company.companyId})")
	
	public int addCBDParking(@Param("cbdParking") CBDParking cbdParking);// 增

	/**
	 * 根据ID删除对象
	 * @param cbdParkingId
	 * @return int
	 */
	@Delete("delete from cbdparking where cbd_id=#{cbdParkingId}")
	
	public int delCBDParking(@Param("cbdParkingId") int cbdParkingId);// 删
	
	/**
	 * 传一个对象 修改
	 * @param cbdParking
	 * @return
	 */
	@Update("update cbdparking set cbd_no=#{cbdParking.cbdNo},company_id=#{cbdParking.company.companyId} where cbd_id=#{cbdParking.cbdId}")
	
	public int updateCBDParking(@Param("cbdParking") CBDParking cbdParking);// 改
	
	/**
	 * 返回所有的cbd停车位
	 * @return
	 */
	@Select("select * from cbdparking")
	@Results({ 
			@Result(id = true, property = "cbdId", column = "cbd_id", javaType = Integer.class),
			@Result(property = "cbdNo", column = "cbd_no", javaType = String.class),
			@Result(property = "company", column = "company_id", one=@One(select="com.pms.mapper.CompanyMapper.getCompanyById")),
	})
	public List<CBDParking> findAllCBDParking();// 查
	
	/**
	 * 通过编号返回车位
	 * @param no
	 * @return
	 */
	@Select("select * from cbdparking where cbd_no=#{no}")
	@Results({
		@Result(id = true, property = "cbdId", column = "cbd_id", javaType = Integer.class),
		@Result(property = "cbdNo", column = "cbd_no", javaType = String.class),
		@Result(property = "company", column = "company_id", one=@One(select="com.pms.mapper.CompanyMapper.getCompanyById")),
	})
	public CBDParking findCBDParkingByNo(@Param("no")String no);

	/**
	 * 通过企业ID返回该企业拥有的车位，供Company用
	 * @param CompanyId
	 * @return
	 */
	
	@Select("select * from cbdparking where company_id=#{CompanyId}")
	@Results({
		@Result(id = true, property = "cbdId", column = "cbd_id", javaType = Integer.class),
		@Result(property = "cbdNo", column = "cbd_no", javaType = String.class),
		@Result(property = "company", column = "company_id", one=@One(select="com.pms.mapper.CompanyMapper.getCompanyById")),
	})
	public List<CBDParking> getCBDParkingByCompanyId(@Param("CompanyId")int CompanyId);

	

	
	/**
	 * 通过企业ID返回该企业拥有的车位
	 * @param CompanyId start和row用于分页显示
	 * @return parking列表
	 */
	@Select("select * from cbdparking where company_id=#{CompanyId} limit #{start},#{row}")
	@Results({
		@Result(id = true, property = "cbdId", column = "cbd_id", javaType = Integer.class),
		@Result(property = "cbdNo", column = "cbd_no", javaType = String.class),
		@Result(property = "company", column = "company_id", one=@One(select="com.pms.mapper.CompanyMapper.getCompanyById")),
	})
	public List<CBDParking> findCBDParkingByCompanyId(@Param("start")int start,@Param("row")int row,@Param("CompanyId")int CompanyId);
	
	//上面方法的总页数
	@Select("select count(*) from cbdparking where company_id=#{CompanyId}")
	
	public int CBDParkingPage(@Param("CompanyId")int CompanyId);
	
	/**
	 * 通过企业ID返回企业空闲车位，注意，与上方法联表不同。。
	 * @param CompanyId start和row用于分页显示
	 * @return
	 */

	@Select("SELECT * FROM cbdparking WHERE cbd_id NOT IN (SELECT cbd_id FROM contract_cbdparking) AND company_id=#{CompanyId} limit #{start},#{row}")
	@Results({
		@Result(id = true, property = "cbdId", column = "cbd_id", javaType = Integer.class),
		@Result(property = "cbdNo", column = "cbd_no", javaType = String.class),
		@Result(property = "company", column = "company_id", one=@One(select="com.pms.mapper.CompanyMapper.getCompanyById")),
	})
	public List<CBDParking> findFreeCBDParkingByCompanyId(@Param("start")int start,@Param("row")int row,@Param("CompanyId") int CompanyId);


	
	//上面方法的总页数

	@Select("SELECT count(*)  FROM cbdparking WHERE cbd_id NOT IN (SELECT cbd_id FROM contract_cbdparking) AND company_id=#{CompanyId} ")
	public int FreeCBDParkingPage(@Param("CompanyId")int CompanyId);


	/**
	 * 通过企业ID返回企业租到的车位。联表不同
	 * @param CompanyId start和row用于分页显示
	 * @return
	 */

	@Select("SELECT * FROM cbdparking WHERE  cbd_id IN "
			+ "(SELECT cbd_id FROM contract_cbdparking WHERE "
			+ "contract_id IN(SELECT contract_id FROM contract WHERE  "
			+ "contract_direction =1 AND company_id=#{CompanyId})) limit #{start},#{row}")
	@Results({
		@Result(id = true, property = "cbdId", column = "cbd_id", javaType = Integer.class),
		@Result(property = "cbdNo", column = "cbd_no", javaType = String.class),
		@Result(property = "company", column = "company_id", one=@One(select="com.pms.mapper.CompanyMapper.getCompanyById")),
	})
	public List<CBDParking> findRentCBDParkingByCompanyId(@Param("start")int start,@Param("row")int row,@Param("CompanyId")int CompanyId);	

	
	//上面方法的总页数

	@Select("SELECT count(*) FROM cbdparking WHERE  cbd_id IN "
			+ "(SELECT cbd_id FROM contract_cbdparking WHERE "
			+ "contract_id IN(SELECT contract_id FROM contract WHERE "
			+ " contract_direction =1 AND company_id=#{CompanyId}))")
	public int RentCBDParkingPage(@Param("CompanyId")int CompanyId);


	
	/**
	 * 通过ContractId返回合约中涉及的车位
	 * @param contractId
	 * @return
	 */

	@Select("SELECT * FROM cbdparking WHERE cbd_id IN (SELECT cbd_id FROM contract_cbdparking WHERE contract_id=#{contractId}) ")
	@Results({
		@Result(id = true, property = "cbdId", column = "cbd_id", javaType = Integer.class),
		@Result(property = "cbdNo", column = "cbd_no", javaType = String.class),
		@Result(property = "company", column = "company_id", one=@One(select="com.pms.mapper.CompanyMapper.getCompanyById")),
	})
	public List<CBDParking> fingCBDParkingByContractId(@Param("contractId")int contractId);
	
	
}



