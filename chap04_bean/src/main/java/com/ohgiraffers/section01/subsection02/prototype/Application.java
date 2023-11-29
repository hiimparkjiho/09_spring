package com.ohgiraffers.section01.subsection02.prototype;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args){

        // 빈 설정 파일을 기반으로 IoC 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for(String bean: beanNames){
            System.out.println("beanNames: " + bean);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart = context.getBean("cart", ShoppingCart.class);
        cart.addItems(carpBread);
        cart.addItems(milk);
        System.out.println("cart에 담긴 내용: " + cart.getItems());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItems(water);
        System.out.println("cart2에 담긴 내용: " + cart2.getItems());

        System.out.println("cart1의 hashcode: " + cart.hashCode());
        System.out.println("cart2의 hashcode: " + cart2.hashCode());

    }
}
