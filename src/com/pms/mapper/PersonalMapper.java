package com.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.pms.bean.Parking;
import com.pms.bean.Personal;

@Repository("personalMapper")
public interface PersonalMapper {

	/**
	 * 这是添加个人用户的方法
	 * @param personal  个人用户对象
	 * @return 返回一个int类型数值
	 * ok
	 */
	@Insert("insert into personal values(null,#{personal.personalName},#{personal.personalRealName},#{personal.personalPhone},"
			+ "#{personal.personalIdCard},#{personal.personalAddress},#{personal.personalJob},#{personal.tenantReputation},"
			+ "#{personal.renterReputation},#{personal.userId})")
	@Options(keyProperty="personal.personalId",useGeneratedKeys=true)
	public int addPersonal(@Param("personal") Personal personal);

	/**
	 * 这是一个删除个人用户的方法
	 * @param personalId 传入的参数是个人用户的编号
	 * @return 返回一个int类型数值
	 * ok
	 */
	@Delete("delete from personal where personal_id=#{personalId}")
	public int delPersonal(@Param("personalId") int personalId);

	/**
	 * 这是一个修改个人用户的方法
	 * @param personal 传入参数是一个personal对象
	 * @return 返回值是int类型的数值
	 * ok
	 */
	@Update("update personal  set   "
			+ "personal_phone=#{personal.personalPhone},personal_address="
			+ "#{personal.personalAddress},personal_job=#{personal.personalJob} where personal_id=#{personal.personalId}")
	public int updatePersonal(@Param("personal") Personal personal);

	/**
	 * 这是一个查询所有个人用户信息的方法
	 * @return 返回一个Personal类型的list数组
	 * 
	 */
	@Select("select * from personal p left join users u on p.user_id = u.user_id")
	@Results({ @Result(id = true, property = "personalId", column = "personal_id", javaType = Integer.class),
			@Result(property = "personalName", column = "personal_name", javaType = String.class),
			@Result(property = "personalRealName", column = "personal_realName", javaType = String.class),
			@Result(property = "personalPhone", column = "personal_phone", javaType = String.class),
			@Result(property = "personalIdCard", column = "personal_idCard", javaType = String.class),
			@Result(property = "personalAddress", column = "personal_address", javaType = String.class),
			@Result(property = "personalJob", column = "personal_job", javaType = String.class),
			@Result(property = "tenantReputation", column = "tenant_reputation", javaType = Double.class),
			@Result(property = "renterReputation", column = "renter_reputation", javaType = Double.class),
			@Result(property = "userId", column="user_id",javaType=Integer.class ),
			@Result(property = "userName", column="user_name",javaType=String.class ),
			@Result(property = "userPassword", column="user_password",javaType=String.class ),
			@Result(property = "userType", column="user_type",javaType=Integer.class ), 
			})
	public List<Personal> getAllPersonal();

	/**
	 * 通过个人用户编号查找个人用户
	 * @param personalId  传入参数是个人用户编号
	 * @return 返回一个personal（个人用户）对象
	 * ok
	 */
	@Select("select * from personal p left join users u on p.user_id = u.user_id WHERE personal_id=#{personalId}")
	@Results({ @Result(id = true, property = "personalId", column = "personal_id", javaType = Integer.class),
		@Result(property = "personalName", column = "personal_name", javaType = String.class),
		@Result(property = "personalRealName", column = "personal_realName", javaType = String.class),
		@Result(property = "personalPhone", column = "personal_phone", javaType = String.class),
		@Result(property = "personalIdCard", column = "personal_idCard", javaType = String.class),
		@Result(property = "personalAddress", column = "personal_address", javaType = String.class),
		@Result(property = "personalJob", column = "personal_job", javaType = String.class),
		@Result(property = "tenantReputation", column = "tenant_reputation", javaType = Double.class),
		@Result(property = "renterReputation", column = "renter_reputation", javaType = Double.class),
		@Result(property = "userId", column="user_id",javaType=Integer.class ),
		@Result(property = "userName", column="user_name",javaType=String.class ),
		@Result(property = "userPassword", column="user_password",javaType=String.class ),
		@Result(property = "userType", column="user_type",javaType=Integer.class ),
		@Result(property = "parkList", column = "personal_id", many = @Many(select = "com.pms.mapper.ParkingMapper.getParkingByPersonId"))
	})
	public Personal findPersonalById(int personalId);
	
	
	@Select("select * from personal p left join users u on p.user_id = u.user_id WHERE u.user_id=#{userId}")
	@Results({ @Result(id = true, property = "personalId", column = "personal_id", javaType = Integer.class),
		@Result(property = "personalName", column = "personal_name", javaType = String.class),
		@Result(property = "personalRealName", column = "personal_realName", javaType = String.class),
		@Result(property = "personalPhone", column = "personal_phone", javaType = String.class),
		@Result(property = "personalIdCard", column = "personal_idCard", javaType = String.class),
		@Result(property = "personalAddress", column = "personal_address", javaType = String.class),
		@Result(property = "personalJob", column = "personal_job", javaType = String.class),
		@Result(property = "tenantReputation", column = "tenant_reputation", javaType = Double.class),
		@Result(property = "renterReputation", column = "renter_reputation", javaType = Double.class),
		@Result(property = "userId", column="user_id",javaType=Integer.class ),
		@Result(property = "userName", column="user_name",javaType=String.class ),
		@Result(property = "userPassword", column="user_password",javaType=String.class ),
		@Result(property = "userType", column="user_type",javaType=Integer.class ),
	})
	public Personal findPersonlByUserId(@Param("userId")int userId);
	
	/**
	 * 供parkingMessageMapper调用
	 * @param personalId
	 * @return
	 * ok
	 */
	@Select("select *  from personal where personal_id=#{personalId}")
	@Results({ @Result(id = true, property = "personalId", column = "personal_id", javaType = Integer.class),
		@Result(property = "personalName", column = "personal_name", javaType = String.class),
		@Result(property = "personalRealName", column = "personal_realName", javaType = String.class),
		@Result(property = "personalPhone", column = "personal_phone", javaType = String.class),
		@Result(property = "personalIdCard", column = "personal_idCard", javaType = String.class),
		@Result(property = "personalAddress", column = "personal_address", javaType = String.class),
		@Result(property = "personalJob", column = "personal_job", javaType = String.class),
		@Result(property = "tenantReputation", column = "tenant_reputation", javaType = Double.class),
		@Result(property = "renterReputation", column = "renter_reputation", javaType = Double.class),
	})
	public Personal getPersonalById(int personalId);
	
	
}
