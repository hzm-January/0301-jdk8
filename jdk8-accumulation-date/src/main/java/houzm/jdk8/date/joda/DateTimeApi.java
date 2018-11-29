package houzm.jdk8.date.joda;

import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: houzm.jdk8.date.joda
 * Author: houzm
 * Date: Created in 2018/10/15 17:01
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： test joda date api---->datetime
 */
public class DateTimeApi {
    private static Logger logger = LoggerFactory.getLogger(DateTimeApi.class);
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        logger.debug(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
        logger.debug("{}", dateTime.getEra());
        logger.debug("{}", dateTime.getCenturyOfEra()); //20
        logger.debug("{}", dateTime.getChronology()); //ISOChronology[Asia/Shanghai]
        logger.debug("{}", dateTime.getMillis()); //获取从 Java 纪元开始到现在 datetime 即时时间的毫秒* 1970-01-01T00:00:00Z
        logger.debug("{}", dateTime.getZone()); //Asia/Shanghai
        logger.debug("{}", dateTime.getMillisOfDay()); //62153600

        logger.debug("{}", dateTime.getDayOfYear()); //288
        logger.debug("{}", dateTime.getHourOfDay()); //0
        logger.debug("{}", dateTime.getMillisOfSecond()); //0
        logger.debug("{}", dateTime.getYear()); //288
        logger.debug("{}", dateTime.getMonthOfYear()); //288
        logger.debug("{}", dateTime.getDayOfMonth()); //288

        logger.debug("当天凌晨时间：{}", new DateTime(dateTime.getMillis()-dateTime.getMillisOfDay())); //2018-11-13T00:00:00.000+08:00
        logger.debug("明天凌晨时间：{}", new DateTime(dateTime.getMillis()-dateTime.getMillisOfDay()).plusDays(1)); //2018-11-14T00:00:00.000+08:00

        //date-datetime
        logger.debug("date to datetime : {}", new DateTime(new Date()));
    }
}
