package houzm.game.reflection;

/**
 * Package: houzm.game.reflection
 * Author: houzm
 * Date: Created in 2018/8/14 18:04
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class GameParentDO {
    public String parentName;
    private Double parentPrice;
    public void showParentPublic(){
        System.out.println("============public=============");
        System.out.println("game name: "+parentName);
        System.out.println("game price: "+parentPrice);
        System.out.println("============public=============");
    }
}
