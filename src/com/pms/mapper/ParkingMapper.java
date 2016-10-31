package com.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.pms.bean.Parking;
import com.pms.bean.Personal;


@Repository("parkingMapper")
public interface ParkingMapper {
	
	/**
	 * 提交车位申请 还未通过申请 设置parkingType为0
	 * @param parking
	 * @return 返回int类型
	 */
	@Insert("insert into parkings(parking_id,property_no,"
			+ "parking_picture,parking_address,"
			+ "parking_no,parking_type,personal_id) values(null,"
			+ "#{parking.propertyNo},#{parking.parkingPicture},"
			+ "#{parking.parkingAddress},#{parking.parkingNo},0,#{parking.personal.personalId})")
	@Options(keyProperty="parking.parkingId",useGeneratedKeys=true)
	@Results({
		@Result(id=true,property="parkingId",column="parking_id",javaType=Integer.class),
		@Result(property="propertyNo",column="property_no",javaType=java.lang.String.class),
		@Result(property="parkingPicture",column="parking_picture",javaType=java.lang.String.class),
		@Result(property="parkingAddress",column="parking_address",javaType=java.lang.String.class),
		@Result(property="parkingNo",column="parking_no",javaType=java.lang.String.class),
		@Result(property="parkingType",column="parking_type",javaType=Integer.class),
		@Result(property="personal" ,column="personal_id" ,one = @One(select = "com.pms.mapper.PersonalMapper.getPersonalById"))
	})
	public int addParking(@Param("parking")Parking parking);
	
	/**
	 * 通过parkingId删除一个停车位
	 * @param 传入parkingId
	 * @return 返回int类型
	 */
	@Delete("delete from parkings where parking_id=#{parkingId}")
	public int delParking(@Param("parkingId")int parkingId);
	
	/**
	 * 修改一个车位的信息
	 * @param 传入parking类
	 * @return 返回int类型
	 */
	@Update("update parkings set  "
			+ "property_no=#{parking.propertyNo},"
			+ "parking_picture=#{parking.parkingPicture},"
			+ "parking_address=#{parking.parkingAddress},"
			+ "parking_no=#{parking.parkingNo},"
			+ "parking_type=#{parking.parkingType} "
			+ "where parking_id=#{parking.parkingId}")
	public int updateParking(@Param("parking")Parking parking);
	
	/**
	 * 查询包租婆所有车位的信息  以及车位的归属
	 * @return 返回一个List集合
	 */
	@Select("select * from parkings ")
	@Results({
		@Result(id=true,property="parkingId",column="parking_id",javaType=Integer.class),
		@Result(property="propertyNo",column="property_no",javaType=java.lang.String.class),
		@Result(property="parkingPicture",column="parking_picture",javaType=java.lang.String.class),
		@Result(property="parkingAddress",column="parking_address",javaType=java.lang.String.class),
		@Result(property="parkingNo",column="parking_no",javaType=java.lang.String.class),
		@Result(property="parkingType",column="parking_type",javaType=Integer.class),
		@Result(property="personal" ,column="personal_id" ,one = @One(select = "com.pms.mapper.PersonalMapper.getPersonalById"))
	})
	public List<Parking> getAllParking();
	
	/**
	 * 获取信息的总数
	 * @return  返回信息的总条数
	 */
	@Select("select COUNT(*) from parkings ")
	public int parkingPageNumber();
	
	/**
	 * 点击页码显示本页的条目
	 * @param currentPage  点击的页码
	 * @param rowPage   每页显示几条
	 * @return  返回当页的条目的集合
	 */
	@Select("select * from parkings limit #{currentPage},#{rowPage}")
	@ResultMap("parkingMap")
	public List<Parking> findParkingByPage(@Param("currentPage")int currentPage,@Param("rowPage")int rowPage);
	
