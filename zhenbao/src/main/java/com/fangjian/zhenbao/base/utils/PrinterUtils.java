package com.fangjian.zhenbao.base.utils;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.AttributedString;

/**
 * @author FangJian
 * @description: 打印的工具类
 * @date 2019-06-03 09:44
 */
public class PrinterUtils implements Printable {

    /**
     * @param graphics   指明打印的图形环境
     * @param pageFormat 指明打印页格式（页面大小以点为计量单位，1点为1英才的1/72，1英寸为25.4毫米。A4纸大致为595×842点）
     * @param pageIndex  指明页号
     **/
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Component c = null;
        String str = "（1)车辆信息";

        //转换成Graphics2D
        Graphics2D g2 = (Graphics2D) graphics;

        //设置打印颜色为黑色
        g2.setColor(Color.black);

        //打印起点坐标
        double x = pageFormat.getImageableX();
        double y = pageFormat.getImageableY();
        switch (pageIndex) {
            case 0:
                //设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
                //Java平台所定义的五种字体系列：Serif、SansSerif、Monospaced、Dialog 和 DialogInput
                Font font = new Font("新宋体", Font.PLAIN, 20);
                g2.setFont(font);//设置字体

                //BasicStroke bs_3=new BasicStroke(0.5f);
                float[] dash1 = {2.0f};
                g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
                float height = font.getSize2D();//字体高度
                System.out.println("x=" + x);
                //使用抗锯齿模式完成文本呈现
               /*g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,

              RenderingHints.VALUE_TEXT_ANTIALIAS_ON);*/

                // -1- 用Graphics2D直接输出

                //首字符的基线(右下部)位于用户空间中的 (x, y) 位置处
                //g2.drawLine(10,10,200,10);

                /*Image src = Toolkit.getDefaultToolkit().getImage("d://logo.gif");
                g2.drawImage(src, (int) x, (int) y, c);
                int img_Height = src.getHeight(c);
                int img_width = src.getWidth(c);

                //System.out.println("img_Height="+img_Height+"img_width="+img_width) ;
                g2.drawString(str, (float) x, (float) y + 1 * height + img_Height);
                g2.drawLine((int) x, (int) (y + 1 * height + img_Height + 10), (int) x + 200, (int) (y + 1 * height + img_Height + 10));
                g2.drawImage(src, (int) x, (int) (y + 1 * height + img_Height + 11), c);*/


                // -2- 直接构造TextLayout打印
                FontRenderContext frc = g2.getFontRenderContext();

                TextLayout layout = new TextLayout(str, font, frc);

                layout.draw(g2, (float) x, (float) y + 2 * height);


                // -3- 用LineBreakMeasurer进行打印
               /* AttributedString text = new AttributedString(str);

                text.addAttribute(TextAttribute.FONT, font);

                LineBreakMeasurer lineBreaker = new LineBreakMeasurer(text.getIterator(), frc);

                //每行字符显示长度(点)

                double width = pageFormat.getImageableWidth();

                //首字符的基线位于用户空间中的 (x, y) 位置处

                Point2D.Double pen = new Point2D.Double(100, y + 3 * height);

                while ((layout = lineBreaker.nextLayout((float) width)) != null) {

                    layout.draw(g2, (float) x, (float) pen.y);

                    pen.y += layout.getAscent();

                }*/
                return PAGE_EXISTS;
            default:
                return NO_SUCH_PAGE;
        }
    }
}
