package com.ruangong.douban;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ruangong.douban")
@SpringBootApplication
public class DoubanApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoubanApplication.class, args);
    }

}
