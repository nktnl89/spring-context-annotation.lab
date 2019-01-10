package org.shop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.shop.data.Product;
import org.shop.data.Seller;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AspectLogger {
    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(org.shop.ShopLauncher.class);

    @Pointcut("execution(* *.initSellers(..))")
    public void initSellers() {
    }

    @AfterReturning(pointcut = "execution(* *.getProducts(..))", returning = "productList")
    public void afterGetProducts(Object productList) {
        LOGGER.info("кудык");
        for (Product product : (List<Product>) productList) {
            LOGGER.info(product.toString());
        }
    }

    @After("initSellers()")
    public void logAfter(JoinPoint joinPoint) {
        LOGGER.info(joinPoint.getThis().toString());
    }
}
