package com.chinasoft.dubbo_shiro_ioc.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroUtil {
    public static String getPassWordSalt(String password,String salt){
        String hashAlgorithmName = "MD5"; //加密方式
        int hashIterations = 2; //加密的次数
        //盐
        // String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        //加密
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);
        //加密密码
        return simpleHash.toString();
    }
}
