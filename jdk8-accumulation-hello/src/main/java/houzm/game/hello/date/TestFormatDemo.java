package houzm.game.hello.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Package: houzm.game.hello.date
 * Author: houzm
 * Date: Created in 2018/7/6 10:44
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestFormatDemo {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        System.out.println(sdf.format(new Date()));
        SimpleDateFormat sdf2 = new SimpleDateFormat("mm dd, YYYY");
        System.out.println(sdf2.format(new Date()));
    }
}
