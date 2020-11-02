package com.java_2_base.webapp.other;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainDate {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy / MM");
        System.out.println(simpleDateFormat.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT-8:00"));
        System.out.println(calendar.getTime());

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        System.out.println(formatter.format(localDate));

        long end = System.currentTimeMillis() - start;
        System.out.println("Время выполнения всего кода: " + end + " мс");
    }
}
