package com.chinasoft.dubbo_shiro_orm.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chinasoft.dubbo_shiro_util.service.AdminService;
import com.chinasoft.dubbo_shiro_orm.mapper.AdminMapper;
import com.chinasoft.dubbo_shiro_orm.util.RedisUtil;
import com.chinasoft.dubbo_shiro_util.util.FinalMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String getPassWord(String username) {
        return userMapper.getPassWord(username);
    }

    @Override
    public String getRole(String username) {
        return userMapper.getRole(username);
    }

    @Override
    public boolean insertUser(Map<String, Object> map) {
        return userMapper.insertUser(map);
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        userMapper.updatePassword(username,newPassword);
    }

    @Override
    public List<String> getUser() {
        return userMapper.getUser();
    }

    @Override
    public void banUser(String username) {
        userMapper.banUser(username);
    }

    @Override
    public int checkUserBanStatus(String username) {
        return userMapper.checkUserBanStatus(username);
    }

    @Override
    public String getRolePermission(String username) {
        return userMapper.getRolePermission(username);
    }

    @Override
    public String getPermission(String username) {
        return userMapper.getPermission(username);
    }



}
