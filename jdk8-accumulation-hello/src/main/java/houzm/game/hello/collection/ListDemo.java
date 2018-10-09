package houzm.game.hello.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Package: houzm.game.hello.collection
 * Author: houzm
 * Date: Created in 2018/6/28 19:47
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class ListDemo {
    public static void main(String[] args) {
//        testUnitList();
        List<Integer> arrayLista = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(arrayLista.contains(1));
        System.out.println(arrayLista.contains(4));

        IntStream intStream = arrayLista.parallelStream().mapToInt(e -> e);
        intStream.findAny();
    }

    private static void testUnitList() {
        //测试 两个list 并集去重removeAll addAll
        List<Integer> arrayLista = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> arrayListb = new ArrayList<>(Arrays.asList(11,2,3));
        System.out.println(arrayLista);
        arrayLista.removeAll(arrayListb);
        System.out.println(arrayLista);
        arrayLista.addAll(arrayListb);
        System.out.println(arrayLista);

        List<Integer> arrayListaa = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> arrayListbb = new ArrayList<>(Arrays.asList(11,12,4));
        System.out.println(arrayListaa);
        arrayListaa.removeAll(arrayListbb);
        System.out.println(arrayListaa);
        arrayListaa.addAll(arrayListbb);
        System.out.println(arrayListaa);
    }
}
