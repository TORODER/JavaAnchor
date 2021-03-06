package org.miact.utils;

//返回状态码
//再在枚举中定义，状态码
//#1000～1999 区间表示参数错误
//#2000～2999 区间表示用户错误
//#3000～3999 区间表示接口异常
//状态码和信息就会一一对应，比较好维护。
public enum ResultCode {

    //成功状态码
    SUCCESS(1,"成功"),
    //参数错误：1001-2000
    PARAM_IS_INVALID(1001,"参数无效"),
    PARAM_IS_BLANK(1002,"参数为空"),
    PARAM_TYPE_BIND_ERROR(1003,"参数类型错误"),
    PARAM_NOT_COMPLETE(1004,"参数缺失"),
    //用户错误：2001-3000
    USER_NOT_LOGGED_IN(2001,"用户未登录，访问的路径需要验证，请登录"),
    USER_LOGIN_ERROR(2002,"账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003,"账号已被禁用"),
    USER_NOT_EXIST(2004,"用户不存在"),
    USER_HAS_EXISTEN(2005,"用户已存在"),
    //接口错误：3001-4000
    RES_PATH_NOT_FIND(3001,"响应路径未命中"),
    RES_PATH_IS_NO_FILE(3002,"路径目标不是文件"),
    //文件错误：4001-5000
    FILE_IS_EXISTS(4001,"文件不存在"),
    FILE_NOT_DROP(4002,"文件无法删除"),
    //密钥错误
    KEY_IS_ERROR(5001,"密钥错误");

    private Integer code;
    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    public Integer getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }

}
