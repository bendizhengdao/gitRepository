package com.bendizhengdao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bendizhengdao.dao.SysUserRepository;
import com.bendizhengdao.entity.SysUser;
import com.bendizhengdao.service.SysUserService;
import com.bendizhengdao.util.PageQuery;
@Service
public class SysUserServiceImpl implements SysUserService {

	 	@Autowired
	    private SysUserRepository sysUserRepository;

	    @Override
	    public void save(SysUser user) {
	    	sysUserRepository.save(user);
	    }

	    @Override
	    public void delete(SysUser user) {
	    	sysUserRepository.delete(user);
	    }

	    @Override
	    public List<SysUser> findAll() {
	        return sysUserRepository.findAll();
	    }

	    @Override
	    public Object findPage(PageQuery pageQuery) {
	        return sysUserRepository.findAll(PageRequest.of(pageQuery.getPage(), pageQuery.getSize()));
	    }
}
