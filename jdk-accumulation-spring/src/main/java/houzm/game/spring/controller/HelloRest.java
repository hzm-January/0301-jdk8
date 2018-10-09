package houzm.game.spring.controller;

import houzm.game.spring.annotation.HAutowired;
import houzm.game.spring.annotation.HController;
import houzm.game.spring.annotation.HRequestMapping;
import houzm.game.spring.annotation.HRequestParam;
import houzm.game.spring.service.HelloService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Package: houzm.game.spring.controller
 * Author: houzm
 * Date: Created in 2018/8/13 19:18
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@HController
@HRequestMapping("/api")
public class HelloRest {

    @HAutowired(value = "helloService")
    private HelloService helloService;

    @HRequestMapping(value="/helloworld")
    public void helloWorld(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                           @HRequestParam(value="name") String name,
                           @HRequestParam(value="age") String age) throws IOException {
        String helloWorld = helloService.helloWorld(name, age);
        PrintWriter writer = httpResponse.getWriter();
        writer.write(helloWorld);
    }

}
