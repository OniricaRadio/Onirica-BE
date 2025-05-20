package com.onirica.onirica;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class OniricaApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(OniricaApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/audio/**")
            .addResourceLocations("classpath:/static/audio/");
    }
}

@Configuration
class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        Dotenv dotenv = Dotenv.configure()
                              .directory("./onirica")  // adjust to your .env location
                              .load();

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dotenv.get("DB_URL"));
        dataSource.setUsername(dotenv.get("DB_USERNAME"));
        dataSource.setPassword(dotenv.get("DB_PASSWORD"));
        return dataSource;
    }
}

