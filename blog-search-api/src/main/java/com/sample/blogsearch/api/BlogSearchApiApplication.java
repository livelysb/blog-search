package com.sample.blogsearch.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sample.blogsearch"})
public class BlogSearchApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogSearchApiApplication.class, args);
    }
}
