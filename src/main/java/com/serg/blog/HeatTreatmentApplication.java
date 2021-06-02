package com.serg.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.serg.blog.controller"})
public class HeatTreatmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeatTreatmentApplication.class, args);
    }

}
