package com.pms.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.pms.bean.Parking;
import com.pms.bean.ParkingMessage;
import com.pms.bean.RentLog;
/**
 * 该类主要管理租车位信息的方法
 * @author suisuinian
 *
 */
@Repository("parkingMessageMapper")
public interface ParkingMessageMapper {
	/**
	 * 添加租车位信息
	 * @param parkingMsg 车位信息对象
	 * @return 添加是否成功
	 */
	@Insert("insert into parkingmessage values(null,#{parkingMsg.startTime},"
			+ "#{parkingMsg.endTime},#{parkingMsg.price},#{parkingMsg.parking.parkingId})")
	public int addParkingMessage(@Param("parkingMsg") ParkingMessage parkingMsg);

	/**
	 * 删除
	 * @param parkingMsgId 停车位信息ID
	 * @return 删除是否成功
	 */
	@Delete("delete  from parkingmessage where parkingMsg_id=#{parkingMsgId}")
	public int delParkingMessage(@Param("parkingMsgId") int parkingMsgId);

	/**
	 * 修改信息
	 * @param parkingMsg 传入停车位信息对象进行修改
	 * @return 修改是否成功
	 */
	@Update("update parkingmessage  set parkingMsg_start=#{parkingMsg.startTime},parkingMsg_end=#{parkingMsg.endTime},"
			+ "price=#{parkingMsg.price}")
	public int updateParkingMessage(@Param("parkingMsg") ParkingMessage parkingMsg);

	/**
	 * 查询所有发布的租车位信息
	 * @return 车位信息集合
	 */
	@Select("select * from parkingmessage")
	@Results({ @Result(id = true, property = "parkingMsgId", column = "parkingMsg_id", javaType = Integer.class),
			@Result(property = "startTime", column = "parkingMsg_start", javaType = Date.class),
			@Result(property = "endTime", column = "parkingMsg_end", javaType = Date.class),
			@Result(property = "price", column = "price", javaType = BigDecimal.class),
			@Result(property = "parking", column = "parking_id", 
			             one =@One(select = "com.pms.mapper.ParkingMapper.findParkingById"),javaType=Parking.class ) 
	})
	public List<ParkingMessage> getAllParkingMessage();

	/**
	 * 根据ID查找租车位信息
	 * @param id  租车位id
	 * @return 一个租车位信息对象
	 */
	@Select("select * from parkingmessage where parkingMsg_id=#{id}")
	// @ResultMap("parkingMessageMap")
	@Results({ @Result(id = true, property = "parkingMsgId", column = "parkingMsg_id", javaType = Integer.class),
			@Result(property = "startTime", column = "parkingMsg_start", javaType = Date.class),
			@Result(property = "endTime", column = "parkingMsg_end", javaType = Date.class),
			@Result(property = "price", column = "price", javaType = BigDecimal.class),
			@Result(property = "parking", column = "parking_id", 
			             one =@One(select = "com.pms.mapper.ParkingMapper.findParkingById"),javaType=Parking.class ) ,
	        @Result(property = "rentLogs", column = "parkingMsg_id", 
	                     many= @Many(select ="com.pms.mapper.RentLogMapper.getRentLogByParkingMessageId"))
	})
	public ParkingMessage findById(@Param("id") int id);

