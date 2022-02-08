package com.example.spring_course_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // заменяет аннотации - @Configuration @EnableAutoConfiguration @Componentscan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // создаются бины и запускается Tomcat сервер
    }

}
