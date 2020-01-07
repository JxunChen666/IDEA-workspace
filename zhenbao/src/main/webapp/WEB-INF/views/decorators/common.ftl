<#--
    freeMarker 中宏<#macro 宏变量名>解析
    宏是有一个变量名的模板片段。你可以在模板中使用宏作为自定义指令,这样就能进行重复性的工作。
-->
<#macro base_js>
<!--[if !IE]> -->
<script type="text/javascript" src="<@c.url value='/static/js/ace/jquery.min.js' />"></script>
<script type="text/javascript" src="<@c.url value='/static/js/ace/jquery-ui-1.10.3.full.min.js' />"></script>
<script type="text/javascript" src="<@c.url value='/static/js/common/json2.js' />"></script>
<script type="text/javascript" src="<@c.url value='/static/js/ace/bootbox.min.js' />"></script>
<!-- <![endif]-->
<!--[if IE]>
<script type="text/javascript" src="<@c.url value='/static/js/ace/jquery-1.10.2.min.js' />"></script>
<![endif]-->
<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='/static/js/ace/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<!-- <![endif]-->
<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='/static/js/ace/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='/static/js/ace/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script type="text/javascript" src="<@c.url value='/static/js/ace/bootstrap.min.js' />"></script>
<!-- page specific plugin scripts -->
<!-- ace scripts -->
<script type="text/javascript" src="<@c.url value='/static/js/ace/ace-elements.min.js' />"></script>
<script type="text/javascript" src="<@c.url value='/static/js/ace/ace.min.js' />"></script>
<!-- inline scripts related to this page -->
<script type="text/javascript" src="<@c.url value='/static/js/ace/ace-extra.min.js' />"></script>
<script type="text/javascript" src="<@c.url value='/static/js/ace/bootstrap-tag.min.js' />"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script type="text/javascript" src="<@c.url value='/static/js/ace/html5shiv.js' />"></script>
<script type="text/javascript" src="<@c.url value='/static/js/ace/respond.min.js' />"></script>
<![endif]-->
<script type="text/javascript">
    var Global = {
        webRoot : "${rc.getContextPath()}"
    };
</script>
</#macro>

<#macro highCharts>
<script type="text/javascript" src="<@c.url value='/static/js/chart/highcharts.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/js/chart/gri.chart.js'/>"></script>
</#macro>


<#macro common_js>
<script type="text/javascript" src="<@c.url value='/static/js/common/common.js' />"></script>
</#macro>

<#macro dataTables>
<script type="text/javascript" src="<@c.url value='/static/dataTables/jquery.dataTables.js' />"></script>
<script type="text/javascript" src="<@c.url value='/static/js/ace/jquery.dataTables.bootstrap.js' />"></script>
</#macro>

<#macro dataTables_export>
<script src="<@c.url value='/static/js/ace/TableTools.min.js'/>" charset="utf-8" type="text/javascript" /></script>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/TableTools.css'/>" charset="utf-8"/>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/TableTools_JUI.css'/>" charset="utf-8"/>
</#macro>

<#macro time>
        <link rel="stylesheet" href="<@c.url value='/static/css/ace/datepicker.css'/>"/>
        <script type="text/javascript" src="<@c.url value='/static/js/date-time/bootstrap-datepicker.min.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/js/date-time/moment.min.js' />"></script>
</#macro>

<#macro pdfobject>
<script type="text/javascript" src="<@c.url value='/static/pdfobject/pdfobject.js'/>"></script>
</#macro>

<#macro baseCss>
 <link rel="stylesheet" href="<@c.url  value='/static/js/common/css/page-min.css'/>"/>
</#macro>

<#macro bui>
<script type="text/javascript" src="<@c.url value='/static/js/common/bui.js'/>"></script>
<link rel="stylesheet" href="<@c.url value='/static/css/bui/bui-min.css'/>"/>
</#macro>

<#macro echarts>
<script type="text/javascript" src="<@c.url value='/static/js/chart/echarts-all.js'/>"></script>
</#macro>

<#macro date>
<script type="text/javascript" src="<@c.url value='/static/js/laydate/laydate.js'/>"></script>
<link rel="stylesheet" href="<@c.url value='/static/css/laydate/need/laydate.css'/>"/>
<link rel="stylesheet" href="<@c.url value='/static/css/laydate/skins/molv/laydate.css'/>"/>
</#macro>

<#macro time2>
<script type="text/javascript" src="<@c.url value='/static/js/ace/bootstrap-datetimepicker.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/js/ace/bootstrap-datetimepicker.zh-CN.js'/>"></script>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/bootstrap-datetimepicker.min.css'/>"/>
</#macro>
<#macro dataselect>
<link rel="stylesheet" href="<@c.url value='/static/dropzone/ace.min.css'/>"/>
<link rel="stylesheet" href="<@c.url value='/static/dropzone/bootstrap.min.css'/>"/>
<link rel="stylesheet" href="<@c.url value='/static/dropzone/datepicker.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/dropzone/jquery-2.0.3.min.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/ace.min.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/dropzone/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/dropzone/bootstrap-datepicker.min.js'/>"></script>


<script type="text/javascript" src="<@c.url value='/static/dropzone/bootstrap-datetimepicker.zh-CN.js'/>"></script>
</#macro>
<#macro time21>
<script type="text/javascript" src="<@c.url value='/static/js/date-time/bootstrap-datetimepicker.min.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/js/date-time/bootstrap-datetimepicker.zh-CN.js'/>"></script>
<link rel="stylesheet" href="<@c.url value='/static/js/date-time/bootstrap-datetimepicker.min.css'/>"/>
</#macro>

