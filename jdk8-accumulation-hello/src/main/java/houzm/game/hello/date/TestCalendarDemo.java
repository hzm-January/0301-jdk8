package houzm.game.hello.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Package: houzm.game.hello.date
 * Author: houzm
 * Date: Created in 2018/7/7 15:26
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestCalendarDemo {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 30);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
        Date departTimeToday =  new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 14:10");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 14:10:00");
        Calendar to = Calendar.getInstance();
        to.setTime(departTimeToday);
        boolean after = calendar.after(to);
        System.out.println(after);

    }
}
