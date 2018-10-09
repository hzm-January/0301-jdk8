package houzm.game.spring.service;

import houzm.game.spring.annotation.HService;

/**
 * Package: houzm.game.spring.service
 * Author: houzm
 * Date: Created in 2018/8/13 19:47
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@HService(value = "helloService")
public class HelloServiceImpl implements HelloService{


    @Override
    public String helloWorld(String name, String age) {
        return "Hello "+name+" your age is : "+age;
    }


}
