package com.chinasoft.dubbo_shiro_ioc.controller;


import com.chinasoft.dubbo_shiro_ioc.exception.MyException;
import com.chinasoft.dubbo_shiro_ioc.exception.StatusCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrController implements ErrorController {
    private static int statusCode;
    @RequestMapping("/")
    public String showIndex(HttpServletRequest request) {

        return "index";
    }

    @RequestMapping("/error")
    @ResponseBody
    public String showError(HttpServletRequest request, HttpServletResponse response) {
//System.out.println(response.getStatus()+">>>>>>>>>>");
        statusCode=response.getStatus();
        return getErrorPath();
    }

    @Override
    public String getErrorPath() {
        throw new MyException(StatusCode.RETURN_ERROR,statusCode,"抱歉，请求路径无法访问！");
    }
}
