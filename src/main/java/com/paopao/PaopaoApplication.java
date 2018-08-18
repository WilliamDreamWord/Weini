package com.paopao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.paopao.dao")
@EnableSwagger2
public class PaopaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaopaoApplication.class, args);
    }

}
