/**
 * Project Name:cloud File Name:Chart.java Package Name:com.iflytek.web.entity
 * Date:2014年4月25日下午3:05:59 Copyright (c) 2014, zyyang3@iflytek.com All Rights Reserved.
 *
 */

package com.fangjian.zhenbao.business.system.entity;

import java.util.List;

/**
 * ClassName:Chart <br/>
 * Description: HighChart参数实体类. <br/>
 * Date: 2014年4月25日 下午3:05:59 <br/>
 *
 * @author zyyang3
 * @version 1.0
 * @see
 * @since JDK 1.6
 */
public class Chart {

    private String title; // 图表标题,备用
    private boolean showLabel; // 是否显示标签
    private boolean showMarker; // 是否显示点
    private String chartType; // 图表类型
    private int dataFormat; // 数据类型，1：整数，2：浮点数 3：百分比，仅在后面追加百分号 4：时间格式 HH:MM:SS 5：百分比，显示时会乘上100
    // 6：不处理，保留原有格式 7: 当是整数时 format为整数，小数就显示浮点 modified by dorsywang
    private int labelFormat; // 指定标签显示的格式，0: 不显示，1: 显示Y值， 2：自动计算百分比并显示
    private List<String> categories; // X轴数据
    private List<Series> series; // Y轴数列
    private String yMin; // Y轴最小值
    private String yMax; // Y轴最大值
    private int xAxisLabelStep; // X轴标签间隔
    private int xAxisTickInterval; // X轴刻度间隔
    private boolean enableZoom;
    private boolean autoStep; // 自动计算步长
    private boolean showPlotLine; // 是否显示中位线
    private boolean enableLegend; // 是否显示图例
    private boolean autoYAxisInterval; // 自动计算Y轴间隔
    private int maxYAxisIntervalCount; // Y轴最大刻度数
    private boolean isCompareSeries; // 判断两个数列是否为对比数列
    private boolean autoxAxisDataType; // 是否自动识别X轴数据类型，比如日期类型，以别进行相关个性化设置
    private int height=300;//设置表格高度高度
    /**
     * title.
     *
     * @return the title
     * @since JDK 1.6
     */
    public String getTitle() {
        return title;
    }

    /**
     * title.
     *
     * @param title the title to set
     * @since JDK 1.6
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * showLabel.
     *
     * @return the showLabel
     * @since JDK 1.6
     */
    public boolean isShowLabel() {
        return showLabel;
    }

    /**
     * showLabel.
     *
     * @param showLabel the showLabel to set
     * @since JDK 1.6
     */
    public void setShowLabel(boolean showLabel) {
        this.showLabel = showLabel;
    }

    /**
     * showMarker.
     *
     * @return the showMarker
     * @since JDK 1.6
     */
    public boolean isShowMarker() {
        return showMarker;
    }

    /**
     * showMarker.
     *
     * @param showMarker the showMarker to set
     * @since JDK 1.6
     */
    public void setShowMarker(boolean showMarker) {
        this.showMarker = showMarker;
    }

    /**
     * chartType.
     *
     * @return the chartType
     * @since JDK 1.6
     */
    public String getChartType() {
        return chartType;
    }

    /**
     * chartType.
     *
     * @param chartType the chartType to set
     * @since JDK 1.6
     */
    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    /**
     * dataFormat.
     *
     * @return the dataFormat
     * @since JDK 1.6
     */
    public int getDataFormat() {
        return dataFormat;
    }

    /**
     * dataFormat.
     *
     * @param dataFormat the dataFormat to set
     * @since JDK 1.6
     */
    public void setDataFormat(int dataFormat) {
        this.dataFormat = dataFormat;
    }

    /**
     * labelFormat.
     *
     * @return the labelFormat
     * @since JDK 1.6
     */
    public int getLabelFormat() {
        return labelFormat;
    }

    /**
     * labelFormat.
     *
     * @param labelFormat the labelFormat to set
     * @since JDK 1.6
     */
    public void setLabelFormat(int labelFormat) {
        this.labelFormat = labelFormat;
    }

    /**
     * categories.
     *
     * @return the categories
     * @since JDK 1.6
     */
    public List<String> getCategories() {
        return categories;
    }

    /**
     * categories.
     *
     * @param categories the categories to set
     * @since JDK 1.6
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * series.
     *
     * @return the series
     * @since JDK 1.6
     */
    public List<Series> getSeries() {
        return series;
    }

    /**
     * series.
     *
     * @param series the series to set
     * @since JDK 1.6
     */
    public void setSeries(List<Series> series) {
        this.series = series;
    }

    /**
     * yMin.
     *
     * @return the yMin
     * @since JDK 1.6
     */
    public String getyMin() {
        return yMin;
    }

    /**
     * yMin.
     *
     * @param yMin the yMin to set
     * @since JDK 1.6
     */
    public void setyMin(String yMin) {
        this.yMin = yMin;
    }

