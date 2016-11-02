package com.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Results;

import com.pms.bean.User;

@Repository("userMapper")
public interface UserMapper {
	
	/**
	 * 添加User 
	 * @param user  传入user参数用于添加
	 * @return  返回int类型验证结果
	 * ok
	 */
	@Insert("insert into users values(null,#{user.userName},#{user.userPassword},#{user.userType})")
	@Options(keyProperty="user.userId",useGeneratedKeys=true)
	public int addUser(@Param("user")User user);
	
	/**
	 * 根据Id删除User
	 * @param userId  传入userId删除User
	 * @return  返回int类型验证结果
	 * ok
	 */
	@Delete("delete from users where user_id=#{userId}")
	public int delUser(@Param("userId")int userId); 
	
	/**
	 * 根据Id修改User 
	 * @param user  传入User修改需要修改的值
	 * @return 返回int类型验证结果
	 * ok
	 */ 
	@Update("update users set user_name=#{user.userName},"
			+ "user_password=#{user.userPassword},user_type=#{user.userType} where user_id=#{user.userId}")
	public int updateUser(@Param("user")User user);
	
	
	/**
	 * 根据Id查询User
	 * @param userId 传入userId
	 * @return  返回一个User对象显示
	 * ok
	 */
	
	@Select("select * from users where user_id=#{userId}")
	@Results({
		@Result(id=true,column="user_id",property="userId",javaType=Integer.class),
		@Result(column="user_name",property="userName",javaType=String.class),
		@Result(column="user_password",property="userPassword",javaType=String.class),
		@Result(column="user_type",property="userType",javaType=Integer.class)
	})
	public User getUserById(@Param("userId")int userId);
	
	/**
	 * 根据userName 返回对象
	 * @param userName
	 * @return
	 * ok
	 */
	

	@Select("select * from users where user_name=#{userName}")
	@Results({
		@Result(id=true,column="user_id",property="userId",javaType=Integer.class),
		@Result(column="user_name",property="userName",javaType=String.class),
		@Result(column="user_password",property="userPassword",javaType=String.class),
		@Result(column="user_type",property="userType",javaType=Integer.class)
	})
	public User getUserByUserName(@Param("userName")String userName);


	
	//=================================================================
	//					以下方法不一定用得到，未测试
	//=================================================================
	/**
	 * 根据userName模糊查询User
	 * @param userName  传入userName查询User
	 * @param page 当前页数
	 * @return  返回List用于存储和显示
	 */
	@Select("select *  from users where user_name LIKE  '%${userName}%'  limit #{page},5")
	@Results({
		@Result(id=true,column="user_id",property="userId",javaType=Integer.class),
		@Result(column="user_name",property="userName",javaType=String.class),
		@Result(column="user_password",property="userPassword",javaType=String.class),
		@Result(column="user_type",property="userType",javaType=Integer.class)
	})
	public List<User> getUserFindName(@Param("userName")String userName,@Param("page")int page);
	
	
	
	@Select("SELECT COunt(*) from users")
	public int  countPage();
	
	
	/**
	 * 查询全部User
	 * @param page 传入当前页数
	 * @return  返回List集合用于显示和存储
	 */
	@Select("select * from users limit #{page},5")
	@Results({
	  	  @Result(id=true,column="user_id",property="userId",javaType=Integer.class),
	  	  @Result(column="user_name",property="userName",javaType=String.class),
	  	@Result(column="user_password",property="userPassword",javaType=String.class),
	  	@Result(column="user_type",property="userType",javaType=Integer.class),
	    })
	public List<User> getAllUsers(@Param("page")int page);
	
}
