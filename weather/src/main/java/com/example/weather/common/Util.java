package com.example.weather.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Util {

    public static String addDaysToDate(Date date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(date);
        String changedDate = LocalDate.parse(strDate).plusDays(days).toString();
        return sdf.format(sdf.parse(changedDate));
    }

}
