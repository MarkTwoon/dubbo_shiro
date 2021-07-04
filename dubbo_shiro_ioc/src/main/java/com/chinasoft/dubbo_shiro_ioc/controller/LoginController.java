package com.chinasoft.dubbo_shiro_ioc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chinasoft.dubbo_shiro_ioc.exception.MyException;
import com.chinasoft.dubbo_shiro_ioc.exception.StatusCode;

import com.chinasoft.dubbo_shiro_ioc.util.RedisUtil;
import com.chinasoft.dubbo_shiro_ioc.util.ShiroUtil;


import com.chinasoft.dubbo_shiro_ioc.util.ReturnData;
import com.chinasoft.dubbo_shiro_ioc.util.TokenUtil;
import com.chinasoft.dubbo_shiro_util.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-04-29
 * @Time 13:20
 */
@RestController
public class LoginController {
   /* private final UserMapper userMapper;
    private final ResultMap resultMap;

    @Autowired
    public LoginController(UserMapper userMapper, ResultMap resultMap) {
        this.userMapper = userMapper;
        this.resultMap = resultMap;
    }*/
   @Reference
   private AdminService adminService;


    @PostMapping("/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response) {
        /*String realPassword = userService.getPassWordAndSalt(username);*/
        String realPassword=adminService.getPassWord(username);
        if (realPassword == null) {
            throw new MyException(StatusCode.USER_NOT_FOUND,"用户名错误");
        } else if (!realPassword
                .equals(password)){
            throw new MyException(StatusCode.RETURN_ERROR,"密码错误");
        } else {
            Long currentTimeMillis = System.currentTimeMillis();
            String token= TokenUtil.sign(username,currentTimeMillis );
            RedisUtil.set(username,currentTimeMillis,TokenUtil.REFRESH_EXPIRE_TIME);
            response.setHeader("Authorization", token);
            response.setHeader("Access-Control-Expose-Headers", "Authorization");
            return new ReturnData(StatusCode.REQUEST_SUCCESS,token,"登录成功！");
        }
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public Object unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        throw new MyException(StatusCode.NEED_LOGIN,message);
    }
}
