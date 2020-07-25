package com.springboot.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date getDateBefore(Date date,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - day );
        return calendar.getTime();
    }
}
