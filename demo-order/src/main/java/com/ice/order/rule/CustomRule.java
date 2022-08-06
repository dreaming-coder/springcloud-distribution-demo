package com.ice.order.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CustomRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        // 获得当前请求服务的实例
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        List<Server> reachableServers = loadBalancer.getReachableServers();
        // 生成随机数
        int random = ThreadLocalRandom.current().nextInt(reachableServers.size());
        // 获取指定的server
        Server server = reachableServers.get(random);

        return server;
    }
}
