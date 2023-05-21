package com.ssm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ssm.pojo.Users;

public interface UserDao extends Repository<Users, Integer> {
	List<Users> findByUsernameIs(String string);
	@Query("from Users")
	List<Users> queryAll();
	@Query(value = "select * from t_users",nativeQuery=true)
	List<Users> findUsers();
	
	List<Users> findByUsernameEquals(String string);
	
	List<Users> findByUsernameLike(String string);
	
	List<Users> findByUseridGreaterThanEqual(Integer id);

}
