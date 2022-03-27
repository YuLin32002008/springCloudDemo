package com.george.springcloud.controller;

import com.george.springcloud.entities.CommonResult;
import com.george.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@Slf4j
public class OrderController {

    //暂时在这里写死
    public static final String PAYMENT_URL = "http://localhost:8001";

    /**
     * 用restTemplate实现消费者和提供者微服务之间的横向调用
     */
    @Resource
    private RestTemplate template;

    //按理说插入数据应该是POST，可以从浏览器只能发GET请求，尽管不符合RESTFUL，
    // 但是下面的template.postForObject调用却是POST请求
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        //调用生产者模块中的生产方法
        return template.postForObject(PAYMENT_URL+"payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return template.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }

}

