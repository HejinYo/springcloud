package cn.hejinyo.controller;

import cn.hejinyo.service.ProviderService;
import cn.hejinyo.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date :  2018/4/18 23:30
 */
@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/feign-consumer")
    public String helloConsumer() {
        log.info("feign-consumer");
        return providerService.helloConsumer();
    }

}
