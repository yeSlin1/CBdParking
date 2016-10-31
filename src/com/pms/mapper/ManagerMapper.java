package com.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.pms.bean.Manager;
import com.pms.bean.Power;
import com.pms.bean.Manager;

@Repository
public interface ManagerMapper {
	/**
	 * 增加
	 * @param manager
	 * @return
	 */

	@Insert("insert into manager (manager_name,manager_phone,manager_no,user_id) VALUES (#{manager.managerName},#{manager.managerPhone},#{manager.managerNo},#{manager.userId})")
	public int addManager(@Param("manager") Manager manager);

	/**
	 * 删除
	 * @param managerId
	 * @return
	 */
	//删除方法
	@Delete("delete from manager where manager_id=#{managerId}")
	public int delManager(@Param("managerId") int managerId);

	/**
	 * 修改
	 * @param manager
	 * @return
	 */
	//更改方法
	@Update("update manager set manager_name=#{manager.managerName},manager_phone=#{manager.managerPhone},manager_no=#{manager.managerNo} where manager_id=#{manager.managerId}")
	public int updateManager(@Param("manager") Manager manager);

	/**
	 * 查所有
	 * @return
	 */
	//查询所有管理员
	@Select("SELECT * FROM manager m LEFT JOIN users u ON m.user_id=u.user_id")

	@Results({
		@Result(id=true,column="manager_id",property="managerId",javaType=Integer.class),
		@Result(column="manager_name",property="managerName",javaType=String.class),
		@Result(column="manager_phone",property="managerPhone",javaType=String.class),
		@Result(column="manager_no",property="managerNo",javaType=Integer.class),
		@Result(column="user_id",property="userId",javaType=Integer.class),
		@Result(column="user_name",property="userName",javaType=String.class),
		@Result(column="user_password",property="userPassword",javaType=String.class),
		@Result(column="user_type",property="userType",javaType=Integer.class)
		
	})
	public List<Manager> findAllManager();

	//根据ID查询管理员信息
	@Select("SELECT * FROM manager m LEFT JOIN users u ON m.user_id=u.user_id where manager_id=#{managerId} ")
	@Results({
		@Result(id=true,column="manager_id",property="managerId",javaType=Integer.class),
		@Result(column="manager_name",property="managerName",javaType=String.class),
		@Result(column="manager_phone",property="managerPhone",javaType=String.class),
		@Result(column="manager_no",property="managerNo",javaType=Integer.class),
		@Result(column="user_id",property="userId",javaType=Integer.class),
		@Result(column="user_name",property="userName",javaType=String.class),
		@Result(column="user_password",property="userPassword",javaType=String.class),
		@Result(column="user_type",property="userType",javaType=Integer.class),
		@Result(property="power",column="manager_id",many=@Many(select="com.pms.mapper.PowerMapper.findPowerByManager"))
		
	})
	public Manager findManagerById(@Param("managerId") int managerId);
	
	/**
	 * 通过 id返回一个对象
	 * @param managerId
	 * @return
	 */
	@Select("select * from manager where manager_id=#{managerId} ")
	@Results({ @Result(id = true, column = "manager_id", property = "managerId", javaType = Integer.class),
			@Result(property = "managerName", column = "manager_name", javaType = String.class),
			@Result(property = "managerPhone", column = "manager_phone", javaType = String.class),
			@Result(property = "managerNo", column = "manager_no", javaType = Integer.class),
			@Result(property = "power", column = "manager_id", many = @Many(select = "com.pms.mapper.PowerMapper.findManagerByPower") )
	})
	public List<Manager> findManagerByPower(@Param("powerId")int powerId);
	
 //根据管理员ID 来查询他的信息与权限

	  @Select("select * from manager  m LEFT JOIN users u ON m.user_id=u.user_id where manager_id=#{managerId} ")
	  @Results({
		  @Result(id=true,column="manager_id",property="managerId",javaType=Integer.class),
		  @Result(property="managerName",column="manager_name",javaType=String.class),
		  @Result(property="managerPhone",column="manager_phone",javaType=String.class),
		  @Result(property="managerNo",column="manager_no",javaType=Integer.class),
		  @Result(column="user_id",property="userId",javaType=Integer.class),
		  @Result(column="user_name",property="userName",javaType=String.class),
		  @Result(column="user_password",property="userPassword",javaType=String.class),
		  @Result(column="user_type",property="userType",javaType=Integer.class),
		  @Result(property="power",column="manager_id",many=@Many(select="com.pms.mapper.PowerMapper.findPowerByManager"))
		  
	  })
	  public  Manager  findManagerWithPower(@Param("managerId")int managerId);	  
	  
	  //模糊查询 分页manager
	  @Select("select * from manager  m LEFT JOIN users u ON m.user_id=u.user_id WHERE m.manager_name LIKE '%${managerName}%' LIMIT #{start},#{row}")
	  @Results({
		  @Result(id=true,column="manager_id",property="managerId",javaType=Integer.class),
		  @Result(property="managerName",column="manager_name",javaType=String.class),
		  @Result(property="managerPhone",column="manager_phone",javaType=String.class),
		  @Result(property="managerNo",column="manager_no",javaType=Integer.class),
		  @Result(column="user_id",property="userId",javaType=Integer.class),
		  @Result(column="user_name",property="userName",javaType=String.class),
		  @Result(column="user_password",property="userPassword",javaType=String.class),
		  @Result(column="user_type",property="userType",javaType=Integer.class),
		  @Result(property="power",column="manager_id",many=@Many(select="com.pms.mapper.PowerMapper.findPowerByManager"))
	  })
	  public List<Manager> findManagerByName(@Param("start") int start,@Param("row") int row,@Param("managerName")String managerName);
	  
	  //返回条数
	  @Select("select count(*) as count from manager m where  m.manager_name LIKE'%${managerName}%'")
	  public int findManagerPageNumber(@Param("managerName")String managerName);
	  
	  //在关系表里添加数据
	  @Insert("INSERT into manager_power VALUES (null,#{ManagerId},#{powerId})")
	  public int addManagerAndPower(@Param("ManagerId")int ManagerId,@Param("powerId")int powerId);
	  
	  //删除Manager权限
	  @Delete("DELETE from manager_power WHERE manager_id=#{managerId}")
	  public int delManagerAndPower(@Param("managerId")int managerId);
	  
	  //修改关系表
	  @Update("update manager_power set manager_id=#{managerId},power_id=#{powerId} where manager_id=#{managerId}")
	  public int updateMManagerAndPower(@Param("managerId")int managerId,@Param("powerId")int powerId);
	  
	  //通过UserId来查找Manager
	  @Select("select * from users u LEFT JOIN manager m ON u.user_id=m.user_id WHERE u.user_id=#{userId}")
	  @Results({
	  @Result(id=true,column="manager_id",property="managerId",javaType=Integer.class),
	  @Result(property="managerName",column="manager_name",javaType=String.class),
	  @Result(property="managerPhone",column="manager_phone",javaType=String.class),
	  @Result(property="managerNo",column="manager_no",javaType=Integer.class),
	  @Result(column="user_id",property="userId",javaType=Integer.class),
	  @Result(column="user_name",property="userName",javaType=String.class),
	  @Result(column="user_password",property="userPassword",javaType=String.class),
	  @Result(column="user_type",property="userType",javaType=Integer.class),
	  })
	  public Manager findManagerByUserId(@Param("userId")int userId);
	  
}
