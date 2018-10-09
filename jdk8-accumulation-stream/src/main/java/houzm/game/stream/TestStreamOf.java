package houzm.game.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Package: houzm.game.stream
 * Author: houzm
 * Date: Created in 2018/8/20 14:24
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestStreamOf {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("张三", "李四");
        List<List<String>> collect = Stream.of(names).collect(Collectors.toList());
    }
}
