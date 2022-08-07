package com.ice.order.controller;

import com.ice.order.feign.ProductClient;
import com.ice.order.feign.StockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private StockClient stockClient;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/add")
    public String add() {
        System.out.println("下单成功");
//        String msg = restTemplate.getForObject("http://stock-service/stock/reduce", String.class);
        String msg = stockClient.reduce();
        return "Hello Feign! " + msg;
    }

    @GetMapping("/query/{id}")
    public String get(@PathVariable("id") Integer id){
        System.out.println("开始查询商品");
        String msg = productClient.get(id);
        return "Order 调用 Product " + msg;
    }
}
