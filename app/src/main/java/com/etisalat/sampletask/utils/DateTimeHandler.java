package com.etisalat.sampletask.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Ahmed Etman on 4/26/2018.
 */

public class DateTimeHandler {

    public static String getDate(long milliSeconds)
    {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

}
