package org.miact.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Data
@PropertySource(value = "classpath:application.yml")
@ConfigurationProperties(prefix = "api")
@Component
public class Keypair {
    private String secretkey;
}