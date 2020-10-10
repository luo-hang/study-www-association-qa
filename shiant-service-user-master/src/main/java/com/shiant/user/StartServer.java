package com.shiant.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = {"classpath:WEB-INF/spring-context.xml"})
@SpringBootApplication(scanBasePackages = "com.shiant.user")  
public class StartServer {

    public static void main(String[] args) {
    	SpringApplication.run(StartServer.class, args);
    }
    

}
