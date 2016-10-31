package com.pms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.pms.bean.Complain;
@Repository
public interface ComplainMapper {
	/**
	 * 添加投诉
	 * @param complain 传入complain对象进行添加
	 * @return 返回int类型验证结果
	 */
	@Insert("insert into complain values (null,#{complain.complainTime},#{complain.complain},#{complain.complainType}," +
			"#{complain.complainFrom.personalId},#{complain.complainTo.personalId},#{complain.parkingMessage.parkingMsgId})")
	@Options(keyProperty="complain.complainId",useGeneratedKeys=true)		
	public int addComplain(@Param("complain")Complain complain);//添加投诉
	
	/**
	 * 删除投诉
	 * @param complainId 传入complainId参数进行删除
	 * @return 返回int类型验证结果
	 */
	@Delete("delete from complain where complain_id=#{complainId}")
	public int delComplain(@Param("complainId")int complainId);//删除
	
	/**
	 * 修改投诉
	 * @param complain complainId 传入complainId参数进行删除
	 * @return 返回int类型验证结果
	 */
	@Update("update complain set complain_time=#{complain.complainTime},complain=#{complain.complain},complain_type=#{complain.complainType}," +
			"complain_from=#{complain.complainFrom.personalId},complain_to=#{complain.complainTo.personalId}," +
			"parkingMsg_id=#{complain.parkingMessage.parkingMsgId} where complain_id=#{complain.complainId}")
	public int updateComplain(@Param("complain")Complain complain);//修改
	
	/**
	 * 查询所有投诉
	 * @return 返回结果
	 */
	@Select("select * from complain")
	@Results({
		@Result(id=true,property="complainId",column="complain_id",javaType=Integer.class),
		@Result(property="complainTime",column="complain_time",javaType=Date.class),
		@Result(property="complain",column="complain",javaType=String.class),
		@Result(property="complainType",column="complain_type",javaType=Integer.class),
		@Result(property="complainFrom",column="complain_from",many=@Many(select="com.pms.mapper.PersonalMapper.getPersonalById")),
		@Result(property="complainTo",column="complain_to",many=@Many(select="com.pms.mapper.PersonalMapper.getPersonalById")),
		@Result(property="parkingMessage",column="parkingMsg_id",many=@Many(select="com.pms.mapper.ParkingMessageMapper.getParkMsgById"))
	})
	public List<Complain> getAllComplain();//返回所有
	
	/**
	 * 通过受理状态返回已受理
	 * @return complain_type 
	 */
	@Select("select * from complain  where complain_type=#{complainType}")
	@Results({
		@Result(id=true,property="complainId",column="complain_id",javaType=Integer.class),
		@Result(property="complainTime",column="complain_time",javaType=Date.class),
		@Result(property="complain",column="complain",javaType=String.class),
		@Result(property="complainType",column="complain_type",javaType=Integer.class),
		@Result(property="complainFrom",column="complain_from",one=@One(select="com.pms.mapper.PersonalMapper.getPersonalById")),
		@Result(property="complainTo",column="complain_to",one=@One(select="com.pms.mapper.PersonalMapper.getPersonalById")),
		@Result(property="parkingMessage",column="parkingMsg_id",one=@One(select="com.pms.mapper.ParkingMessageMapper.getParkMsgById")),
	})
	public List<Complain> getComplainByType(@Param("complainType")int complainType);
	
	@Select("select * from complain  where complain_type=#{complainType} limit #{page},#{row}")
	@Results({
		@Result(id=true,property="complainId",column="complain_id",javaType=Integer.class),
		@Result(property="complainTime",column="complain_time",javaType=Date.class),
		@Result(property="complain",column="complain",javaType=String.class),
		@Result(property="complainType",column="complain_type",javaType=Integer.class),
		@Result(property="complainFrom",column="complain_from",one=@One(select="com.pms.mapper.PersonalMapper.getPersonalById")),
		@Result(property="complainTo",column="complain_to",one=@One(select="com.pms.mapper.PersonalMapper.getPersonalById")),
		@Result(property="parkingMessage",column="parkingMsg_id",one=@One(select="com.pms.mapper.ParkingMessageMapper.getParkMsgById")),
	})
	public List<Complain> findComplainByType(@Param("page")int page,@Param("row")int row,@Param("complainType")int complainType);
	
	@Select("selet COUNT(*) from complain where complain_type=#{complainType} ")
	public int pageNum(@Param("complainType")int complainType);
}
