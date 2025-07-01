package com.example.smart_inventory_app.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

@Bean
ModelMapper mp(){
    return new ModelMapper();
}


}
