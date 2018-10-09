package houzm.game.hello.collection;

import sun.nio.ch.ThreadPool;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Package: houzm.game.hello.collection
 * Author: houzm
 * Date: Created in 2018/7/17 16:05
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestSetAddNull {
    public static void main(String[] args) {
        Set<String> names = new TreeSet<>();
        names.add(null); //Exception in thread "main" java.lang.NullPointerException
        System.out.println(names);
//        ThreadPoolExecutor
    }
}
