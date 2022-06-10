package com.booking.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Response<T>{
    private boolean success;
    private String message;
    private T data;
    public static <T> Response success(String message, T data){
        return new Response(true,message,data);
    }
    public static <T> Response fail(String message){
        return new Response(false,message,null);
    }
}
