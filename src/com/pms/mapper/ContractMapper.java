package com.pms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.pms.bean.Contract;
@Repository
public interface ContractMapper {
	/**
	 * 增加
	 * @param contract
	 * @return
	 * 已测试 通过
	 */
	@Insert("insert into contract values (null,#{contract.contractNo},#{contract.contractPicture},"
			+ "#{contract.contractType},#{contract.contractDirection},#{contract.contractStart},#{contract.contractEnd},#{contract.company.companyId})")
	public int addContract(@Param("contract")Contract contract);
	
	/**
	 * 删除通过ID
	 * @param contractId
	 * @return
	 * 有很多外键 ，直接不能直接删除体现出来
	 */
	@Delete("delete from contract where contract_id=#{contractId}")
	public int delContract(@Param("contractId") int contractId);
	
	/**
	 * 修改
	 * @param contract
	 * @return
	 * 已测试 可用
	 */
	@Update("update contract set contract_no=#{contract.contractNo},contract_picture=#{contract.contractPicture},"
			+ "contract_type=#{contract.contractType},contract_direction=#{contract.contractDirection},"
			+ "contract_start=#{contract.contractStart},contract_end=#{contract.contractEnd} where contract_id=#{contract.contractId} ")
	public int updateContract(@Param("contract")Contract contract);
	
	/**
	 * 已修改
	 * @return
	 * 已测试 可用
	 */
	@Select("select * from contract ")
	@Results({
		@Result(id=true,property="contractId",column="contract_id"),
		@Result(property="contractNo",column="contract_no"),
		@Result(property="contractPicture",column="contract_picture"),
		@Result(property="contractType",column="contract_type"),
		@Result(property="contractDirection",column="contract_direction"),
		@Result(property="contractStart",column="contract_start"),
		@Result(property="contractEnd",column="contract_end"),
		@Result(property="company",column="company_id",one=@One(select="com.pms.mapper.CompanyMapper.getCompanyById")),
		@Result(property="cbdparking",column="company_id",many=@Many(select="com.pms.mapper.CBDParkingMapper.getCBDParkingByCompanyId"))
	})
	public List<Contract> findAllContract();
	
	/**
	 * 通过编号查询
	 * @param contractNo
	 * @return
	 * 已测试 通过
	 */
	@Select("select * from contract where contract_no=#{contractNo}")
	@Results({
		@Result(id=true,property="contractId",column="contract_id"),
		@Result(property="contractNo",column="contract_no"),
		@Result(property="contractPicture",column="contract_picture"),
		@Result(property="contractType",column="contract_type"),
		@Result(property="contractDirection",column="contract_direction"),
		@Result(property="contractStart",column="contract_start"),
		@Result(property="contractEnd",column="contract_end"),
		@Result(property="companyId",column="company_id"),
	
	})
	public Contract findContractByContractNo(@Param("contractNo")String contractNo);
	
	/**
	 * 通过企业ID返回该企业签订的合约
	 * @param companyId  
	 * @return
	 * 已测试 可用
	 */
	@Select("select * from contract where company_id=#{companyId}")
	@Results({
		@Result(id=true,property="contractId",column="contract_id"),
		@Result(property="contractNo",column="contract_no"),
		@Result(property="contractPicture",column="contract_picture"),
		@Result(property="contractType",column="contract_type"),
		@Result(property="contractDirection",column="contract_direction"),
		@Result(property="contractStart",column="contract_start"),
		@Result(property="contractEnd",column="contract_end")
	})
	public List<Contract> findContractByCompanyId(@Param("companyId")int companyId);
	/**
	 * 找到指定ID的公司向平台求租车位的合约（contract_direction=1）
	 * @param companyId
	 * @return
	 */
	@Select("SELECT * FROM contract WHERE contract_direction = 1 AND company_id =#{companyId}  ")
	@Results({
		@Result(id=true,property="contractId",column="contract_id"),
		@Result(property="contractNo",column="contract_no"),
		@Result(property="contractPicture",column="contract_picture"),
		@Result(property="contractType",column="contract_type"),
		@Result(property="contractDirection",column="contract_direction"),
		@Result(property="contractStart",column="contract_start"),
		@Result(property="contractEnd",column="contract_end"),
		@Result(property="cbdparking",column="contractId",many=@Many(select="com.pms.mapper.CBDParkingMapper.fingCBDParkingByContractId"))
	})
	public  List<Contract> findReantedContractByCompanyId(@Param("companyId")int companyId);

}


