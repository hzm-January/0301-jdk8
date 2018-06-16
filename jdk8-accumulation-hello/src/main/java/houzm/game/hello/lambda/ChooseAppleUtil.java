package houzm.game.hello.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Package: com.houzm.one.chooseapple
 * Author: houzm
 * Date: Created in 2018/4/22 16:22
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 选择苹果工具类
 */
public class ChooseAppleUtil {

    public static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
