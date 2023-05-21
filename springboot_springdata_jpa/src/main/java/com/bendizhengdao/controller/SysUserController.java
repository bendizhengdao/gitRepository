package com.bendizhengdao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bendizhengdao.entity.SysUser;
import com.bendizhengdao.service.SysUserService;
import com.bendizhengdao.util.PageQuery;


@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    
    @PostMapping(value="/save")
    public Object save(@RequestBody SysUser user) {
        sysUserService.save(user);
        return 1;
    }
    
    @PostMapping(value="/delete")
    public Object delete(@RequestBody SysUser user) {
        sysUserService.delete(user);
        return 1;
    }
    
    @GetMapping(value="/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }
    
    @PostMapping(value="/findPage")
    public Object findPage(@RequestBody PageQuery pageQuery) {
        return sysUserService.findPage(pageQuery);
    }
}
