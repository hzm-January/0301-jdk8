package houzm.jdk8.date.joda;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: houzm.jdk8.date.joda
 * Author: houzm
 * Date: Created in 2018/10/31 14:58
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： MinutesAPI
 */
public class MinutesAPI {
    private static Logger logger = LoggerFactory.getLogger(MinutesAPI.class);

    public static void main(String[] args) {
        DateTime dateTime = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2018-10-12 12:12:00");
        DateTime dateTime2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2018-10-12 12:10:00");

        int minutes21 = Minutes.minutesBetween(dateTime2, dateTime).getMinutes();
        int minutes12 = Minutes.minutesBetween(dateTime, dateTime2).getMinutes();
        logger.debug("时间差：{}", minutes21);
        logger.debug("时间差：{}", minutes12);
    }
}
