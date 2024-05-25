package com.easychat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@ConfigurationProperties(prefix = "app")
@Configuration
public class AppConfigration {
    private String wsPort;
    private String projectFolder;
    private String adminEmails;

}
