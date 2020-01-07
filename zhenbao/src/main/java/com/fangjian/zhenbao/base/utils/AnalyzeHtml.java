package com.fangjian.zhenbao.base.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * time 2016/8/17 0017 - 14:08
 *
 * @author fangjian
 */
public class AnalyzeHtml {
    private static String[] blockElementTagName = new String[]{"p", "div", "li", "h1", "h2", "h3", "h4", "h5", "h6", "dl", "hr", "form"};

    public static List parseToText(String input) {
        String br = "###br###";
        if (StringUtils.isEmpty(input))
            return new ArrayList();
        List<String> list = new ArrayList<String>();

        Document doc = Jsoup.parse(input);//Jsoup类将副文本转成标准的HTML文件
        //将所有的块元素标签增加换行符
        for (String tagName : blockElementTagName) {
            Elements tagEles = doc.select(tagName);
            for (Element e : tagEles) {
                String text = e.html();
                String temp = e.outerHtml();
                List<Element> childElements = e.children();
                if (CollectionUtils.isNotEmpty(childElements)) {
                    if (childElements.get(0).tagName().equals("img") || childElements.get(0).tagName().equals("IMG")) {
                        input = input.replace(temp, text);
                        continue;
                    } else {
                        Element next = e.nextElementSibling();
                        if (next != null && (next.tagName().equals("img") || next.tagName().equals("IMG"))) {
                            input = input.replace(temp, text);
                        } else {
                            text = e.text();
                            input = input.replace(temp, text + "\n");
                        }
                    }
                } else {
                    text = e.text();
                    if (StringUtils.isNotEmpty(text)) {
                        input = input.replace(temp, text + "\n");
                    }
                }
            }
        }
        input = input.replaceAll("\r\n", br).replaceAll("\r", br).replaceAll("\n", br).replaceAll("<br />", br);

        doc = Jsoup.parse(input);
        Elements eles = doc.select("img");
        if (eles.size() == 0) {
            list.add("text|" + doc.text().replaceAll(br, "\n"));
            return list;
        }
        for (Element ele : eles) {
            String src = ele.attr("src");
            String tempHtml = ele.outerHtml();
            input = input.replace(tempHtml, "#$@img|" + src + "#$@");
            tempHtml = tempHtml.replace(" />", "/>");
            input = input.replace(tempHtml, "#$@img|" + src + "#$@");
            tempHtml = tempHtml.replace("/>", ">");
            input = input.replace(tempHtml, "#$@img|" + src + "#$@");
        }
        String[] array = Jsoup.parse(input).text().substring(0, Jsoup.parse(input).text().lastIndexOf("###br###")).split("###br###"); //#\$@
        for (String str : array) {
            if (StringUtil.isBlank(str)) continue;
            if (str.startsWith("img|")) {
                list.add(str);
            } else {
                list.add(str.replace(br, ","));
            }
        }
        return list;
    }

    public static List parseToImg(String content) {
        if (StringUtils.isEmpty(content))
            return new ArrayList();
        List<String> list = new ArrayList<String>();
        Document doc = Jsoup.parse(content);
        Elements eles = doc.select("img");

        for (Element ele : eles) {
            String src = ele.attr("src");
            list.add(src);
        }
        return list;
    }

    public static void main(String[] args) {
        String content = "<p><img src=\"http://cn-todaycity-test.img-cn-hangzhou.aliyuncs.com/5fc056a5c60d4067b7f05213db84053d.png@1e_0o_1l_1000h_1000w_100q.src%7Cwatermark=1&object=dGVtcC93YXRlci1wcmludC9sb2dvX3NpbmdsZS5wbmdAMjBwXzBiXzBk&t=80&p=9&y=10&x=10&bucket=cn-todaycity-test\" title=\"\" alt=\"hd3.png\"/></p><p>发生的冯绍峰水电费是 哈哈哈哈哈哈哈哈哈哈</p><p><img src=\"http://cn-todaycity-test.img-cn-hangzhou.aliyuncs.com/1503ea74c01648a5b1402814dd5cc06d.jpg@1e_0o_1l_1000h_1000w_100q.src%7Cwatermark=1&object=dGVtcC93YXRlci1wcmludC9sb2dvX3NpbmdsZS5wbmdAMjBwXzBiXzBk&t=80&p=9&y=10&x=10&bucket=cn-todaycity-test\" title=\"\" alt=\"QQ图片20160622105453.jpg\"/></p><p>非官方大哥福德宫福德宫</p><p><img src=\"http://cn-todaycity-test.img-cn-hangzhou.aliyuncs.com/800559feb8ca46c98aa3f3294775cd05.png@1e_0o_1l_1000h_1000w_100q.src%7Cwatermark=1&object=dGVtcC93YXRlci1wcmludC9sb2dvX3NpbmdsZS5wbmdAMjBwXzBiXzBk&t=80&p=9&y=10&x=10&bucket=cn-todaycity-test\" title=\"\" alt=\"hd2.png\"/></p><p>否规范的广泛的广泛地</p>";
        System.out.print(parseToText(content).size());
    }
}
