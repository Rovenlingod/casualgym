package com.rovenlin.casualgym;

import com.rovenlin.casualgym.properties.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CasualgymApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasualgymApplication.class, args);
    }

}
