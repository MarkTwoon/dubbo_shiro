package com.chinasoft.dubbo_shiro_orm;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class  OrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
        System.out.println("数据生产端启动成功！");
    }

}
