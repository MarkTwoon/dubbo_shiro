package com.chinasoft.dubbo_shiro_ioc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chinasoft.dubbo_shiro_ioc.exception.StatusCode;



import com.chinasoft.dubbo_shiro_ioc.util.ReturnData;
import com.chinasoft.dubbo_shiro_util.service.AdminService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description admin角色权限controller
 * @Date 2018-04-29
 * @Time 17:32
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Reference
    private AdminService adminService;

    /*private final UserMapper userMapper;
    private final ResultMap resultMap;

    @Autowired
    public AdminController(UserMapper userMapper, ResultMap resultMap) {
        this.userMapper = userMapper;
        this.resultMap = resultMap;
    }*/

    @GetMapping("/getUser")
    @RequiresRoles("admin")
    public Object getUser() {
        List<String> list = adminService.getUser();
        return new ReturnData(StatusCode.REQUEST_SUCCESS,list,"用户查询列表正常！");
    }

    /**
     * 封号操作
     */
    @PostMapping("/banUser")
    @RequiresRoles("admin")
    public Object updatePassword(String username) {
        adminService.banUser(username);
        return new ReturnData(StatusCode.REQUEST_SUCCESS,"成功封号！");
    }
}
