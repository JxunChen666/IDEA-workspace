package com.fangjian.zhenbao.base.freemarker.staticfunction;

import com.fangjian.zhenbao.base.utils.DateUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Freemarker页面自定义函数
 */
public class FreemarkerFunction {

    public static String getDay() {
        return DateUtils.getDay(0);
    }

    public static String getYesterDay() {
        return DateUtils.getDay(-1);
    }

    public static String getTimeRange() {
        return DateUtils.getDay(-6) + " - " + DateUtils.getDay(0);
    }

    public static String getTimeRange(int start, int end) {
        return DateUtils.getDay(start) + " - " + DateUtils.getDay(end);
    }

    public static String getCompareTimeRange() {
        return DateUtils.getDay(-13) + " - " + DateUtils.getDay(-7);
    }

    public static String seuqenceToDateTime(long sequence) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date(sequence * 1000));
        return date;
    }

    /**
     * 解码
     * @param message
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String decode(String message) throws UnsupportedEncodingException {
        return URLDecoder.decode(message,"utf-8");
    }

}
