package org.shop.configuration;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.common.Sellers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataInitializerConfig {
    @Bean
    public ProductInitializer productInitializer(ProductService productService) {
        return new ProductInitializer(productService);
    }

    @Bean
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean
    public SellerInitializer sellerInitializer() {
        return new SellerInitializer();
    }

    @Bean
    public UserInitializer userInitializer(UserService userService) {
        return new UserInitializer(userService);
    }

    @Bean(name = "sellerNamesMap")
    public Map<Long, String> sellerNamesMap() {
        Map<Long, String> map = new HashMap<>();
        map.put(1L, Sellers.AMAZON);
        map.put(2L, Sellers.SAMSUNG);
        return map;
    }

    @Bean(initMethod = "initData")
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }
}
