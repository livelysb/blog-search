package com.sample.blogsearch.domain.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.sample.blogsearch")
@EntityScan(basePackages = "com.sample.blogsearch")
public class JpaConfig {
}
