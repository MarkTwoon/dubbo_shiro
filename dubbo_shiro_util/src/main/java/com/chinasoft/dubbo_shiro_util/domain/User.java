package com.chinasoft.dubbo_shiro_util.domain;



import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
/*@Data 声明是一个实体类  数据容器
 * 封装的存储方法   会自动通过插件完成配置*/
@Slf4j(topic = "用户类")
@Data
public class User implements Serializable {
    private  int id;
    private  String name;
    private int age;
    private  String sex;

    public static void main(String[] args) {
        User user=new User();
        user.setName("张顺飞");
        user.setAge(26);
        log.info(user.getName());
        log.info(user.toString());
    }

}
