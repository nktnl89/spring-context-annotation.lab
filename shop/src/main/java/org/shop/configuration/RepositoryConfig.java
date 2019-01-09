package org.shop.configuration;

import org.shop.repository.*;
import org.shop.repository.map.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:application.properties")
public class RepositoryConfig {
    @Autowired
    private Environment environment;

    @Bean
    public OrderRepository orderRepository() {
        OrderMapRepository orderRepository = new OrderMapRepository();
        orderRepository.setSequence(Long.parseLong(this.environment.getProperty("intitialSequence")));
        return orderRepository;
    }

    @Bean
    public ItemRepository itemRepository() {
        return new ItemMapRepository();
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository() {
        return new ProposalMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository() {
        return new SellerMapRepository();
    }

}
