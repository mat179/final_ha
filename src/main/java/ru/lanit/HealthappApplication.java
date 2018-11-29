package ru.lanit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ru.lanit")
//@EntityScan("ru.lanit")
@EnableJpaRepositories("ru.lanit.repositories")
public class HealthappApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthappApplication.class, args);
    }
}
