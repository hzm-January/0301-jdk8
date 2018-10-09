package houzm.game.hello.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Package: houzm.game.hello.collection
 * Author: houzm
 * Date: Created in 2018/6/27 12:25
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
public class ListCapacityDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(4);
        list.add(1);
        list.add(12);
        list.add(1234);
        list.add(12234);
        list.add(12342342);
        list.add(12234);
        list.add(23412);
        list.add(12342);
        list.add(23412);
        list.add(23412);
        list.add(17682);
        list.add(67812342);
        list.add(16782);
        list.add(1672);
        list.add(678812);

        List<Integer> collect = list.parallelStream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(collect);
        list  = list.parallelStream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(list);
    }
}
