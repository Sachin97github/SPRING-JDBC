package com.nit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({serviceConfig.class,persistenceConfig.class})
public class AppConfig {


}
