package com.delivery.api.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = "com.delivery.api")
@SpringBootApplication
public class DeliveryApiServerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DeliveryApiServerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApiServerApplication.class, args);
    }

}
