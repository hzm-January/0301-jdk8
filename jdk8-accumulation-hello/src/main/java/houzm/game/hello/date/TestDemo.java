package houzm.game.hello.date;

import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Package: houzm.game.hello.date
 * Author: houzm
 * Date: Created in 2018/8/7 17:12
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestDemo {
    public static void main(String[] args) {
        DateTime dateTime = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm").parseDateTime("2018-08-06 08:00");
        DateTime dateTime2 = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2018-08-06");
        Date date = dateTime.toDate();
        Date date1 = dateTime2.toDate();
        System.out.println(date.compareTo(date1));

    }
}
