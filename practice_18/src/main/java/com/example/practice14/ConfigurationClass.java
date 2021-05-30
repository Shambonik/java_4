package com.example.practice14;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class ConfigurationClass {
    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/pr15");
        config.setUsername("postgres");
        config.setPassword("1234567890");
        config.setDriverClassName("org.postgresql.Driver");
        return new HikariDataSource(config);
    }

//    @Bean
//    public LocalSessionFactoryBean factoryBean(DataSource dataSource) {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setPackagesToScan("com.example.practice14");
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        sessionFactoryBean.setHibernateProperties(properties);
//        return sessionFactoryBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager
//    platformTransactionManager(LocalSessionFactoryBean factoryBean){
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(factoryBean.getObject());
//        return transactionManager;
//    }

}