	/**
	 * RentLog 调用方法
	 * @param parkingMessageId
	 * @return  租车位信息对象
	 */
	@Select("select * from parkingmessage where parkingMsg_id=#{id}")
	@Results({ @Result(id = true, property = "parkingMsgId", column = "parkingMsg_id", javaType = Integer.class),
			@Result(property = "startTime", column = "parkingMsg_start", javaType = Date.class),
			@Result(property = "endTime", column = "parkingMsg_end", javaType = Date.class),
			@Result(property = "price", column = "price", javaType = BigDecimal.class),
			@Result(property = "parking", column = "parking_id", 
			             one =@One(select = "com.pms.mapper.ParkingMapper.findParkingById"),javaType=Parking.class ) ,
	})
	public ParkingMessage getParkMsgById(@Param("parkingMessageId")int parkingMessageId);
	/**
	 * 通过个人Id(包租婆)返回该人发布的有效待租信息
	 * @param start  开始的页数
	 * @param row   分页显示的条目数
	 * @param personId  个人ID
	 * @param now 当前时间，需要小于endTime
	 * @return     租车位信息集合
	 */
	@Select("SELECT * from parkingmessage where parking_id in"
			+ " (SELECT parking_id FROM parkings WHERE personal_id=#{personId} )   "
			+ "and #{now}<parkingMsg_end "
			+ "limit #{start},#{row}")
	@Results({ @Result(id = true, property = "parkingMsgId", column = "parkingMsg_id", javaType = Integer.class),
		@Result(property = "startTime", column = "parkingMsg_start", javaType = Date.class),
		@Result(property = "endTime", column = "parkingMsg_end", javaType = Date.class),
		@Result(property = "price", column = "price", javaType = BigDecimal.class),
		@Result(property = "parking", column = "parking_id", 
		            one =@One(select = "com.pms.mapper.ParkingMapper.findParkingById"),javaType=Parking.class ) 
	})
	public List<ParkingMessage> findParkingMsgByPersonal(@Param("start")int start,@Param("row")int row,@Param("personId")int personId,@Param("now")Date now);

	
	/**
	 * 通过个人Id返回该人（包租婆）发布的有效待租信息的总条目数
	 * @param personId 个人ID
	 * @param now   时间
	 * @return  总条目数
	 */
	@Select("SELECT count(*) from parkingmessage where parking_id in"
			+ " (SELECT parking_id FROM parkings WHERE personal_id=#{personId}) and #{now}<parkingMsg_end")
	public int ParkingMsgPageNumber(@Param("personId")int personId,@Param("now")Date now);
	
	/**
	 * 通过包租婆PersonalID查找包租婆已成交parkingMessage列表
	 * @param tentPersonalId 要查找的包租婆个人ID
	 * @return 包租婆已成交parkingMessage列表
	 */

	/**
	 * 通过包租婆PersonalID查找包租婆已成交parkingMessage列表
	 * @param tentPersonalId 要查找的包租婆个人ID
	 * @return 包租婆已成交parkingMessage列表
	 */
	@Select("SELECT * FROM parkingmessage WHERE  parking_id IN "
			+ "(SELECT parking_id FROM parkings WHERE personal_id=#{tentPersonalId}) "
			+ " and parkingMsg_id IN "
			+ "(SELECT parkingMsg_id FROM rentlogs WHERE rentLog_type=1) limit #{start},#{end}")
	@Results({ @Result(id = true, property = "parkingMsgId", column = "parkingMsg_id", javaType = Integer.class),
		@Result(property = "startTime", column = "parkingMsg_start", javaType = Date.class),
		@Result(property = "endTime", column = "parkingMsg_end", javaType = Date.class),
		@Result(property = "price", column = "price", javaType = BigDecimal.class),
		@Result(property = "parking", column = "parking_id", 
		             one =@One(select = "com.pms.mapper.ParkingMapper.findParkingById"),javaType=Parking.class ),
		@Result(property = "rentLogs", column= "parkingMsg_id", javaType=RentLog.class,
        many= @Many(select ="com.pms.mapper.RentLogMapper.getrentLoggg")),
})
	public List<ParkingMessage> findParkingMessageByTentPersonId(@Param("tentPersonalId")int tentPersonalId,@Param("start")int start,@Param("end")int end);
	
	/**
	 * 上方方法返回页码的功能
	 * @param tentPersonalId
	 * @return 指定包租婆已成交的parkingMessage总页数
	 */
	@Select("SELECT count(*) FROM parkingmessage WHERE  parking_id IN (SELECT parking_id FROM parkings WHERE personal_id=#{tentPersonalId}) and parkingMsg_id IN (SELECT parkingMsg_id FROM rentlogs WHERE rentLog_type=1) ")
	public int findParkingMessageByTentPersonIdPage(@Param("tentPersonalId")int tentPersonalId);
	/**
	 * 返回租客的历史成交记录
	 * @param start  开始的页数
	 * @param row   分页显示的条目数
	 * @param PersonId  个人ID
	 * @param rentLogType rentLog表中的 租赁状态，成交为1
	 * @return        租车位集合
	 */
	
	@Select("SELECT * FROM parkingmessage WHERE parkingMsg_id "
			+ "IN (SELECT parkingMsg_id FROM rentlogs WHERE rentLog_type=#{rentLogType} AND personal_id=#{PersonId}) "
			+ "limit #{start},#{row} ")
	
