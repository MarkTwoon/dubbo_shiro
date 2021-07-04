package com.chinasoft.dubbo_shiro_ioc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chinasoft.dubbo_shiro_ioc.exception.MyException;
import com.chinasoft.dubbo_shiro_ioc.exception.StatusCode;
import com.chinasoft.dubbo_shiro_ioc.util.ReturnData;
import com.chinasoft.dubbo_shiro_ioc.util.ShiroUtil;
import com.chinasoft.dubbo_shiro_util.service.AdminService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description user角色权限controller
 * @Date 2018-04-09
 * @Time 17:12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    private AdminService adminService;

   /* private final UserMapper userMapper;
    private final ResultMap resultMap;

    @Autowired
    public UserController(UserMapper userMapper, ResultMap resultMap) {
        this.userMapper = userMapper;
        this.resultMap = resultMap;
    }*/

    /**
     * 拥有 user, admin 角色的用户可以访问下面的页面
     */
    @GetMapping("/getMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public Object getMessage() {
        return new ReturnData(StatusCode.REQUEST_SUCCESS,"成功获得信息！");
    }

    @PostMapping("/updatePassword")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public Object updatePassword(String username, String oldPassword, String newPassword) {
       /* String dataBasePassword = userService.getPassword(username);*/
        String dataBasePassword = adminService.getPassWord(username);
        if (dataBasePassword
                .equals(oldPassword)) {
           /* String salt = new SecureRandomNumberGenerator().nextBytes().toHex();*/
            adminService.updatePassword(username, newPassword);
        } else {
            throw  new MyException(StatusCode.RETURN_ERROR,"密码错误！");
        }
        return new ReturnData(StatusCode.REQUEST_SUCCESS,"成功获得信息！");
    }

    /**
     * 拥有 vip 权限可以访问该页面
     */
    @GetMapping("/getVipMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    @RequiresPermissions("vip")
    public Object getVipMessage() {
        return new ReturnData(StatusCode.REQUEST_SUCCESS,"成功获得 vip 信息！");
    }
}
