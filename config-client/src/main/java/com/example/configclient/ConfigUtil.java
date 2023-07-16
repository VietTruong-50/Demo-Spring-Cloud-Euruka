package com.example.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigUtil {

    @Autowired
    private Environment env;

    public String getOwnerName() {
        return env.getProperty("welcome.message");
    }

}