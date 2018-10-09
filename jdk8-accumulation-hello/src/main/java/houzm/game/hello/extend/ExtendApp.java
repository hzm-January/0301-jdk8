package houzm.game.hello.extend;

import java.util.Arrays;

/**
 * Package: houzm.game.hello.extend
 * Author: houzm
 * Date: Created in 2018/8/24 13:47
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class ExtendApp {
    public static void main(String[] args) {
        Person p = new Employee();
        Person [] persons = new Employee[5];
        persons[0] = new Student();
        persons[1] = new Employee();
        System.out.println(Arrays.toString(persons));

    }
}
