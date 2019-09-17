package com.x2era.flow.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * 获取当前日期的当前周作为分区的依据
     * @return
     */
    public static String getWeekOfMonth() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = simpleDateFormat.format(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(calendar.MONDAY);
        calendar.setTime(new Date());
        String weekOfMonth = "0"+calendar.get(Calendar.WEEK_OF_MONTH);
        return format+weekOfMonth;
    }
}
