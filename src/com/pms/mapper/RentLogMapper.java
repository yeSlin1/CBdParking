package com.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.pms.bean.ParkingMessage;
import com.pms.bean.Personal;
import com.pms.bean.RentLog;
@Repository
public interface RentLogMapper {
	/**
	 * 新增租赁日志
	 * @param rentLog 传入rentLog对象用于添加
	 * @return 返回int类型验证结果
	 */
	@Insert("insert into rentlogs values (null,#{rentLog.personal.personalId},#{rentLog.tenantMsg}," +
			"#{rentLog.rentLogType},#{rentLog.parkingMsg.parkingMsgId})")
	@Options(keyProperty="rentLog.rentLogId",useGeneratedKeys=true)
	public int addRentLog(@Param("rentLog")RentLog rentLog);//增
	
	/**
	 * 删除租赁日志
	 * @param rentLogId 传入rentLogId参数进行删除
	 * @return 返回int类型验证结果
	 */
	@Delete("delete from rentlogs where rentLog_id=#{rentLogId}")
	public int delRentLog(@Param("rentLogId")int rentLogId);//删
	
	/**
	 * 修改租赁日志
	 * @param rentLog 传入rentLogId参数进行修改
	 * @return 返回int类型验证结果
	 */
	@Update("update rentlogs set personal_id=#{rentLog.personal.personalId},tenant_msg=#{rentLog.tenantMsg}," +
			"rentLog_type=#{rentLog.rentLogType},parkingMsg_id=#{rentLog.parkingMsg.parkingMsgId} " +
			"where rentLog_id=#{rentLog.rentLogId}")
	public int updateRentLog(@Param("rentLog")RentLog rentLog);//改
	
	
	/**
	 * 查询所有租赁日志
	 * @return 返回RentLog集合
	 */
	@Select("select * from rentlogs")
		@Results({
		@Result(id=true,property="rentLogId",column="rentLog_id",javaType=Integer.class),
		@Result(property="personal",column="personal_id",many=@Many(select="com.pms.mapper.PersonalMapper.findPersonalById")),
		@Result(property="tenantMsg",column="tenant_msg",javaType=String.class),
		@Result(property="rentLogType",column="rentLog_type",javaType=Integer.class),
		@Result(property="parkingMsg",column="parkingMsg_id",many=@Many(select="com.pms.mapper.ParkingMessageMapper.findById"))
	})
	public List<RentLog> getAllRentLog();//返回所有Log
	
	/**
	 * 通过租车信息  返回一个 抢租 列表 不分页， 供parkingMessage调用
	 * @param parkingMessageId
	 * @return
	 */
	@Select("select * from rentlogs where parkingMsg_id=#{parkingMessageId}")
	@Results({
	@Result(id=true,property="rentLogId",column="rentLog_id",javaType=Integer.class),
	@Result(property="personal",column="personal_id",many=@Many(select="com.pms.mapper.PersonalMapper.getPersonalById")),
	@Result(property="tenantMsg",column="tenant_msg",javaType=String.class),
	@Result(property="rentLogType",column="rentLog_type",javaType=Integer.class),
	@Result(property="parkingMsg",column="parkingMsg_id",many=@Many(select="com.pms.mapper.ParkingMessageMapper.getParkMsgById"))
})
	public List<RentLog> getRentLogByParkingMessageId(@Param("parkingMessageId") int parkingMessageId);
	@Select("SELECT * from rentlogs where rentLog_type=1")
	@Results({
		@Result(id=true,property="rentLogId",column="rentLog_id",javaType=Integer.class),
		@Result(property="personal",column="personal_id",many=@Many(select="com.pms.mapper.PersonalMapper.getPersonalById")),
		@Result(property="tenantMsg",column="tenant_msg",javaType=String.class),
		@Result(property="rentLogType",column="rentLog_type",javaType=Integer.class),
    })
	public List<RentLog> getrentLoggg();
	/**
	 * 通过租车信息  返回一个 抢租 列表
	 * @param parkingMessageId
	 * @return
	 */
	@Select("select * from rentlogs where parkingMsg_id=#{parkingMessageId} limit #{start},#{row}")
	@Results({
	@Result(id=true,property="rentLogId",column="rentLog_id",javaType=Integer.class),
	@Result(property="personal",column="personal_id",many=@Many(select="com.pms.mapper.PersonalMapper.getPersonalById")),
	@Result(property="tenantMsg",column="tenant_msg",javaType=String.class),
	@Result(property="rentLogType",column="rentLog_type",javaType=Integer.class),
	@Result(property="parkingMsg",column="parkingMsg_id",
	             many=@Many(select="com.pms.mapper.ParkingMessageMapper.getParkMsgById"))
	})
	public List<RentLog> findRentLogByParkingMessageId(@Param("start")int start,@Param("row")int row,@Param("parkingMessageId")int parkingMessageId); 
	
	/**
	 * 上面方法的分页
	 * @param parkingMessageId
	 * @return
	 */
	@Select("select COUNT(*) from rentlogs where parkingMsg_id=#{parkingMessageId}")
	public int rentLogPageNum(@Param("parkingMessageId")int parkingMessageId);
	
	
}
