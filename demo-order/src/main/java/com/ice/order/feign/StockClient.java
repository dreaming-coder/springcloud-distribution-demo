package com.ice.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


// name：服务名；path：对应Controller的RequestMapping地址
@FeignClient(name = "stock-service", path = "/stock")
public interface StockClient {

    // 声明需要调用的rest接口对应的方法
    // 可服务提供者方法声明一致
    @GetMapping("/reduce")
    String reduce() ;

}
