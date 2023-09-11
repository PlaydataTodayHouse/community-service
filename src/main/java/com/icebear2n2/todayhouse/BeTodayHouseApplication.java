package com.icebear2n2.todayhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BeTodayHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeTodayHouseApplication.class, args);
    }

}
