package server.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static server.demo.domain.User.admin;
import static server.demo.domain.User.userMap;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        userMap.put("admin",admin);
        SpringApplication.run(ServerApplication.class, args);
    }

}
