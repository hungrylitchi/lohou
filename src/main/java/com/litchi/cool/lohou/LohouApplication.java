package com.litchi.cool.lohou;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.litchi.cool.lohou.link.mapper")
@Slf4j
public class LohouApplication {

    public static void main(String[] args) {
        SpringApplication.run(LohouApplication.class, args);
        log.info("##############################启动完成##############################");
    }

}
