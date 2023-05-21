package com.ssm.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssm.dao.BookDao;

@Service
public class BookService {
	
	@Autowired
	@Qualifier("bookDao2")
	
	@Resource
	private BookDao bookDao;
	
	public void sayBookDao(){
		System.out.println(bookDao);
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
	
}
