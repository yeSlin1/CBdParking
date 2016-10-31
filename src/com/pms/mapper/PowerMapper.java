package com.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pms.bean.Manager;
import com.pms.bean.Power;

public interface PowerMapper {
	
	//根据权限ID 查找 对应的权限
	@Select("SELECT * FROM power WHERE power_id=#{powerId}")
	@Results({
		@Result(id=true,column="power_id",property="powerId",javaType=Integer.class),
		@Result(column="power_name",property="powerName",javaType=String.class)
	})
	public Power findPowerById(@Param("powerId")int powerId);
	

	//更具一个管理员的ID 来查找该管理员所拥有的 权限
	@Select("select * from power  where power_id in (select power_id from manager_power where manager_id=#{managerId})")
	@Results({
		@Result(id=true,column="power_id",property="powerId",javaType=Integer.class),
		@Result(column="power_name",property="powerName",javaType=String.class)

		
	})
	public List<Power> findPowerByManager(@Param("managerId")int managerId);
	
	//更具一个权限ID 在 查询管理员的与其相对应的信息
	//many to many
	@Select("select * from power where power_id=#{powerId} ")
	@Results({
		@Result(id=true,column="power_id",property="powerId",javaType=Integer.class),
		@Result(column="power_name",property="powerName",javaType=String.class),
		@Result(property="manager",column="power_id",many=@Many(select="com.pms.mapper.ManagerMapper.findManagerByPower"))
		
	})
	public Power  findPowerWithManager(@Param("powerId")int powerId);
	

}
