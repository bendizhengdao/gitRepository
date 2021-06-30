package com.ssm.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.RoleRepository;
import com.ssm.dao.UserRepository;
import com.ssm.pojo.Menus;
import com.ssm.pojo.Roles;
import com.ssm.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UsersDaoImplTest {

	@Autowired
	private UserRepository usersDao;
	
	@Autowired
	private RoleRepository rolesDao;

	/**
	 * 添加用户
	 */
	@Test
	@Transactional // 在测试类对于事务提交方式默认的是回滚。
	@Rollback(false) // 取消自动回滚
	public void testInsertUsers() {
		Users users = new Users();
		users.setUserage(24);
		users.setUsername("赵小楼");
		this.usersDao.save(users);
	}

	/**
	 * 添加用户
	 */
	@Test
	@Transactional // 在测试类对于事务提交方式默认的是回滚。
	@Rollback(false) // 取消自动回滚
	public void testDeleteUsers() {
		this.usersDao.delete(1);
	}

	/**
	 * 添加用户
	 */
	@Test
	@Transactional // 在测试类对于事务提交方式默认的是回滚。
	// @Rollback(false)//取消自动回滚
	public void testFindUsers() {
		Pageable pageable = new PageRequest(0, 2);
		Page<Users> findAll = this.usersDao.findAll(pageable);
		List<Users> content = findAll.getContent();
		System.out.println(content);
	}

	/**
	 * 添加用户
	 */
	@Test
	@Transactional // 在测试类对于事务提交方式默认的是回滚。
	// @Rollback(false)//取消自动回滚
	public void testFindUsersByAgeSort() {

		Order order2 = new Order(Direction.DESC, "userid");
		Order order1 = new Order(Direction.ASC, "userage");

		List<Order> orderList = new ArrayList<>();
		orderList.add(order1);
		orderList.add(order2);
		Sort sort = new Sort(Direction.DESC, "userid");

		Sort sort1 = new Sort(orderList);

		List<Users> findAll = this.usersDao.findAll(sort1);

		for (Users users : findAll) {
			System.out.println(users);
		}
	}

	/**
	 * 添加用户
	 */
	@Test
	@Transactional // 在测试类对于事务提交方式默认的是回滚。
	// @Rollback(false)//取消自动回滚
	public void testFindSpecification() {
		Specification<Users> specification = new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate equal = cb.equal(root.get("username"), "赵小楼");

				return equal;
			}
		};

		List<Users> findAll = this.usersDao.findAll(specification);
		System.out.println(findAll);
	}

	/**
	 * 添加用户
	 */
	@Test
	@Transactional// 在测试类对于事务提交方式默认的是回滚。
	//@Rollback(false)//取消自动回滚
	public void testMultiFindSpecification(){
		Specification<Users> specification = new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate equal = cb.equal(root.get("username"),"赵小楼");
				Predicate predicate = cb.equal(root.get("userage"), "20");
				List<Predicate> predicates = new ArrayList<Predicate>();
				predicates.add(equal);
				predicates.add(predicate);
				Predicate[] arr = new Predicate[predicates.size()]; 
				return cb.and(predicates.toArray(arr));
			}
		};
		/*
		Specification<Users> spec = new Specification<Users>() { 
			@Override 
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) { 
					return cb.or(cb.equal(root.get("username"),"王五 "),cb.equal(root.get("userage"), 25)); 
			}
		};
		
		Specification<Users> spec = new Specification<Users>() { 
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) { 
				return cb.like(root.get("username").as(String.class), "王%"); 
			} 
		};
		//分页 
		Pageable pageable = new PageRequest(2, 2); 
		Page<Users> page = this.usersDao.findAll(spec, pageable);
		
		
		//条件 
		Specification<Users> spec = new Specification<Users>() { 
			@Override 
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) { 
				return cb.like(root.get("username").as(String.class), "王%"); 
			} 
		};
		//排序
		Sort sort = new Sort(Direction.DESC,"userid");
		
		List<Users> findAll = this.usersDao.findAll(specification);
		
		*/
		
		//排序等定义 
		Sort sort = new Sort(Direction.DESC,"userid"); 
		//分页的定义 
		Pageable pageable = new PageRequest(0,2, sort); 
		//查询条件 
		Specification<Users> spec = new Specification<Users>() { 
			@Override 
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) { 
				return cb.like(root.get("username").as(String.class), "张%"); 
			} 
		};
		Page<Users> page = this.usersDao.findAll(spec, pageable);
		List<Users> userList = page.getContent();
		for (Users users : userList) {
			System.out.println(users);
		}

	}

	
	/**
	 * 添加用户同时添加角色
	 *
	@Test
	public void test1(){
		//创建角色
		Roles roles = new Roles();
		roles.setRolename("管理员");
		
		//创建用户
		Users users = new Users();
		users.setUserage(30);
		users.setUsername("赵小刚");
		
		//建立关系
		users.setRoles(roles);
		roles.setUsers(users);
		
		//保存数据
		this.usersDao.save(users);
	}
	*/
	
	/**
	 * 添加用户同时添加角色
	 */
	@Test
	public void test1(){
		//创建角色
		Roles roles = new Roles();
		roles.setRolename("管理员");
		roles.setRoleid(3);
		//创建用户
		Users users =new Users();
		users.setUserage(30);
		users.setUsername("小王");
		users.setUserid(14);
		
		//创建用户
		Users users1 =new Users();
		users1.setUserid(13);
		users1.setUserage(30);
		users1.setUsername("小赵");
		//建立关系
		roles.getUsers().add(users);
		roles.getUsers().add(users1);
		users.setRoles(roles);
		users1.setRoles(roles);
		//保存数据
		this.usersDao.save(users);
		//保存数据
		this.usersDao.save(users1);
	}
	
	/**
	 * 根据用户ID查询用户信息，同时查询角色
	 */
	@Test
	public void test2(){
		Users users = this.usersDao.findOne(14);
		System.out.println("用户姓名："+users.getUsername());
		Roles roles = users.getRoles();
		System.out.println(roles);
	}
	
	@Test
	public void testMenu(){
		//创建角色对象
		Roles roles = new Roles();
		roles.setRolename("超级管理员");
		
		//创建菜单对象    XXX管理平台 --->用户管理
		Menus menus = new Menus();
		menus.setMenusname("XXX管理平台");
		menus.setFatherid(-1);
		menus.setMenusurl(null);
		
		//用户管理菜单
		Menus menus1 = new Menus();
		menus1.setMenusname("用户管理");
		menus1.setFatherid(1);
		menus1.setMenusurl(null);
		
		
		//建立关系
		roles.getMenus().add(menus);
		roles.getMenus().add(menus1);
		
		menus.getRoles().add(roles);
		menus1.getRoles().add(roles);
		
		
		//保存数据
		this.rolesDao.save(roles);
	}
	
}
