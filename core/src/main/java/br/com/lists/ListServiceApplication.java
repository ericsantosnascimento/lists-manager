package br.com.lists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by eric-nasc on 05/04/17.
 */
@SpringBootApplication
@EnableJpaRepositories
public class ListServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListServiceApplication.class);
    }
}