    /**
     * yMax.
     *
     * @return the yMax
     * @since JDK 1.6
     */
    public String getyMax() {
        return yMax;
    }

    /**
     * yMax.
     *
     * @param yMax the yMax to set
     * @since JDK 1.6
     */
    public void setyMax(String yMax) {
        this.yMax = yMax;
    }

    /**
     * xAxisLabelStep.
     *
     * @return the xAxisLabelStep
     * @since JDK 1.6
     */
    public int getxAxisLabelStep() {
        return xAxisLabelStep;
    }

    /**
     * xAxisLabelStep.
     *
     * @param xAxisLabelStep the xAxisLabelStep to set
     * @since JDK 1.6
     */
    public void setxAxisLabelStep(int xAxisLabelStep) {
        this.xAxisLabelStep = xAxisLabelStep;
    }

    /**
     * xAxisTickInterval.
     *
     * @return the xAxisTickInterval
     * @since JDK 1.6
     */
    public int getxAxisTickInterval() {
        return xAxisTickInterval;
    }

    /**
     * xAxisTickInterval.
     *
     * @param xAxisTickInterval the xAxisTickInterval to set
     * @since JDK 1.6
     */
    public void setxAxisTickInterval(int xAxisTickInterval) {
        this.xAxisTickInterval = xAxisTickInterval;
    }

    /**
     * enableZoom.
     *
     * @return the enableZoom
     * @since JDK 1.6
     */
    public boolean isEnableZoom() {
        return enableZoom;
    }

    /**
     * enableZoom.
     *
     * @param enableZoom the enableZoom to set
     * @since JDK 1.6
     */
    public void setEnableZoom(boolean enableZoom) {
        this.enableZoom = enableZoom;
    }

    /**
     * autoStep.
     *
     * @return the autoStep
     * @since JDK 1.6
     */
    public boolean isAutoStep() {
        return autoStep;
    }

    /**
     * autoStep.
     *
     * @param autoStep the autoStep to set
     * @since JDK 1.6
     */
    public void setAutoStep(boolean autoStep) {
        this.autoStep = autoStep;
    }

    /**
     * showPlotLine.
     *
     * @return the showPlotLine
     * @since JDK 1.6
     */
    public boolean isShowPlotLine() {
        return showPlotLine;
    }

    /**
     * showPlotLine.
     *
     * @param showPlotLine the showPlotLine to set
     * @since JDK 1.6
     */
    public void setShowPlotLine(boolean showPlotLine) {
        this.showPlotLine = showPlotLine;
    }

    /**
     * enableLegend.
     *
     * @return the enableLegend
     * @since JDK 1.6
     */
    public boolean isEnableLegend() {
        return enableLegend;
    }

    /**
     * enableLegend.
     *
     * @param enableLegend the enableLegend to set
     * @since JDK 1.6
     */
    public void setEnableLegend(boolean enableLegend) {
        this.enableLegend = enableLegend;
    }

    /**
     * autoYAxisInterval.
     *
     * @return the autoYAxisInterval
     * @since JDK 1.6
     */
    public boolean isAutoYAxisInterval() {
        return autoYAxisInterval;
    }

    /**
     * autoYAxisInterval.
     *
     * @param autoYAxisInterval the autoYAxisInterval to set
     * @since JDK 1.6
     */
    public void setAutoYAxisInterval(boolean autoYAxisInterval) {
        this.autoYAxisInterval = autoYAxisInterval;
    }

    /**
     * maxYAxisIntervalCount.
     *
     * @return the maxYAxisIntervalCount
     * @since JDK 1.6
     */
    public int getMaxYAxisIntervalCount() {
        return maxYAxisIntervalCount;
    }

    /**
     * maxYAxisIntervalCount.
     *
     * @param maxYAxisIntervalCount the maxYAxisIntervalCount to set
     * @since JDK 1.6
     */
    public void setMaxYAxisIntervalCount(int maxYAxisIntervalCount) {
        this.maxYAxisIntervalCount = maxYAxisIntervalCount;
    }

    /**
     * isCompareSeries.
     *
     * @return the isCompareSeries
     * @since JDK 1.6
     */
    public boolean isCompareSeries() {
        return isCompareSeries;
    }

    /**
     * isCompareSeries.
     *
     * @param isCompareSeries the isCompareSeries to set
     * @since JDK 1.6
     */
    public void setCompareSeries(boolean isCompareSeries) {
        this.isCompareSeries = isCompareSeries;
    }

    /**
     * autoxAxisDataType.
     *
     * @return the autoxAxisDataType
     * @since JDK 1.6
     */
    public boolean isAutoxAxisDataType() {
        return autoxAxisDataType;
    }

    /**
     * autoxAxisDataType.
     *
     * @param autoxAxisDataType the autoxAxisDataType to set
     * @since JDK 1.6
     */
    public void setAutoxAxisDataType(boolean autoxAxisDataType) {
        this.autoxAxisDataType = autoxAxisDataType;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
