package com.chinasoft.dubbo_shiro_util.util;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaopeng
 * Date: 2018/9/17 0017
 * Time: 18:26
 * Description:
 */
public class Result {
    private Boolean success;
    private String msg;
    private String key;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Result(Boolean b, String s){
        this.success = b;
        this.msg = s;
    }

    public Result(Boolean b, String s, String k){
        this.success = b;
        this.msg = s;
        this.key = k;
    }
}
