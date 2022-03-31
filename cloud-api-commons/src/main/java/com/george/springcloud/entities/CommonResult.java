package com.george.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    //404 not_found     ：    Integer String
    private Integer code;
    private String message;

    //这不是针对某一个实体类的Josn串封装类
    private T data;

    //当T是null时，定义一个两个参数的构造
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }

}

