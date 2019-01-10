package org.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        //TODO: implement using Spring Framework ApplicationContext
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(org.shop.configuration.AppConfig.class);
        DataInitializer dataInitializer = applicationContext.getBean(org.shop.DataInitializer.class);
        ProposalInitializer proposalInitializer = (ProposalInitializer) applicationContext.getBean("proposalInitializer");
        SellerInitializer sellerInitializer = applicationContext.getBean(org.shop.SellerInitializer.class);
        UserInitializer userInitializer = applicationContext.getBean(org.shop.UserInitializer.class);
        ProductInitializer productInitializer = applicationContext.getBean(org.shop.ProductInitializer.class);
    }
}
