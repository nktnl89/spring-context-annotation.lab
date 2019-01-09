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
        applicationContext.getBean("proposalInitializer").getClass();
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
//        Map<Long,String> map = (Map<Long, String>) applicationContext.getBean("sellerNames");
//        System.out.println(map.get(0L));
//
//        System.out.println("чагыр");
        // @PostConstruct @PreDestroy - аннотации вместо инит и дестрой методов в xml
        // pointcut - 11 video
        //applicationContext.getBean()
    }
}
