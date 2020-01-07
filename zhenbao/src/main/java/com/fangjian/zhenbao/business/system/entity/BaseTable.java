/**
 * @author zyyang3
 * @date 2014-03-10
 * @description table基本配置参数
 */
package com.fangjian.zhenbao.business.system.entity;

import java.util.ArrayList;
import java.util.List;


public class BaseTable {

    /**
     * table标题
     */
    private String head;
    /**
     * table的id
     */
    private String id;
    /**
     * table 下载选项
     */
    private String down;
    /**
     * table hightchart
     */
    private String chart;
    /**
     * table列名称
     */
    private List<String> rowname = new ArrayList<String>();

    public BaseTable() {

    }

    /**
     * @param head    table的表头
     * @param id      table的id
     * @param options table的列标题(以逗号分开)
     * @return BaseTable实体
     */
    public BaseTable(String head, String id, String options) {
        this.head = head;
        this.id = id;
        List<String> row = new ArrayList<String>();
        String[] rows = options.split(",");
        for (String option : rows) {
            row.add(option);
        }
        this.rowname = row;
    }

    /**
     * @param head    table的表头
     * @param id      table的id
     * @param options table的列标题(以逗号分开)
     * @param append  table下载选项/table的chart (down:下载项;chart:图表;downchart:下载项&图表)
     * @return BaseTable实体
     */
    public BaseTable(String head, String id, String options, String append) {
        this.head = head;
        this.id = id;
        List<String> row = new ArrayList<String>();
        String[] rows = options.split(",");
        for (String option : rows) {
            row.add(option);
        }
        this.rowname = row;
        if (append.equals("down")) {
            this.down = append;
        } else if (append.equals("downchart")) {
            this.down = append;
            this.chart = "chart";
        } else {
            this.chart = append;
        }
    }

    /**
     * @return the head
     */
    public String getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * down.
     *
     * @return the down
     * @since JDK 1.6
     */
    public String getDown() {
        return down;
    }

    /**
     * down.
     *
     * @param down the down to set
     * @since JDK 1.6
     */
    public void setDown(String down) {
        this.down = down;
    }

    /**
     * chart.
     *
     * @return the chart
     * @since JDK 1.6
     */
    public String getChart() {
        return chart;
    }

    /**
     * chart.
     *
     * @param chart the chart to set
     * @since JDK 1.6
     */
    public void setChart(String chart) {
        this.chart = chart;
    }

    /**
     * @return the rowname
     */
    public List<String> getRowname() {
        return rowname;
    }

    /**
     * @param rowname the rowname to set
     */
    public void setRowname(List<String> rowname) {
        this.rowname = rowname;
    }
}
