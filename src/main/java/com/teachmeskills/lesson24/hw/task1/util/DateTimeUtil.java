package com.teachmeskills.lesson24.hw.task1.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.teachmeskills.lesson24.hw.task1.consts.IDateTimeFormat;
import com.teachmeskills.lesson24.hw.task1.consts.IDateTimeMessage;

public class DateTimeUtil {

    public static String getCurrentDateTimeByZoneId(String zoneId) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(IDateTimeFormat.DATE_TIME_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone(zoneId));
        return df.format(date);
    }

    public static void printDateTime(HttpServletResponse resp, String timeZoneId, String city) throws ServletException, IOException {
        String dateTime = DateTimeUtil.getCurrentDateTimeByZoneId(timeZoneId);
        String dateTimeMessage = String.format(IDateTimeMessage.DATE_TIME_MESSAGE, city, dateTime);
        PrintWriter pw = resp.getWriter();
        pw.write(dateTimeMessage);
        pw.close();
    }
}
