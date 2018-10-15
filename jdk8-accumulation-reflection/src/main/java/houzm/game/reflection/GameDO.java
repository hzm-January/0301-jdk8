package houzm.game.reflection;

/**
 * Package: houzm.game.reflection
 * Author: houzm
 * Date: Created in 2018/8/14 17:37
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class GameDO extends GameParentDO{

    private String name;
    private Double price;
    public String describe;
    protected Integer level;
    String company;

    public void show(String name, Double price) {
        System.out.println("============public=============");
        System.out.println("game name: "+name);
        System.out.println("game price: "+price);
        System.out.println("============public=============");
    }

    public void show(String name, Double price, String describe) {
        System.out.println("============public=============");
        System.out.println("game name: "+name);
        System.out.println("game price: "+price);
        System.out.println("game describe: "+describe);
        System.out.println("============public=============");
    }

    private void showPrivate(String name, Double price) {
        System.out.println("============private=============");
        System.out.println("game name: "+name);
        System.out.println("game price: "+price);
        System.out.println("game describe: "+describe);
        System.out.println("============private=============");
    }

    protected void showProtected(String name, Double price) {
        System.out.println("============protected=============");
        System.out.println("game name: "+name);
        System.out.println("game price: "+price);
        System.out.println("game describe: "+describe);
        System.out.println("============protected=============");
    }

    void showDefault(String name, Double price) {
        System.out.println("============default=============");
        System.out.println("game name: "+name);
        System.out.println("game price: "+price);
        System.out.println("game describe: "+describe);
        System.out.println("============default=============");
    }

}
