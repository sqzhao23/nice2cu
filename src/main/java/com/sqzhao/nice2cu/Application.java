package com.sqzhao.nice2cu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @program: nice2cu
 * @description: 启动类
 * @author: sqzhao
 * @create: 2020-04-25 14:07
 **/
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.sqzhao.nice2cu.dao", "com.sqzhao.nice2cu.pojo"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
