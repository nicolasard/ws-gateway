package ar.servus.apiproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApp{

    private final Logger logger = LoggerFactory.getLogger(GatewayApp.class);

    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }

}