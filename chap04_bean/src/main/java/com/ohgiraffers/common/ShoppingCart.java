package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> items;

   public ShoppingCart(){
       items = new ArrayList<>();
   }

   public void addItems(Product item){
       items.add(item);
   }

   public List<Product> getItems(){
       return items;
   }
}
