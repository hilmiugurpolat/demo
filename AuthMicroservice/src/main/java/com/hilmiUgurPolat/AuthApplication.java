package com.hilmiUgurPolat;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthApplication {
    public static void main(String[] args){
        SpringApplication.run(AuthApplication.class);
    }
}
