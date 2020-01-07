<@dataTables />
<@common_js />
<#if baseTable??>
<div class="row">

    <div class="col-xs-12 col-sm-12 widget-container-span ui-sortable">
        <div class="widget-box" style="opacity: 1; z-index: 0;">
            <div class="widget-header widget-header-flat">
                <h5>${baseTable.head}</h5>

                <div class="widget-toolbar">
                    <a href="#" data-action="collapse"><i class="icon-chevron-up"></i></a>
                    <a href="#" data-action="close"><i class="icon-remove"></i></a>
                </div>
                <#if baseTable.down??>
                    <div class="widget-toolbar">
                        <button id="download_button" class="btn btn-light btn-xs"
                                style=" margin-top: 4px;"><i class="icon-download-alt"></i>导出Excel
                        </button>
                    </div>
                </#if>
            </div>

            <div class="widget-body">
                <div class="widget-main">
                    <#if baseTable.chart??>
                        <!-- chart start -->
                        <div id="${baseTable.chart}"></div>
                        <!-- chart end -->
                    </#if>
                    <!--table start -->
                    <div class="table-responsive">
                        <div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">

                            <table id="${baseTable.id}"
                                   class="table table-striped table-bordered table-hover dataTable">
                                <thead>
                                <tr role="row">

                                    <#list baseTable.rowname as row>
                                        <th class="center" role="columnheader" tabindex="0"
                                            rowspan="1" colspan="1">
                                        ${row}</th>
                                    </#list>
                                </tr>
                                </thead>
                                <tbody class="center" role="alert" aria-live="polite"
                                       aria-relevant="all">
                                </tbody>
                            </table>
                        </div>
                        <!--table end -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</#if>
