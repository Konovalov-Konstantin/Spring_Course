package org.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("org.example")
public class MyConfig {

    @Bean // Бин для совершения HTTP запросов из Rest-клиента
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
