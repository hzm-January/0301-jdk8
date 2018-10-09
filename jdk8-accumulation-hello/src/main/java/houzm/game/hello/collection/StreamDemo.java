package houzm.game.hello.collection;

import houzm.game.hello.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Package: houzm.game.hello.collection
 * Author: houzm
 * Date: Created in 2018/6/27 13:09
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class StreamDemo {

    public static void main(String[] args) {
//        testListMax();
//        testListGroupBy();
//        nullListGroupBy();
//        nullListOptionalGroupBy();
//        nullListOptionalGroupBy2();
        try {
            Integer.valueOf("asdfadsf");
        } catch (NumberFormatException e) {
//            e1.printStackTrace();
            System.out.println(e);
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getSuppressed());
        }

    }

    private static void nullListOptionalGroupBy2() {
        List<User> users = null;
        ConcurrentMap<String, List<User>> userGroupByName = Optional.ofNullable(users).orElseGet(ArrayList::new).stream().collect(Collectors.groupingByConcurrent(User::getName));
        System.out.println(userGroupByName);//{}
        List<User> usersAfterFilter = new ArrayList<>();
        Optional.ofNullable(userGroupByName).ifPresent((key)->{
            List<User> key2 = key.get("1212");
            Optional.ofNullable(key2).ifPresent((key3)->{
                usersAfterFilter.addAll(key3);
                }
            );
        });
    }
    private static void nullListOptionalGroupBy() {
        List<User> users = null;
        ConcurrentMap<String, List<User>> userGroupByName = Optional.ofNullable(users).orElseGet(ArrayList::new).stream().collect(Collectors.groupingByConcurrent(User::getName));
        System.out.println(userGroupByName);//{}
    }

    private static void nullListGroupBy() {
        List<User> users = null;
        //Exception in thread "main" java.lang.NullPointerException
        ConcurrentMap<String, List<User>> userGroupByName = users.stream().collect(Collectors.groupingByConcurrent(User::getName));
        System.out.println(userGroupByName);
    }

    private static void testListGroupBy() {
        List<User> users = Arrays.asList(
                new User("houz", "12"),
                new User("qwe", "1123"),
                new User("dsd", "676"),
                new User("sdfd", "23"),
                new User("dzxcvsd", "34"),
                new User("dszxcvzd", "45"),
                new User("dsd", "7967"),
                new User("dszxcvd", "3432"),
                new User("dsd", "2343")
        );
        ConcurrentMap<String, List<User>> userGroupByName = users.stream().collect(Collectors.groupingByConcurrent(User::getName));
        System.out.println(userGroupByName);
//        Optional.ofNullable(users).orElseGet()
    }

    private static void testListMax() {
        //        List<Integer> intList = null;
//        List<Integer> intList = new ArrayList<>();
        List<Integer> intList = Arrays.asList(1, 12, 1234);
        intList.add(123123); //java.lang.UnsupportedOperationException
//        intList.add(12);
//        intList.add(121);
//        intList.add(1223);
//        intList.add(1212);
        List<Integer> collect = intList.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
        Optional<Integer> reduce = intList.stream().reduce(Integer::max);
    }
}
