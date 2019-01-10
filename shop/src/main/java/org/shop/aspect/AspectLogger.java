package org.shop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.shop.data.Product;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class AspectLogger {
    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(org.shop.ShopLauncher.class);

    @Pointcut("execution(* *.initSellers())")
    public void initSellers() {
    }

    @Pointcut("execution(* *.getProducts())")
    public void aroundGetItemsByOrderId() {
    }

    @Around("aroundGetItemsByOrderId()")
    public Object aroundGetItemsByOrderId(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            List<Product> array = (ArrayList<Product>) proceedingJoinPoint.proceed();
            array.forEach(product -> LOGGER.info(product.toString()));
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @After("initSellers()")
    public void logAfter(JoinPoint joinPoint) {
        LOGGER.info(joinPoint.getThis().toString());
    }
}
