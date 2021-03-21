package org.miact.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


//返回数据体，JSON格式，根据不同的业务又不同的JSON体。
//我们要设计一个返回体类Result
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"resultCode"})
public class Result implements Serializable {
    private ResultCode resultCode;
    private int code;
    private String message;
    private Object data;

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    //我们可以在Result类中，加入静态方法，一看就懂

    //返回成功
    public static Result success(){
        return new Result(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
    }
    //返回成功
    public static Result success(Object data){
        return new Result(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }
    //返回失败
    public static Result failure(ResultCode resultCode){
        return new Result(resultCode.getCode(),resultCode.getMessage());
    }
    //返回失败
    public static Result failure(ResultCode resultCode, Object data){
        return new Result(resultCode.getCode(),resultCode.getMessage(),data);
    }
    //返回失败
    public static Result failure(Integer code, String message, Object errors) {
        return new Result(code,message,errors);
    }
}
