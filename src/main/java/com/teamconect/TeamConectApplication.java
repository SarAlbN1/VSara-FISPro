package com.teamconect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TeamConectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamConectApplication.class, args);
    }
}
