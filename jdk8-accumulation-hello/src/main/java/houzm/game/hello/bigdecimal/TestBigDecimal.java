package houzm.game.hello.bigdecimal;

import houzm.game.hello.User;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Package: houzm.game.hello.bigdecimal
 * Author: houzm
 * Date: Created in 2018/7/3 13:56
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        BigDecimal bigDecimal = BigDecimal.valueOf(new Integer(12));
        System.out.println(bigDecimal);

        List<User> users = new ArrayList<>();
        users.add(new User("a","12"));
        users.add(new User("a",null));
        users.add(new User("b","15"));
        users.add(new User("c","13"));

        ConcurrentMap<String, List<String>> collect = users.parallelStream()
                .collect(Collectors.groupingByConcurrent(User::getName, Collectors.mapping(User::getAge, Collectors.toList())));
        System.out.println(collect);


        System.out.println("===================测试bigdecimal乘法（乘百分比）===================");

        BigDecimal price = new BigDecimal(5542);
        System.out.println(13/23); //0
        System.out.println(new Double(13/23)); //0.0
        System.out.println(13D/23D); //0.5652173913043478
        System.out.println(1-13D/23D); //0.5652173913043478
        System.out.println(new Double(13D/23D));

        BigDecimal percent = BigDecimal.valueOf(13D/23D);
        System.out.println("折扣率保留小数前："+percent);
        percent = percent.setScale(2, RoundingMode.HALF_UP);
        System.out.println("折扣率百分比："+percent.toString());
        BigDecimal finalPricePre = price.multiply(percent);
        System.out.println("价格取整前："+finalPricePre);
        BigDecimal finalPrice = finalPricePre.setScale(0, RoundingMode.HALF_UP);
        System.out.println("价格取整后："+finalPrice);


    }
}
