package com.ohgiraffers.section02.initdestroy.subsection03.xml;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args){
        ApplicationContext context = new GenericXmlApplicationContext("section02/initdestroy/subsection03/xml/spring_context.xml");

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItems(carpBread);
        cart1.addItems(milk);

        System.out.println("cart1에 담긴 내용: " + cart1.getItems());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItems(water);

        System.out.println("cart2에 담긴 내용: " + cart2.getItems());

        ((GenericXmlApplicationContext)context).close();
    }
}
