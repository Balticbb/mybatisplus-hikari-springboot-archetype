package com.jack;

import com.jack.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.List;

/**
 * @author liujialin
 */
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=true)
@EnableMongoRepositories(basePackages = "com.jack.mongodb.repository")
public class MybatisPlusTestApplication {

	public static void main(String[] args) {

		SpringApplication.run(MybatisPlusTestApplication.class, args);
	}

	public <T extends List<User>,U> T getuserId(T a, U b){
	    a.add(new User());
        return a;
    }
}
