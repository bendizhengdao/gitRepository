package com.ssm.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ssm.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {
	
	List<User> findByName(String userName);
	
	List<User> findByNameOrEmail(String username,String email);
	
	List<User> findByNameLike(String userName);

}
