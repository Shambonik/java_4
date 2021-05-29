package com.example.practice10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Practice10Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice10Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        for(int i = 0; i<args.length; i++) {
            String name = args[i];
            Programmer programmer = (Programmer) context.getBean(name);
            programmer.doCoding();
        }
    }

}
