package br.com.lists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

/**
 * Created by eric-nasc on 07/04/17.
 */
@SpringBootApplication
@ContextConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = ASSIGNABLE_TYPE, value = {ListServiceApplication.class})})
public class ListServiceApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(ListServiceApplication.class, args);
    }

}
