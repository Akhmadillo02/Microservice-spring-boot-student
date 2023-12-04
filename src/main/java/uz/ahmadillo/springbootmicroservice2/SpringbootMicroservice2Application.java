package uz.ahmadillo.springbootmicroservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootMicroservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMicroservice2Application.class, args);
    }

}
