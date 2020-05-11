package com.chiraranw.gitviewcommandservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class GitViewCommandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitViewCommandServiceApplication.class, args);
    }


    //Use the client below to make calls to the GitHub API
    @Bean
    WebClient.Builder getClient(){
        return WebClient.builder();
    }

}
