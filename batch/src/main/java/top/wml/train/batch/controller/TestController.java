package top.wml.train.batch.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wml.train.batch.feign.BusinessFeign;

@RestController
@Slf4j
public class TestController {
    @Resource
    private BusinessFeign businessFeign;

    @GetMapping("/hello")
    public String hello(){
        String hello = businessFeign.getHello();
        log.info("business hello : {}" ,hello);
        return "hello,batch";
    }
}
