package com.tcl.acme.spring.boot.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author li
 * @version 1.0
 * @date 2020/8/10 14:29
 */
@Configuration
@EnableConfigurationProperties(value = AcmeProperties.class)
public class AcmeAutoConfiguration {

    final
    AcmeProperties properties;

    public AcmeAutoConfiguration(AcmeProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public Acme acme() {
        Acme acme = new Acme();

        acme.setName(properties.getName());
        acme.setEnable(properties.isEnable());
        return acme;
    }
}