	/**parkingMessqge 需要调用的方法
	 * 通过id获取一个Parking对象
	 * @param 传入id
	 * @return  返回Parking
	 * ok
	 */
	@Select("select * from parkings where parking_id=#{id}")
	@Results({
		@Result(id=true,property="parkingId",column="parking_id",javaType=Integer.class),
		@Result(property="propertyNo",column="property_no",javaType=java.lang.String.class),
		@Result(property="parkingPicture",column="parking_picture",javaType=java.lang.String.class),
		@Result(property="parkingAddress",column="parking_address",javaType=java.lang.String.class),
		@Result(property="parkingNo",column="parking_no",javaType=java.lang.String.class),
		@Result(property="parkingType",column="parking_type",javaType=Integer.class),
		@Result(property="personal",column="personal_id",javaType=Personal.class,one=@One(select="com.pms.mapper.PersonalMapper.getPersonalById")),
	})
	public Parking findParkingById(@Param("id")int id);
	
	@Select("select * from parkings where personal_id=#{personal.personalId}")
	@Results({
		@Result(id=true,property="parkingId",column="parking_id",javaType=Integer.class),
		@Result(property="propertyNo",column="property_no",javaType=java.lang.String.class),
		@Result(property="parkingPicture",column="parking_picture",javaType=java.lang.String.class),
		@Result(property="parkingAddress",column="parking_address",javaType=java.lang.String.class),
		@Result(property="parkingNo",column="parking_no",javaType=java.lang.String.class),
		@Result(property="parkingType",column="parking_type",javaType=Integer.class),
		@Result(property="personal",column="personal_id",javaType=Personal.class,one=@One(select="com.pms.mapper.PersonalMapper.getPersonalById")),
	})
	public List<Parking> findParkingByPersonalId(@Param("personal")Personal personal);
	
	/** 
	 * personal类调用
	 * 通过personID找到该包租婆的停车位，用于Person 调用
	 * @param personId
	 * @return Parking的集合
	 */
	@Select("select * from parkings where personal_id=#{personId}")
	@ResultMap("parkingMap")
	public List<Parking> getParkingByPersonId(@Param("personId")int personId);

	/**
	 * 用于分页显示包租婆的停车位
	 * @param start  页码
	 * @param row  每页显示数
	 * @param personId  个人id
	 * @return Parking的集合
	 */
	@Select("select * from parkings where personal_id=#{personId} limit #{start},#{row}")
	@ResultMap("parkingMap")
	public List<Parking> findParkingByPersonId(@Param("start")int start,@Param("row")int row,@Param("personId")int personId);
	
	/**
	 * 通过personid查询车位的总数
	 * @param personId
	 * @return 返回int类型
	 */
	@Select("select COUNT(*) from parkings where personal_id=#{personId}")
	public int ParkingPageNumberByPersonId(@Param("personId")int personId);
	
	/**
	 * 找到包租婆已经审批通过的车位
	 * @param personId
	 * @param parkingType 审批状态
	 * @return Parking类的集合
	 */
	@Select("select * from parkings where personal_id=#{personId} and parking_type=#{parkingType}")
	@ResultMap("parkingMap")
	public List<Parking> findParkingByParkType(@Param("personId")int personId,@Param("parkingType")int parkingType);
	
	/**
	 * 查询所有未审批的车位
	 * @param start 开始的条目
	 * @param row 每页显示的条数
	 * @param parkingType 审批状态
	 * @return Parking类的集合
	 */
	@Select("select * from parkings where parking_type=#{parkingType} limit #{start},#{row}")
	@ResultMap("parkingMap")
	public List<Parking> findParkingByParkingType(@Param("start")int start,@Param("row")int row ,@Param("parkingType")int parkingType);
	
	/**
	 * 通过parkingType查询有多少条目数
	 * @param parkingType
	 * @return 返回一个int类型
	 */
	@Select("select COUNT(*) from parkings where parking_type=#{parkingType}")
	public int parkingByParkingTypePageNumber(@Param("parkingType")int parkingType);
	
}
