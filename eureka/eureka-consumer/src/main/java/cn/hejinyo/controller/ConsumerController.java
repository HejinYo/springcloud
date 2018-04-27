package cn.hejinyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date :  2018/4/18 23:30
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://PROVIDER-SERVICE/hello", String.class).getBody();
    }

    @GetMapping("/instance-info")
    public String instanceInfo() {
        return restTemplate.getForEntity("http://PROVIDER-SERVICE/instance-info", String.class).getBody();
    }
}