	@Results({ @Result(id = true, property = "parkingMsgId", column = "parkingMsg_id", javaType = Integer.class),
		@Result(property = "startTime", column = "parkingMsg_start", javaType = Date.class),
		@Result(property = "endTime", column = "parkingMsg_end", javaType = Date.class),
		@Result(property = "price", column = "price", javaType = BigDecimal.class),
		@Result(property = "parking", column = "parking_id", 
		             one =@One(select = "com.pms.mapper.ParkingMapper.findParkingById"),javaType=Parking.class ),
	    @Result(property = "rentLogs", column= "parkingMsg_id", 
	                 many= @Many(select ="com.pms.mapper.RentLogMapper.getRentLogByParkingMessageId")),
	       })
	public List<ParkingMessage> findParkingMessageByPersonId(@Param("start")int start,@Param("row")int row, @Param("PersonId")int PersonId,@Param("rentLogType")int rentLogType);
	
	/**
	 * 租客的历史成交记录的总条目数
	 * @param personId   个人ID
	 * @param rentLogType   租车位状态
	 * @return         总条目数
	 */
	@Select("SELECT count(*) FROM parkingmessage WHERE parkingMsg_id "
			+ "IN (SELECT parkingMsg_id FROM rentlogs WHERE rentLog_type=#{rentLogType} AND personal_id=#{personId})")
	
	public int ParkingMesPageNumber(@Param("personId")int personId,@Param("rentLogType")int rentLogType);
	/**
	 * 抢车位   符合时间条件的租车信息
	 * @param start   开始的页数
	 * @param row  分页显示条目数
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @return     租车位集合
	 */
	@Select("select * from parkingmessage where parkingMsg_end>#{begin} "
			+ "or parkingMsg_start<#{end} limit  #{start},#{row}")
	@Results({ @Result(id = true, property = "parkingMsgId", column = "parkingMsg_id", javaType = Integer.class),
		@Result(property = "startTime", column = "parkingMsg_start", javaType = Date.class),
		@Result(property = "endTime", column = "parkingMsg_end", javaType = Date.class),
		@Result(property = "price", column = "price", javaType = BigDecimal.class)
	})
	public List<ParkingMessage> findParkingMessageByTime(@Param("start")int start,@Param("row")int row,@Param("begin")Date begin,@Param("end")Date end);
	
	/**
	 * 抢车位   符合时间条件的租车信息的总条目数
	 * @param begin  开始时间
	 * @param end     结束时间
	 * @return            总条目数
	 */
	@Select("select count(*) from parkingmessage where parkingMsg_end>#{begin} or parkingMsg_start<#{end}")
	public int ParkingMessagePageNumber(@Param("begin")Date begin,@Param("end")Date end);
	/**
	 * 根据车位ID发布的租车位消息
	 * @param parkingId 车位ID
	 * @return   一个租车位集合
	 */
	@Select("select * from parkingmessage where parking_id=#{parkingId}")
	@Results({ @Result(id = true, property = "parkingMsgId", column = "parkingMsg_id", javaType = Integer.class),
		@Result(property = "startTime", column = "parkingMsg_start", javaType = Date.class),
		@Result(property = "endTime", column = "parkingMsg_end", javaType = Date.class),
		@Result(property = "price", column = "price", javaType = BigDecimal.class)
	})
	public List<ParkingMessage> findParkingMessageByParkingId(@Param("parkingId")int parkingId);
    
	/**
	 * 查询所有的出租车位信息
	 * @return
	 */
	@Select("SELECT * FROM parkingmessage where parkingMsg_id in "
			+ "(SELECT parkingMsg_id from rentlogs s where s.rentlog_type=0) LIMIT #{page},#{row}")
	@Results({ 
		@Result(id = true, property = "parkingMsgId", column = "parkingMsg_id", javaType = Integer.class),
		@Result(property = "startTime", column = "parkingMsg_start", javaType = Date.class),
		@Result(property = "endTime", column = "parkingMsg_end", javaType = Date.class),
		@Result(property = "price", column = "price", javaType = BigDecimal.class),
		@Result(property = "parking", column = "parking_id", 
		             one =@One(select = "com.pms.mapper.ParkingMapper.findParkingById"),javaType=Parking.class ),
	       })
	public  List<ParkingMessage> findRentParkingMessage(@Param("page")int page,@Param("row")int row);
	/**
	 * 查询分页方法
	 * @return
	 */
	@Select("SELECT count(*) FROM parkingmessage p where p.parkingMsg_id in "
			+ "(SELECT s.parkingMsg_id from rentlogs s where s.rentlog_type=0)")
	public int findRentParkingMessagePage();
	
}
