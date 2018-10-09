package houzm.game.hello.collection;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Package: houzm.game.hello.collection
 * Author: houzm
 * Date: Created in 2018/6/27 17:57
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
//        testGetAndIncrement();
        testSet();
    }

    private static void testSet() {
        AtomicInteger integer = new AtomicInteger(0);
        integer.set(12);
        System.out.println(integer);
    }

    private static void testGetAndIncrement() {
        AtomicInteger integer = new AtomicInteger(0);
        integer.addAndGet(12);
        System.out.println(integer);
        int result = integer.addAndGet(15);
        System.out.println(result);
        System.out.println(integer);
        System.out.println(integer.incrementAndGet());
        System.out.println(integer.incrementAndGet());
        System.out.println(integer);
    }
}
