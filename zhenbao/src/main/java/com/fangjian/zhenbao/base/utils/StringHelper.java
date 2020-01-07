package com.fangjian.zhenbao.base.utils;

import org.apache.commons.lang.StringUtils;

import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {
    public static String camelToString(String s) {
        return s;
    }

    public static String escape(String src) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);

        for (i = 0; i < src.length(); i++) {

            j = src.charAt(i);

            if (Character.isDigit(j) || Character.isLowerCase(j)
                || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    public static String unescape(String src) {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(
                        src.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(
                        src.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    public static String join(String join, Object[] strAry) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strAry.length; i++) {
            if (i == (strAry.length - 1)) {
                sb.append(strAry[i]);
            } else {
                sb.append(strAry[i]).append(join);
            }
        }

        return new String(sb);
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || "".equals(string);
    }

    public static List<String> arrayToList(String[] array) {
        List<String> result = new ArrayList<String>();
        for (String string : array) {
            result.add(string);
        }
        return result;
    }

    public static List<String> splitToList(String src) {
        List<String> result = new ArrayList<String>();
        String[] array = src.split(",");
        for (String string : array) {
            if (isNullOrEmpty(string)) {
                result.add(string);
            }
        }
        return result;
    }

    /**
     * 设置下载文件中文件的名称
     *
     * @param filename
     * @param request
     * @return
     */
    public static String encodeFilename(String filename,
        HttpServletRequest request) {
        String agent = request.getHeader("USER-AGENT");
        try {
            if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
                String newFileName = URLEncoder.encode(filename, "UTF-8");
                newFileName = StringUtils.replace(newFileName, "+", "%20");
                if (newFileName.length() > 150) {
                    newFileName = new String(filename.getBytes("GB2312"),
                        "ISO8859-1");
                    newFileName = StringUtils.replace(newFileName, " ", "%20");
                }
                return newFileName;
            }
            if ((agent != null) && (-1 != agent.indexOf("Mozilla")))
                return MimeUtility.encodeText(filename, "UTF-8", "B");

            return filename;
        } catch (Exception ex) {
            return filename;
        }
    }

    public static String convertDeploy(String source) {

        if (source.equals("hf")) {
            return "合肥";
        } else if (source.equals("bj")) {
            return "北京";
        } else if (source.equals("gz")) {
            return "广州";
        } else {
            return source;
        }

    }
    /**
     * 去空格换行回车tab
     * 2011-9-2
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
    /*-----------------------------------
 
    笨方法：String s = "你要去除的字符串";
 
            1.去除空格：s = s.replace('\\s','');
 
            2.去除回车：s = s.replace('\n','');
 
    这样也可以把空格和回车去掉，其他也可以照这样做。
 
    注：\n 回车(\u000a) 
    \t 水平制表符(\u0009) 
    \s 空格(\u0008) 
    \r 换行(\u000d)*/

}
