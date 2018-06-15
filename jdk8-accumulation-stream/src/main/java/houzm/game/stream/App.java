package houzm.game.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        //菜单集合
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        //获取热量超过300卡路里的菜肴
        List<String> menuNames =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .map(Dish::getName).limit(3)
                        .collect(Collectors.toList());

        //获取热量超过300卡路里的菜肴--打印中间操作
        List<String> menuNamesLog =
                menu.stream()
                        .filter(d -> {
                            System.out.println("==filter=="+d.getName());
                            return d.getCalories() > 300;
                        })
                        .map(d -> {
                            System.out.println("==map=="+d.getName());
                            return d.getName();
                        })
                        .limit(3)
                        .collect(Collectors.toList());
        System.out.println(menuNames);

    }
}
