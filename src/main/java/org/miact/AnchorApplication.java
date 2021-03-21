package org.miact;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author miact
 */
@MapperScan("com.miact.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AnchorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnchorApplication.class,args);
    }
}
