package houzm.game.hello.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Package: com.houzm.one.chooseapple
 * Author: houzm
 * Date: Created in 2018/4/22 17:12
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestChoose {
    public static void main(String[] args) {
//        functionDemo();
//        streamDemo();

    }

    /**
     * 函数式编程--核心思想二：在没有可变共享状态时，函数和方法可以有效安全的并行执行
     * 流
     * 使用流的方式，串行或者并行的处理
     */
    private static void streamDemo() {
        List<Apple> inventory = initAppleInventory();
        //串行--顺序处理
        List<Apple> result = inventory.stream().filter((Apple a) -> a.getWeight() > 29).collect(Collectors.toList());
        System.out.println(Arrays.toString(result.toArray()));
        //并行--并行处理
        List<Apple> result2 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 25).collect(Collectors.toList());
        System.out.println(Arrays.toString(result2.toArray()));
    }


    /**
     * 函数式编程--核心思想一：将方法和lambda作为一等值
     * 传入选择条件的代码
     */
    private static void functionDemo() {
        List<Apple> inventory = initAppleInventory();
        //函数式编程--传入选择条件的代码
        List<Apple> result = ChooseAppleUtil.filterApple(inventory, (Apple a) -> a.getWeight() > 26 && "bule".equalsIgnoreCase(a.getColor()));
        System.out.println(Arrays.deepToString(result.toArray()));
        List<Apple> result2 = ChooseAppleUtil.filterApple(inventory, (Apple a) -> "red".equalsIgnoreCase(a.getColor()));
        System.out.println(Arrays.deepToString(result2.toArray()));
    }

    private static List<Apple> initAppleInventory() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("red", 25.5));
        inventory.add(new Apple("red", 30.0));
        inventory.add(new Apple("red", 26.5));
        inventory.add(new Apple("grey", 25.5));
        inventory.add(new Apple("bule", 30.0));
        inventory.add(new Apple("yellow", 26.5));
        return inventory;
    }
}
