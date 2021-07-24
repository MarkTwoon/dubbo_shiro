package com.chinasoft.dubbo_shiro_orm.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface AdminMapper {
    /**
     * 获得密码
     * @param username 用户名
     */
    String getPassWord(String username);

    /**
     * 获得角色权限
     * @param username 用户名
     * @return user/admin
     */
    String getRole(String username);

    boolean insertUser(Map<String,Object> map);

    /**
     * 修改密码
     */
    void updatePassword(@Param("username")String username
            ,@Param("password")String newPassword);

    /**
     * 获得存在的用户
     */
    List<String> getUser();

    /**
     * 封号
     */
    void banUser(String username);

    /**
     * 检查用户状态
     */
    int checkUserBanStatus(String username);

    /**
     * 获得用户角色默认的权限
     */
    String getRolePermission(String username);

    /**
     * 获得用户的权限
     */
    String getPermission(String username);
}
