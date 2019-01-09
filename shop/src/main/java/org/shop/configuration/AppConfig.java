package org.shop.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({org.shop.configuration.FactoryConfig.class,org.shop.configuration.RepositoryConfig.class,
    org.shop.configuration.ServiceConfig.class, org.shop.configuration.DataInitializerConfig.class})
@ComponentScan(basePackages = "org.shop")
public class AppConfig {

}
