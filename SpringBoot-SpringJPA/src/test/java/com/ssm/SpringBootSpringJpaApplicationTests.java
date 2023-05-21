package com.ssm;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.dao.UserPagingAndSortingRepository;
import com.ssm.dao.UserRepository;
import com.ssm.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootSpringJpaApplication.class })
public class SpringBootSpringJpaApplicationTests {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserPagingAndSortingRepository userPagingAndSortingRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void save(){
		User user = new User();
		user.setName("林先越");
		user.setEmail("linxianyue@mybatis.com");
		userRepository.save(user);
		System.out.println(user);
	}
	
	@Test
	public void findByName(){
		List<User> userList = userRepository.findByName("张三");
		for (User user : userList) {
			System.out.println(user);
		}
	}

	@Test
	public void findByNameLike(){
		List<User> userList = userRepository.findByNameLike("%三%");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void findAll(){
		List<User> userList = (List<User>) userRepository.findAll();
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void findAllSort(){
		Order order = new Order(Direction.DESC,"id");
		List<Order> orders = new ArrayList<Order>();
		orders.add(order);
		List<User> userList = (List<User>) userPagingAndSortingRepository.findAll(Sort.by(orders));
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void findAllPaging(){
		Order order = new Order(Direction.DESC,"id");
		List<Order> orders = new ArrayList<Order>();
		orders.add(order);
		
		Sort sort = Sort.by(orders);
		
		Pageable page = PageRequest.of(0, 1,sort);

		 Page<User> pageInfo = userPagingAndSortingRepository.findAll(page);
		 int number = pageInfo.getNumber();
		 int size = pageInfo.getSize();
		 System.out.println("number   "+number  +"  size  "+size);
		 
		 List<User> userList = pageInfo.getContent();
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryName(){
		 List<User> userList = userPagingAndSortingRepository.queryName("张三");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryName2(){
		 List<User> userList = userPagingAndSortingRepository.queryName2("张三");
		for (User user : userList) {
			System.out.println(user);
		}
	}

	
	@Test
	public void queryNamelike(){
		 List<User> userList = userPagingAndSortingRepository.queryNamelike("张");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryNamelike2(){
		 List<User> userList = userPagingAndSortingRepository.queryNamelike2("张");
		for (User user : userList) {
			System.out.println(user);
		}
	}

	@Test
	public void queryNameNativeQuery(){
		 List<User> userList = userPagingAndSortingRepository.queryNameNativeQuery("张三");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryNameNativeQuery2(){
		 List<User> userList = userPagingAndSortingRepository.queryNameNativeQuery2("张三");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void queryNameNativeQueryLike(){
		 List<User> userList = userPagingAndSortingRepository.queryNameNativeQueryLike("三");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryNameNativeQueryLike2(){
		 List<User> userList = userPagingAndSortingRepository.queryNameNativeQueryLike2("三");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void queryNameAndSort(){
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Direction.DESC, "id"));
		Sort sort = Sort.by(orders);
		 List<User> userList = userPagingAndSortingRepository.queryNameAndSort("王五",sort);
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryNameAndSort2(){
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Direction.DESC, "id"));
		Sort sort = Sort.by(orders);
		 List<User> userList = userPagingAndSortingRepository.queryNameAndSort2("王五",sort);
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryNameAndPage(){
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Direction.DESC, "id"));
		Sort sort = Sort.by(orders);
		Pageable pageable = PageRequest.of(0, 1,sort);
		 List<User> userList = userPagingAndSortingRepository.queryNameAndPage("王五",pageable);
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryNameAndPage2(){
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Direction.DESC, "id"));
		Sort sort = Sort.by(orders);
		Pageable pageable = PageRequest.of(0, 1,sort);
		 List<User> userList = userPagingAndSortingRepository.queryNameAndPage2("王五",pageable);
		for (User user : userList) {
			System.out.println(user);
		}
	}

	
	
	
	@Test
	public void queryNativeQueryNameAndSort(){
		 List<User> userList = userPagingAndSortingRepository.queryNativeQueryNameAndSort("王五");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryNativeQueryNameAndSort2(){
		 List<User> userList = userPagingAndSortingRepository.queryNativeQueryNameAndSort2("王五");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryNativeQueryNameAndPage(){
		 List<User> userList = userPagingAndSortingRepository.queryNativeQueryNameAndPage("王五",0,1);
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void queryNativeQueryNameAndPage2(){
		 List<User> userList = userPagingAndSortingRepository.queryNativeQueryNameAndPage2("王五",0,1);
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void updateNameById(){
		 userPagingAndSortingRepository.updateNameById("郝五一",6);
		
	}
	

	@Test
	@Transactional
	@Rollback(false)
	public void updateNameById2(){
		 userPagingAndSortingRepository.updateNameById2("费大川",5);
		
	}

}
