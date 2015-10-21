package br.com.gsw.example.spring.profiles.web.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Web Application Using Spring Boot
 * To run application, run method main or mvn sprint-boot:run
 */
@ComponentScan("br.com.gsw.example.spring.profiles")
@EntityScan("br.com.gsw.example.spring.profiles")
@EnableJpaRepositories("br.com.gsw.example.spring.profiles")
@EnableTransactionManagement
@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {
    public static void main(final String[] args) {
        SpringApplication.run(WebApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }
}