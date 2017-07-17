<#assign title="用户管理"/>
<#assign menuId="7"/>
<#include "../common/head_top.ftl"/>
<!-- page specific plugin styles -->
<link rel="stylesheet" href="${ctx}/assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ui.jqgrid.min.css" />
<#include "../common/head_bottom.ftl"/>
<#include "../common/body_top.ftl"/>
<div class="col-xs-12">
    <!-- PAGE CONTENT BEGINS -->
    <form class="form-inline">
        <label class="inline">
            <span class="lbl">登录名：</span>
            <input type="text" class="input-medium" placeholder="登录名" />
        </label>
        <label class="inline">
            <span class="lbl">手机号：</span>
            <input type="password" class="input-medium" placeholder="手机号" />
        </label>


        <label style="position: absolute;right: 22px;">
            &nbsp; &nbsp; &nbsp; &nbsp;
            <button type="button" class="btn btn-info btn-sm ">
                查询
            </button>
        </label>
    </form>
    <div style="margin-bottom: 3px;margin-top: 3px;">
        <button id="add_user" class="btn btn-minier btn-primary">添加</button>&nbsp;
        <button class="btn btn-minier btn-primary">启用</button>&nbsp;
        <button class="btn btn-minier btn-primary">禁用</button>
    </div>
    <table id="grid-table"></table>

    <div id="grid-pager"></div>

    <!-- PAGE CONTENT ENDS -->
</div><!-- /.col -->
<div id="dialog">

</div>
<#include "../common/body_middle.ftl"/>

<!-- page specific plugin scripts -->
<script src="${ctx}/assets/js/bootstrap-datepicker.min.js"></script>
<script src="${ctx}/assets/js/jquery.jqGrid.min.js"></script>
<script src="${ctx}/assets/js/grid.locale-en.js"></script>
<!-- inline scripts related to this page -->
<script src="${ctx}/assets/js/jquery-ui.min.js"></script>
<script src="${ctx}/assets/js/jquery.ui.touch-punch.min.js"></script>

<script type="text/javascript">

    jQuery(function($) {
        var grid_selector = "#grid-table";
        var pager_selector = "#grid-pager";


        var parent_column = $(grid_selector).closest('[class*="col-"]');
        //resize to fit page size
        $(window).on('resize.jqGrid', function () {
            $(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
        });

        //resize on sidebar collapse/expand
        $(document).on('settings.ace.jqGrid' , function(ev, event_name, collapsed) {
            if( event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed' ) {
                //setTimeout is for webkit only to give time for DOM changes and then redraw!!!
                setTimeout(function() {
                    $(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
                }, 20);
            }
        });

        //if your grid is inside another element, for example a tab pane, you should use its parent's width:
        /**
         $(window).on('resize.jqGrid', function () {
					var parent_width = $(grid_selector).closest('.tab-pane').width();
					$(grid_selector).jqGrid( 'setGridWidth', parent_width );
				})
         //and also set width when tab pane becomes visible
         $('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
				  if($(e.target).attr('href') == '#mygrid') {
					var parent_width = $(grid_selector).closest('.tab-pane').width();
					$(grid_selector).jqGrid( 'setGridWidth', parent_width );
				  }
				})
         */





        jQuery(grid_selector).jqGrid({
            //direction: "rtl",

            url : "${ctx}/sysuser/list",
            subGrid : false,
            datatype: "json",
            height: 325,
            colNames:['登录名','用户名','昵称','手机号','创建时间','状态','操作'],
            colModel:[
                {name:'loginName',index:'loginName',width:90},
                {name:'userName',index:'userName', width:90},
                {name:'nickName',index:'nickName', width:90},
                {name:'phone',index:'phone', width:90},
                {name:'fcreateTime',index:'createTime', width:100},
                {name:'strStatus',index:'status', width:90},
                {name:'userId',index:'userId', width:80, fixed:true, sortable:false, resize:false,
                    formatter: operateFormatter
                }
            ],
            jsonReader : {
                root:"list",
                page: "pageNum",
                total: "pages",
                records: "total"
            },
            pgtext : "第 {0} 页，共 {1}页",
            recordtext : "第 {0} 到 {1} 共 {2} 条",
            viewrecords : true,
            rowNum:10,
            rowList:[10,20,30],
            pager : pager_selector,
            altRows: true,
            //toppager: true,
            multiselect: true,
            //multikey: "ctrlKey",
            multiboxonly: true,

            loadComplete : function() {
                var table = this;
                setTimeout(function(){
                    updatePagerIcons(table);
                    enableTooltips(table);
                }, 0);
            },

            caption: "",
            autowidth: true


        });
        $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size


        //navButtons
        jQuery(grid_selector).jqGrid('navGrid',pager_selector,
                {
                    edit:false,
                    add:false,
                    del:false,
                    refresh: true,
                    refreshicon : 'ace-icon fa fa-refresh green'
                }
        );



        function operateFormatter(cellvalue, options, rowObject) {
           return "<a >修改</a>&nbsp;<a >删除</a>";
        }



        //replace icons with FontAwesome icons like above
        function updatePagerIcons(table) {
            var replacement =
                    {
                        'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
                        'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
                        'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
                        'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
                    };
            $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
                var icon = $(this);
                var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

                if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
            })
        }

        function enableTooltips(table) {
            $('.navtable .ui-pg-button').tooltip({container:'body'});
            $(table).find('.ui-pg-div').tooltip({container:'body'});
        }

        //var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');

        $(document).one('ajaxloadstart.page', function(e) {
            $.jgrid.gridDestroy(grid_selector);
            $('.ui-jqdialog').remove();
        });


        $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
            _title: function(title) {
                var $title = this.options.title || '&nbsp;'
                if( ("title_html" in this.options) && this.options.title_html == true )
                    title.html($title);
                else title.text($title);
            }
        }));

        $( "#add_user" ).on('click', function(e) {
            e.preventDefault();

            var dialog = $( "#dialog" ).load("${ctx}/sysuser/add").dialog({
                modal: true,
                title: "<div class='widget-header widget-header-small'><h4 class='smaller'>添加用户</h4></div>",
                title_html:true,
                buttons: [

                    {
                        text: "保存",
                        "class" : "btn btn-primary btn-minier",
                        click: function() {
                            $( this ).dialog( "close" );
                        }
                    },
                    {
                        text: "取消",
                        "class" : "btn btn-minier",
                        click: function() {
                            $( this ).dialog( "close" );
                            $( this ).dialog( "destroy" );
                            $( "#dialog" ).html("");
                        }
                    }
                ]
            });

            /**
             dialog.data( "uiDialog" )._title = function(title) {
						title.html( this.options.title );
					};
             **/
        });
    });
</script>
<#include "../common/body_bottom.ftl"/>
