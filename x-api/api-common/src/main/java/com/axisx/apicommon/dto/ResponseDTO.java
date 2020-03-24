package com.axisx.apicommon.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Axisx
 */
@AllArgsConstructor
public class ResponseDTO<T> {
    private static final int CODE_SUCCESS = 200;
    private static final int CODE_ERROR = 500;

    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String msg;
    @Getter
    @Setter
    private T data;

    public static <T> ResponseDTO<T> success(){
        return new ResponseDTO<T>(CODE_SUCCESS,"success",null);
    }
    public static <T> ResponseDTO<T> success(String msg){
        return new ResponseDTO<T>(CODE_SUCCESS,msg,null);
    }
    public static <T> ResponseDTO<T> success(T data){
        return new ResponseDTO<T>(CODE_SUCCESS,"success",data);
    }
    public static <T> ResponseDTO<T> success(String msg,T data){
        return new ResponseDTO<T>(CODE_SUCCESS,msg,data);
    }

    public static <T> ResponseDTO<T> error(){
        return new ResponseDTO<T>(CODE_ERROR,"error",null);
    }
    public static <T> ResponseDTO<T> error(String msg){
        return new ResponseDTO<T>(CODE_ERROR,msg,null);
    }
    public static <T> ResponseDTO<T> error(T data){
        return new ResponseDTO<T>(CODE_ERROR,"error",data);
    }
    public static <T> ResponseDTO<T> error(String msg,T data){
        return new ResponseDTO<T>(CODE_ERROR,msg,data);
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
