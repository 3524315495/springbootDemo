package com.example.demo.demo05Time;

import org.junit.jupiter.api.Test;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：https://www.jianshu.com/p/2949db9c3df5
 */
public class Test5 {

    /**
     * Instant：时间戳
     * Duration：持续时间，时间差
     * LocalDate：只包含日期，比如：2016-10-20
     * LocalTime：只包含时间，比如：23:12:10
     * LocalDateTime：包含日期和时间，比如：2016-10-20 23:14:21
     * Period：时间段
     * ZoneOffset：时区偏移量，比如：+8:00
     * ZonedDateTime：带时区的时间
     * Clock：时钟，比如获取目前美国纽约的时间
     */


    private static LocalDateTime localDateTime = LocalDateTime.now();
    private static LocalDate localDate = LocalDate.now();
    private static LocalTime localTime = LocalTime.now();
    LocalDate notLocalDate = LocalDate.of(2099, 10, 1);


    /**
     * LocalDate LocalTime LocalDateTime
     */
    @Test
    public void test1() {
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
    }


    @Test
    public void test2() {
        // TemporalAdjusters 时间调节器
        // 获取当月的第一天
        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(localDateTime.withDayOfMonth(1));

        // 获取当前月最后一天
        System.out.println(localDateTime.with(TemporalAdjusters.lastDayOfMonth()));


        // 当前日期 + 1 day
        System.out.println(localDateTime.plusDays(1));

        // 判断是否是闰年
        System.out.println(localDate.isLeapYear());
    }

    /**
     * 判断是否是生日
     * of() 创建一个自定义的日期对象
     * from(日期对象) 截取日期对象
     */
    @Test
    public void test3() {
        LocalDate birthday = LocalDate.of(2022, 5, 31);
        MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay today = MonthDay.from(LocalDate.of(2022, 10, 4));
        System.out.println(birthdayMd + " " + today);
        System.out.println(birthdayMd.equals(today));
    }

    /**
     * 获取当前时间
     */
    @Test
    public void test4() {
        System.out.println(LocalDateTime.now());
        // 不显示毫秒
        System.out.println(LocalDateTime.now().withNano(0));

        //withHour(...) 可以改变小时数
        System.out.println(LocalDateTime.now().withHour(2));
        System.out.println(LocalDateTime.now().withDayOfYear(2));// 获取一年中的第二天

        // 指定时间
        System.out.println(LocalDate.of(2099, 10, 1));
        System.out.println(LocalDate.parse("9999-10-01"));

        //当前时间增加两个小时
        System.out.println(localDateTime.plusHours(2));
        System.out.println(localDateTime.plus(2, ChronoUnit.HOURS));
    }

    /**
     * 日期比较前后 返回 boolean
     */
    @Test
    public void test5() {
        LocalDate local = LocalDate.of(2099, 10, 1);
        System.out.println(localDate.isAfter(local));
    }

    /**
     * 比较两个日期的时间差
     */
    @Test
    public void test6() {
        Period between = Period.between(notLocalDate, localDate);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
        System.out.println(between.getChronology()); // ISO
        System.out.println(between.getUnits());// [Years, Months, Days]
    }

    /**
     * 格式化 java8中，预定义了一些标准的时间格式，我们可以直接将时间转换为标准的时间格式
     */
    @Test
    public void test7() {
        String s = "20220101";
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate parse = LocalDate.parse(s, formatter);
        System.out.println(parse);
    }

    /**
     * 自定义时间格式 DateTimeFormatter.ofPattern()
     */
    @Test
    public void test8() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH点mm分ss秒");
        System.out.println(formatter.format(localDateTime));
    }

}
