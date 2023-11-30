package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Date;

@Configuration
// resources 폴더 하위 경로를 기술한다. 폴더의 구분의 / 혹은 \\ 로 한다.
@PropertySource("section03/properties/subsection01/properties/product_info.properties")
public class ContextConfiguration {
    /*
    * 지환자(placeholder) 문법을 이용하여 properties에 저장된 key를 입력하면 value에 해당하는 값을 꺼내온다.
    * 공백을 사용하면 값을 읽어오지 못하니 주의한다.
    * :을 사용하면 값을 읽어오지 못하는 경우 사용할 대체값을 작성할 수 있다.
    * */

    @Value("${bread.carpbread.name:}")
    private String carpBreadName;

    @Value("${bread.carpbread.price:0}")
    private int carpBreadPrice;

    @Value("${beverage.milk.name:}")
    private String milkName;

    @Value("${beverage.milk.price:0}")
    private int milkPrice;

    @Value("${beverage.milk.capacity:0}")
    private int milkCapacity;

    @Bean
    public Product carpBread(){
        return new Bread(carpBreadName, carpBreadPrice, new Date());
    }

    @Bean
    public Product milk(){
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    public Product water(@Value("${bevarage.water.name}") String waterName,
                         @Value("${bevarage.water.price}") int waterPrice,
                         @Value("${bevarage.water.capaciry}") int waterCapacity
                            ){
        return new Beverage(waterName, waterPrice, waterCapacity);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){
        return new ShoppingCart();
    }
}
