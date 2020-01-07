/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.fangjian.zhenbao.base.utils;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 *
 * @author ThinkGem
 * @version 2013-3-15
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {

    private static String[] parsePatterns =
            {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
                    "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm"};
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static String timeString;

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatUTCDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.formatUTC(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.formatUTC(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatUTCDateTime(Date date) {
        return formatUTCDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }


    public static Date getDateStart(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getDateEnd(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * getDay:获取相对当前的日期. <br/>
     *
     * @param gap 与当前日期的差值(0,1,-1....)
     * @return
     * @author zyyang3
     * @since JDK 1.6
     */
    public static String getDay(int gap) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, gap);
        Date date = cal.getTime();
        String day = DateFormatUtils.format(date, "yyyy-MM-dd");
        return day;
    }


    /**
     * getDay:获取相对字符串日期. <br/>
     *
     * @param gap 与相对字符串日期的差值(0,1,-1....)
     * @return
     * @throws ParseException
     * @author zyyang3
     * @since JDK 1.6
     */
    public static String getDay(String time, int gap) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Date datetmp = sdf.parse(time);
        cal.setTime(datetmp);
        cal.add(Calendar.DAY_OF_MONTH, gap);
        Date date = cal.getTime();
        String day = DateFormatUtils.format(date, "yyyy-MM-dd");
        return day;
    }

    /**
     * 获取当前时间戳
     * fangjian
     *
     * @return
     */
    public static long getSequence() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 时间戳转时间
     * fangjian
     *
     * @param sequence
     * @return
     */
    public static String sequenceToDateTime(long sequence) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date(sequence * 1000));
        return date;
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        //		System.out.println(formatDate(parseDate("2010/3/6")));
        //		System.out.println(getDate("yyyy年MM月dd日 E"));
        //		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
        //		System.out.println(time/(24*60*60*1000));
/*	    System.out.println(getDay(-1));
        System.out.println(getDay(-8));
*/
        System.out.println(DateUtils.dataToSequence("2019-03-12" + " 23:59:59"));
    }

    public static String getTimeString() {
        return formatDateTime(new Date());
    }

    /**
     * 日期转时间戳
     *
     * @param dateTime
     * @return
     * @throws ParseException
     */
    public static long dataToSequence(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long sequence = 0;
        try {
            sequence = sdf.parse(dateTime).getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sequence;
    }

    /**
     * 秒转为天时分
     *
     * @param second
     * @return
     */
    public static String secondsToDayHourMinute(float second) {
        int d;
        int h;
        int m;
        float temp;
        if (0 == second) {
            return "0";
        } else {
            if (second >= 86400) {
                d = (int) second / 86400;
                temp = second % 86400;
                if (temp >= 3600) {
                    h = (int) temp / 3600;
                    temp = temp % 3600;
                    m = Math.round(temp / 60);
                    return d + "天" + h + "时" + m + "分";
                } else {
                    m = Math.round(temp / 60);
                    return d + "天" + m + "分";
                }
            } else if (second >= 3600) {
                h = (int) second / 3600;
                temp = second % 3600;
                m = Math.round(temp / 60);
                return h + "时" + m + "分";
            } else {
                m = Math.round(second / 60);
                return m + "分";
            }
        }
    }

    public static String secondToTourMinute(float second) {
        if (second <= 0) {
            return "0";
        } else {
            if (second >= 3600) {
                float temp = second % 3600;
                int h = (int) second / 3600;
                return h + "小时" + Math.round(temp / 60) + "分";
            } else {
                return Math.round(second / 60) + "分";
            }

        }
    }
}
