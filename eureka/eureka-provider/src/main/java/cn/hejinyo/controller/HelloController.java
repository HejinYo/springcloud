package cn.hejinyo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date :  2018/4/17 22:57
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/hello")
    public String hello() {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        log.info("/instance,host:{},service_id:{}", serviceInstance.getHost(), serviceInstance.getServiceId());
        return "Hello World";
    }

    @GetMapping(value = "/instance-info")
    public ServiceInstance showInfo() {
        return discoveryClient.getLocalServiceInstance();
    }

    /**
     * 文件上传服务
     */
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        log.info("服务器接收到上传文件:{}", file.getOriginalFilename());
        return "服务器接收到上传文件:" + file.getOriginalFilename();
    }
}
