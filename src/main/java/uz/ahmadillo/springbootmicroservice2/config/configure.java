package uz.ahmadillo.springbootmicroservice2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class configure {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
