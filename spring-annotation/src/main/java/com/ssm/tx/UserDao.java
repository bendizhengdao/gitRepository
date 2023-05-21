package com.ssm.tx;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(){
		String sql ="insert into tb_user (username,age) value(?,?)";
		String userName = UUID.randomUUID().toString();
		jdbcTemplate.update(sql, userName,12);
	}
}
