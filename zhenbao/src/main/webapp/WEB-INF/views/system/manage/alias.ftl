<@override name="showBody">
    <@dataTables />
    <@common_js />
    <@layer />

<div class="commonform">
    <form class="queryForm">
        <div class="querydiv" style="height: 55px;">
            <label><span>区域名称：</span><input placeholder="按区域名称查找" type="text"  id="disName" name="disName"
                                             class="input" <#--oninput="return userTable.fnDraw()"-->
                                             style="width: 200px;" required/></label>

            <label><span>省级简称：</span><input placeholder="按省级简称查找" type="text" id="disSimpleName" name="disSimpleName"
                                           class="input" oninput="return aliasTable.fnDraw()"
                                           style="width: 200px;" required/></label>
        </div>

        <div class="querybtn">
            <button type="button" id="btnQuery" class="btn btn-sm btn-danger" style="height: 55px;">查询&nbsp;
                <i class="icon-search"></i></button>
        </div>
    </form>
</div>
<div class="operator">
    <button type="button" id="btnAdd" class="btn btn-sm btn-danger fillet">
        <i class="icon-plus smaller-75"></i>添加省份
    </button>
</div>

<div id="result" style="width: 100%;">
    <table id="aliasTable" class="center table table-striped table-bordered table-hover dataTable" >
        <thead>
        <tr>
            <th style="width:10%;"></th>
            <th style="width:10%;"></th>
            <th style="width:11%;"></th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>

<script type="text/javascript" src="<@c.url value='/static/js/system/manage/alias.js'/>"></script>


</@override>
<@extends name="../../decorators/base.ftl"/>
