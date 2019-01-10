package org.shop.configuration;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.shop")
@EnableAspectJAutoProxy
public class AppConfig {}
