package houzm.game.hello.returnbreakcontinue;

/**
 * Package: houzm.game.hello.returnbreakcontinue
 * Author: houzm
 * Date: Created in 2018/8/3 10:03
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class ReturnDemo {
    public static void main(String[] args) {
        System.out.println("==========main start=========");
        execReturn();
        System.out.println("==========main end=========");
    }
    public static void execReturn(){
        System.out.println("=======execReturn=========");
        return;
//        System.out.println("=======execReturn=========");
    }
}
