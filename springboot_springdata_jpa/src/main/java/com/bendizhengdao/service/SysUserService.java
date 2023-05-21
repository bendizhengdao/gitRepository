package com.bendizhengdao.service;

import java.util.List;

import com.bendizhengdao.entity.SysUser;
import com.bendizhengdao.util.PageQuery;

public interface SysUserService {
	/**
     * 保存用户
     * @param user
     */
    public void save(SysUser user);
    
    /**
     * 删除用户
     * @param id
     */
    public void delete(SysUser user);
    
    /**
     * 查询全部用户
     * @return
     */
    public List<SysUser> findAll();
    
    /**
     * 查询分页数据
     * @return
     */
    public Object findPage(PageQuery pageQuery);

}
