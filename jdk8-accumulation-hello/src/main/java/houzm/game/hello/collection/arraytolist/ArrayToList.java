package houzm.game.hello.collection.arraytolist;

import java.util.Arrays;
import java.util.List;

/**
 * Package: houzm.game.hello.collection.arraytolist
 * Author: houzm
 * Date: Created in 2018/7/12 19:19
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class ArrayToList {
    public static void main(String[] args) {
        List<Integer> arraylist = Arrays.asList(1,2,3,4,5);
        boolean contains = arraylist.contains(1);
        System.out.println(contains);
//        arraylist.add(9); //Exception in thread "main" java.lang.UnsupportedOperationException
    }
}
