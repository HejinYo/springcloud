package cn.hejinyo.eurekaprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date :  2018/4/17 22:57
 */
@RestController
@Slf4j
public class HelloController {

    @GetMapping(value = "/hello")
    public String index() {
        log.info("Hello World");
        return "Hello World";
    }
}
