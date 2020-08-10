package com.tcl.acme.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author li
 * @version 1.0
 * @date 2020/8/10 14:29
 */
@ConfigurationProperties(prefix = "acme")
public class AcmeProperties {

    private String name;
    private boolean enable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
