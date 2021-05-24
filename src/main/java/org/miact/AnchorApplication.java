package org.miact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.swing.*;

/**
 * @author miact
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AnchorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnchorApplication.class,args);
    }
}
