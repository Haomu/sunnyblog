package pers.sunny.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pers.sunny.blog.mapper")
public class SunnyblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SunnyblogApplication.class, args);
    }

}
