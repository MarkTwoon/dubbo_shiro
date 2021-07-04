package com.chinasoft.dubbo_shiro_ioc.controller;

import com.chinasoft.dubbo_shiro_ioc.exception.StatusCode;





import com.chinasoft.dubbo_shiro_ioc.util.ReturnData;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 游客角色可以访问的页面
 * @Date 2018-04-30
 * @Time 14:24
 */
@RestController
@RequestMapping("/guest")
public class GuestController {
   /* private final ResultMap resultMap;

    @Autowired
    public GuestController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }*/


    @GetMapping("/welcome")
    public Object login() {
        return new ReturnData(StatusCode.REQUEST_SUCCESS,"欢迎访问游客页面！");
    }
}
