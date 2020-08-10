package com.tcl.acme.spring.boot.autoconfigure;

/**
 * @author li
 * @version 1.0
 * @date 2020/8/10 14:32
 */
public class Acme {
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