<#macro timerange>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/daterangepicker.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/date-time/moment.min.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/js/date-time/daterangepicker.min.js'/>"></script>
</#macro>

<#macro timerange2>
<link rel="stylesheet" href="<@c.url value='/static/css/timeRange/daterangepicker.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/timeRange/moment.min.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/js/timeRange/daterangepicker.min.js'/>"></script>
</#macro>

<#macro treetable>
<link rel="stylesheet" href="<@c.url value='/static/treetable/jquery.treetable.css'/>"/>
<link rel="stylesheet" href="<@c.url value='/static/treetable/jquery.treetable.theme.default.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/treetable/jquery.treetable.js'/>"></script>
</#macro>

<#macro layer>
<script type="text/javascript" src="<@c.url value='/static/layer-v2.1/layer/layer.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/layer-v2.1/layer/extend/layer.ext.js'/>"></script>
</#macro>

<#macro ztree>
<link rel="stylesheet" href="<@c.url value='/static/zTree/zTreeStyle.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/zTree/jquery.ztree.core-3.5.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/zTree/jquery.ztree.excheck-3.5.js'/>"></script>
</#macro>

<#macro chosen>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/chosen.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/ace/chosen.jquery.min.js'/>"></script>
</#macro>

<#macro bootstrapMultiselect>
<link rel="stylesheet" href="<@c.url value='/static/bootstrapmultiselect/css/bootstrap-multiselect.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/bootstrapmultiselect/js/bootstrap-multiselect.js'/>"></script>
</#macro>

<#macro validate>
<script type="text/javascript" src="<@c.url value='/static/js/ace/jquery.validate.min.js'/>"></script>
</#macro>

<#macro select2>
<link rel="stylesheet" href="<@c.url value='/static/select2/select2-bootstrap.css'/>"/>
<link rel="stylesheet" href="<@c.url value='/static/select2/select2.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/select2/select2.min.js'/>"></script>
</#macro>

<#macro backtop>
<link rel="stylesheet" href="<@c.url value='/static/backtop/zzsc.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/backtop/zzsc.js'/>"></script>
</#macro>

<#macro log>
<link rel="stylesheet" href="<@c.url value='/static/js/log/search.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/log/search.js'/>"></script>
</#macro>

<#macro jumplog>
<link rel="stylesheet" href="<@c.url value='/static/js/log/search.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/log/jump.js'/>"></script>
</#macro>

<#macro reclog>
<link rel="stylesheet" href="<@c.url value='/static/js/log/search.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/log/rec.js'/>"></script>
</#macro>

<#macro isaplog>
<link rel="stylesheet" href="<@c.url value='/static/js/log/search.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/log/isap.js'/>"></script>
</#macro>

<#macro timeoutlog>
<link rel="stylesheet" href="<@c.url value='/static/js/log/search.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/log/timeout.js'/>"></script>
</#macro>

<#macro export>
<link rel="stylesheet" href="<@c.url value='/static/js/export/log.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/export/log.js'/>"></script>
</#macro>

<#macro collapse>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/jquery-ui-1.10.3.full.min.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/ace/typeahead-bs2.min.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/js/ace/jquery-ui-1.10.3.full.min.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/js/ace/jquery.ui.touch-punch.min.js'/>"></script>
</#macro>

<#macro jsoneditor>
<link rel="stylesheet" href="<@c.url value='/static/json/jsoneditor.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/json/jsoneditor.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/json/ace.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/json/mode-json.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/json/theme-textmate.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/json/theme-jsoneditor.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/json/jsonlint.js'/>"></script>
</#macro>

<#macro baseStyle>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/bootstrap.min.css'/>"/>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/font-awesome.min.css'/>"/>
<!--[if IE 7]>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/font-awesome-ie7.min.css'/>"/>
<![endif]-->
<!-- fonts -->
<link rel="stylesheet" href="<@c.url value='/static/css/ace/fonts.css'/>"/>
<!-- ace styles -->
<link rel="stylesheet" href="<@c.url value='/static/css/ace/ace.min.css'/>"/>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/ace-rtl.min.css'/>"/>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/ace-skins.min.css'/>"/>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/ace-responsive.min.css'/>"/>
<!--[if lte IE 8]>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/ace-ie.min.css'/>"/>
<![endif]-->
<link rel="stylesheet" href="<@c.url value='/static/css/ace/stat.css'/>"/>
</#macro>


<#macro ueditor>
<link rel="stylesheet" href="<@c.url value='/static/ueditor/themes/default/css/ueditor.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/ueditor/ueditor.config.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/ueditor/ueditor.all.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/ueditor/lang/zh-cn/zh-cn.js'/>"></script>
</#macro>
<#macro dropzone>
<link rel="stylesheet" href="<@c.url value='/static/dropzone/dropzone.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/dropzone/dropzone.js'/>"></script>
<script type="text/javascript" src="<@c.url value='/static/dropzone/typeahead-bs2.min.js'/>"></script>
</#macro>

<#macro td_break>
<style type="text/css">
td
{
  word-break: break-all;/*必须*/
}
</style>
</#macro>

<#macro ajaxupload>
<script type="text/javascript" src="<@c.url value='/static/js/ajaxupload/ajaxfileupload.js'/>"></script>
</#macro>

<#macro switch>
<link rel="stylesheet" href="<@c.url value='/static/css/ace/bootstrap-switch.min.css'/>"/>
<script type="text/javascript" src="<@c.url value='/static/js/ace/bootstrap-switch.min.js'/>"></script>
</#macro>

<#macro fontawesome>
<link rel="stylesheet" href="<@c.url value='/static/font-awesome/css/font-awesome.min.css'/>"/>
</#macro>