package com.example.practice14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Practice14Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice14Application.class, args);
    }

}
