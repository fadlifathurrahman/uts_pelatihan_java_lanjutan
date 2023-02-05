package com.example.demo.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        Server localServer = new Server();
        localServer.url("http://localhost:8081");
        localServer.setDescription("local");

        List<Server> servers = new ArrayList<>();
        servers.add(localServer);

        return new OpenAPI()
                .servers(servers)
                .info(new Info().title("PUB Course API - Middle Exam")
                        .description("")
                        .version("v0.0.1")
                        .license(new License().name("Java TM").url("")));
    }
}
