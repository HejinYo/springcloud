package cn.hejinyo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * FeignClient 定义的接口来统一的生命我们需要依赖的微服务接口。 而在具体使用的时候就跟调用本地方法一点的进行调用即可。
 * 由于Feign是基于Ribbon实现的，所以它自带了客户端负载均衡功能，也可以通过Ribbon的IRule进行策略扩展。
 * 另外，Feign还整合的Hystrix来实现服务的容错保护
 *
 * @author : heshuangshuang
 * @date : 2018/4/28 16:53
 */
@FeignClient("provider-service")
public interface ProviderService {

    @GetMapping("/hello")
    String helloConsumer();
}
