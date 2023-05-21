package com.ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.UserDao;
import com.ssm.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UsersDaoImplTest {

	@Autowired
	private UserDao usersDao;
	
	
	/**
	 * 添加用户
	 */
	@Test
	@Transactional// 在测试类对于事务提交方式默认的是回滚。
	@Rollback(false)//取消自动回滚
	public void testInsertUsers(){
		Users users = new Users();
		users.setUserage(24);
		users.setUsername("张三");
		List<Users> usersList = this.usersDao.findByUsernameIs("张三");
		System.out.println(usersList);
	}
	

	/**
	 * 添加用户
	 */
	@Test
	@Transactional// 在测试类对于事务提交方式默认的是回滚。
	@Rollback(false)//取消自动回滚
	public void testInsertUsersLike(){
		Users users = new Users();
		users.setUserage(24);
		users.setUsername("张三");
		List<Users> usersList = this.usersDao.findByUsernameLike("%三");
		System.out.println(usersList);
	}
	/**
	 * 添加用户
	 */
	@Test
	@Transactional// 在测试类对于事务提交方式默认的是回滚。
	@Rollback(false)//取消自动回滚
	public void findByIdGreaterThanEqual(){
		Users users = new Users();
		users.setUserage(24);
		users.setUsername("张三");
		List<Users> usersList = this.usersDao.findByUseridGreaterThanEqual(2);
		System.out.println(usersList);
	}
	
	/**
	 * 添加用户
	 */
	@Test
	@Transactional// 在测试类对于事务提交方式默认的是回滚。
	@Rollback(false)//取消自动回滚
	public void testInsertUsersEquals(){
		Users users = new Users();
		users.setUserage(24);
		users.setUsername("张三");
		List<Users> usersList = this.usersDao.findByUsernameEquals("张三");
		System.out.println(usersList);
	}
	

	
	/**
	 * 添加用户
	 */
	@Test
	@Transactional// 在测试类对于事务提交方式默认的是回滚。
	//@Rollback(false)//取消自动回滚
	public void testSelectUsers(){
		List<Users> usersList = this.usersDao.queryAll();
		System.out.println(usersList);
	}
	
	
	/**
	 * 添加用户
	 */
	@Test
	@Transactional// 在测试类对于事务提交方式默认的是回滚。
	//@Rollback(false)//取消自动回滚
	public void testFindUsers(){
		List<Users> usersList = this.usersDao.findUsers();
		System.out.println(usersList);
	}
	
}