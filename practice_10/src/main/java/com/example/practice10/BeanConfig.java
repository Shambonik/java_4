package com.example.practice10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean(name = "jun")
    @Scope("singleton")
    Junior getJunior(){
        return new Junior();
    }

    @Bean(name = "mid")
    @Scope("singleton")
    Middle getMiddle(){
        return new Middle();
    }

    @Bean(name = "sen")
    @Scope("singleton")
    Senior getSenior(){
        return new Senior();
    }
}
