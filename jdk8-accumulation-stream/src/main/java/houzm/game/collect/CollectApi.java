package houzm.game.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: hzm_dream@163.com
 * Date:  2018/11/23 16:25
 * Modified By:
 * Description：
 */
public class CollectApi {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("houzm", 12));
        list.add(new User("zhang", 12));
        list.add(new User("sdsdfsf", 12));
        list.add(new User("asdf", 12));

        String collect = list.parallelStream().map(User::getName).collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
