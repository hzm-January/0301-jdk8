package houzm.game.hello.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;

/**
 * Package: houzm.game.hello.date
 * Author: houzm
 * Date: Created in 2018/7/7 15:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TestJodaDemo {
    public static void main(String[] args) throws ParseException {

        DateTime salesDeadline = new DateTime();
        System.out.println(salesDeadline);
        salesDeadline = salesDeadline.plusMinutes(30);
        System.out.println(salesDeadline);
        Date departTimeToday =  new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 14:10");
        boolean isAfter = salesDeadline.isAfter(departTimeToday.getTime()); //now+limite>depTime可销售 now+limite<depTime不可销售
        System.out.println(isAfter);

        //string-datetime
        DateTime strToTime = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2018-09-09");
        System.out.println(strToTime);

        //compareto()
        DateTime datetime1 = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2018-09-09");
        DateTime datetime2 = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2018-09-09");
        System.out.println("Joda DateTime method compareTo() : \"2018-09-09\".compareTo(\"2018-09-09\")="+datetime1.compareTo(datetime2)); //0

        //plus()
        DateTime datetime3 = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2018-09-09");
        DateTime datetime4 = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2018-09-10");
        System.out.println(datetime4.plus(Days.daysBetween(datetime3,datetime4))); //2018-09-11T00:00:00.000+08:00
        System.out.println(datetime4.plus(Days.daysBetween(datetime3,datetime4))); //2018-09-11T00:00:00.000+08:00
        System.out.println(datetime4.plusMinutes(2)); //
    }
}
