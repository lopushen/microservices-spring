package com.lopushen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by i.lopushen on 12/07/2016.
 */

@EnableConfigServer
@SpringBootApplication
public class SpringConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(SpringConfigServer.class, args);
    }
}
