package houzm.game.hello.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Package: houzm.game.hello.collection
 * Author: houzm
 * Date: Created in 2018/6/28 14:51
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(12,12);
        map1.put(2,12);
        map1.put(10,12);
        Map<Integer, Integer> map2 = new HashMap<>();
        map1.put(12,12);
        map1.put(2,12);
        map1.put(10,12);
//        map1.put(11,12);
        System.out.println(map1.containsKey(map2.keySet()));
    }
}
