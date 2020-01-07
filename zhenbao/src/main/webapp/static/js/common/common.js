var newVar = (function ($) {
    var default_settings = {
        //开启服务器模式
        "bServerSide": true,
        //开启分页功能
        "bPaginate": true,
        /*"pagingType": "full_numbers",*/
        "aaSorting": [[0, 'desc']],
        //是否显示处理状态(排序的时候，数据很多耗费时间长的话，也会显示这个)
        "bProcessing": true,
        "aLengthMenu": [[10, 25, 50, 100], [10, 25, 50, 100]],
        //控制是否显示表格左下角的信息 共多少记录，多少页等
        "bInfo": true,
        //分页样式
        "sPaginationType": "full_numbers",
        //开启筛选功能，右上角的框框
        "bFilter": false,
        //是否允许用户改变表格每页显示的记录数
        "bLengthChange": true,
        //保存状态 - 在页面重新加载的时候恢复状态（页码等内容）
        "bStateSave": true,
        "sDom": "<'row'<'col-sm-6'l><'col-sm-6'f>r>t<'row'<'col-sm-6'i><'col-sm-6'p>>",
        "oLanguage": {
            "sLengthMenu": "每页_MENU_ 条",
            "sZeroRecords": "抱歉， 没有找到",
            "sInfo": "总"+"<font color='#FF0000' style='font-weight:bold;'> "+"_TOTAL_"+"</font>"+" 条记录 / 共"+"<font color='#FF0000' style='font-weight:bold;'> "+"_PAGENUM_"+"</font>"+" 页",
            "sInfoEmpty": "共 0 条数据/共 0 页",
            "sInfoFiltered": "(filtered from _MAX_ total records)",
            "sProcessing": "<table style='width:100%;height:100%'><tr><td valign='middle' align='center'><h2><i class='icon-spinner icon-spin'></i></h2></td></tr></table>",

            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页"
            }
        },
        "fnInitComplete": function () {
            $(this).css("width", "100%");
        },
        "fnDrawCallback": function (oSettings) {
            table = this;
            AutoWidth("#" + oSettings.sInstance, 0, oSettings.aoColumns.length - 1);

            $(this).find('tr>th').each(function () {
                content = $(this).html();
                $(this).html("<span style='white-space:nowrap;'>" + content + "</span>");

            });

            $(this).find('tr td:not(:has("*")):not(.dataTables_empty)').each(function () {
                var t = $(this).text();
                tdwidth = table.find("thead>tr>th").eq(this.cellIndex).css("width");
                $(this).html("<div originalwidth=" + tdwidth + " style='margin:0 auto;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;width:" + tdwidth + "'>" + t + "</div>");
            });
            //
            $('#redirect').keyup(function (e) {
                if ($(this).val() && $(this).val() > 0) {
                    var redirectpage = $(this).val() - 1;
                } else {
                    var redirectpage = 0;
                }
                table.fnPageChange(redirectpage);
            });
//				$("[data-toggle='popover']").popover();
        }
    };


    var methods = {
        "init": function (cfg) {
            var settings = $.extend(default_settings, cfg);
            if (settings['bServerSide'] && !settings.fnServerData && settings.paramSelector) {
                settings.fnServerData = function (sSource, aoData, fnCallback) {
                    $(settings.paramSelector).each(function () {
                        var name = $(this).attr("name");
                        var value = $(this).val();
                        name = name ? name : '';
                        value = value ? value : '';
                        aoData.push({
                            name: name,
                            value: value
                        });
                    });
                    $.ajax({
                        "type": "post",
                        "url": sSource,
                        "data": aoData,
                        "success": function (json) {
                            fnCallback(json);
                        },
                        "dataType": "json",
                        "cache": false,
                        "error": function (xhr, error, thrown) {
                            if ($.trim(xhr.responseText) == "{operror:900001}") {
                                Login();
                            } else if (error == "parsererror") {
                                alert("数据格式错误.");
                            }
                        }
                    });
                };
            }
            /*if(!settings['bServerSide']){
             settings.fnServerData = function(sSource, aoData, fnCallback) {};
             }*/

            if (settings['aaData']) {
                $.each(settings['aaData'], function (i, row) {
                    if (row) {
                        $.each(row, function (j, data) {
                            if (data == undefined || data == null) {
                                settings['aaData'][i][j] = '';
                            }
                        });
                    }
                });
            }
            return this.dataTable(settings);
        }
    };

    /*
         jQuery.fn === jQuery.prototype
         $.fn.method=function(){}的调用把方法扩展到了对象的prototype上，所以实例化一个jQuery对象的时候，它就具有了这些方法。

         在JavaScript中，prototype对象是实现面向对象的一个重要机制。prototype 属性使您有能力向对象添加属性和方法
         每个函数就是一个对象（Function），函数对象都有一个子对象 prototype对象，类是以函数的形式来定义的。prototype表示该函数的原型，也表示一个类的成员的集合。

         Array.prototype.slice.call(arguments,1)该语句涉及两个知识点。
         arguments是一个关键字，代表当前参数，在javascript中虽然arguments表面上以数组形式来表示，但实际上没有原生数组slice的功能，
         这里使用call方法算是对arguments对象不完整数组功能的修正。
         slice返回一个数组，该方法只有一个参数的情况下表示除去数组内的第一个元素。就本上下文而言，原数组的第一个参数是“事件名称”，
         具体像“click”,"render"般的字符串，其后的元素才是处理函数所接纳的参数列表。

         Array.prototype.slice.call(arguments)能将具有length属性的对象转成数组,比如：
             var a={length:2,0:'first',1:'second'};
             Array.prototype.slice.call(a); //["first", "second"]

             var a={length:2};
             Array.prototype.slice.call(a); //[undefined, undefined]
         slice有两个用法，一个是String.slice,一个是Array.slice，第一个返回的是字符串，第二个返回的是数组
         Array.prototype.slice.call(arguments)能够将arguments转成数组，那么就是arguments.toArray().slice();到这里，是不是就可以说
         Array.prototype.slice.call(arguments)的过程就是先将传入进来的第一个参数转为数组，再调用slice
         可以看出，call了后，就把当前函数推入所传参数的作用域中去了，不知道这样说对不对，但反正this就指向了所传进去的对象就肯定的了。
     */
    $.fn.myDataTable = function (method) {
        if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.myDataTable');
        }
    };
})(jQuery);

$(document).ready(function () {

    /**
     * 为页面中关闭按钮绑定关闭窗口事件
     */
    $(".closeWindow").click(function () {
        closeWindow(true);
    });

    /**
     * 给页面查询表单注册回车触发查询效果
     */
    $(".queryform input").keypress(function (event) {
        if (event.which == 13) {
            $("#btnquery").click();
        }
    });

    /**
     * 将页面选择框修改为带查询的单选或多选框
     */
    !!$(".chosen").length && $(".chosen").chosen({
        no_results_text: "未找到此选项",
        search_contains: true
    });

    /**
     * 将页面选择框修改为带查询的单选或多选框
     */
    !!$('.datapicker').length && $('.datapicker').datetimepicker({
        format: "yyyy-mm-dd hh:ii:ss",
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });

    /**
     * 初始化页面中需要拖动排序的元素
     */
    !!$(".sortable").length && $(".sortable").sortable();

    /**
     * 为表格页数输入框绑定回车查询
     */
    setTimeout(bindtablejump, 0);

    /**
     * 定义表单验证
     * 参数options 为自定义验证方式
     * 使用示例
     * $("#formid").myValidate({
     * 		debug : false,
     * 		name : function(){
     * 			if(验证通过){
     * 				return true;
     * 			}else{
     * 				return "提示信息";
     * 			}
     * 		}	
     * });
     *
     */
    $.fn.myValidate = function (options) {
        if (options.debug)return true;
        $(this).find(".form-group>label span.red").removeClass("red").attr("title", "");
        var html = "";
        $(this).find(".form-group>label").each(function () {
            var name = $(this).find(".coreData").attr("name");
            var text = "";
            if (eval("options." + name)) {
                text = eval("options." + name + "()");
                if (text === true) {
                    text = "";
                } else {
                    html += "<br/>" + text;
                }
            } else {
                var spanDom = $(this).find("span:first");
                if (spanDom.find("font") && spanDom.find("font").html() == "*" && spanDom.find("font").hasClass("red") && !$(this).find(".coreData").val()) {
                    var text = spanDom.text().replace("*", "").replace("：", "") + "不能为空！";
                    html += "<br/>" + text;
                } else if ($(this).find(".coreData").attr("regex")) {
                    var regex = eval("new RegExp(" + $(this).find(".coreData").attr("regex") + ")");
                    if (!(regex.test($(this).find(".coreData").val()))) {
                        var text = spanDom.text().replace("*", "").replace("：", "") + "格式不正确！";
                        html += "<br/>" + text;
                    }
                }
            }
            text && $(this).find("span:first").addClass("red").attr("title", text);
        });
        if (html) {
            layer.alert(html.substring(5));
            return false;
        } else {
            return true;
        }
    }

    /**
     * 自定义表单序列化
     * 使用示例
     * $("#formid").mySerialize();
     *
     */
    $.fn.mySerialize = function () {
        var serialization = "";
        var value;
        $(this).find(" .coreData").each(function () {
            var name = $(this).attr("name");
            if ($(this).is('img')) {
                value = $(this).attr('src');
                if (value == "undefined" || value == null) {
                    value = "";
                }
            } else {
                value = $(this).val();
            }
            serialization += "&" + name + "=" + encodeURIComponent(value);
        });
        return serialization.substring(1);
    }
});

/**
 * 表格页数输入框绑定回车触发查询
 */
function bindtablejump() {
    $(".jumpinput").keypress(function (e) {
        var number = $(".dataTables_paginate.paging_full_numbers > input").val();
        if (e.which == 13 && number != undefined) {  //判断是否单击的enter按键(回车键)
            $(".dataTables_paginate.paging_full_numbers > span.jumpbutton.paginate_button").click();
        }
    });
}
/**
 * 获取对象类型
 */
function getType(o) {
    var _t;
    return ((_t = typeof(o)) == "object" ? o == null && "null" || Object.prototype.toString.call(o).slice(8, -1) : _t).toLowerCase();
}
/**
 * 实现数组深拷贝
 */
function extend(destination, source) {
    for (var p in source) {
        if (getType(source[p]) == "array" || getType(source[p]) == "object") {
            destination[p] = getType(source[p]) == "array" ? [] : {};
            arguments.callee(destination[p], source[p]);
        }
        else {
            destination[p] = source[p];
        }
    }
}

/**
 * 测量文本字符串的宽度
 * 参数 fontSize 字体大小 text 文本内容
 * 返回文本所占屏幕宽度
 */
function textSize(fontSize, text) {
    var span = document.createElement("span");
    var width = span.offsetWidth;
    span.style.position = "fixed";
    span.style.left = "0";
    span.style.fontSize = fontSize;
    span.style.visibility = "hidden";
    document.body.appendChild(span);
    if (typeof span.textContent != "undefined")
        span.textContent = text;
    else span.innerText = text;
    width = span.offsetWidth - width;
    span.parentNode.removeChild(span);
    return width;
}

var width_old, wideindex = -1, widetimer;

/**
 * 给表格绑定双击触发展开效果
 * 给自定义mydatatables使用
 */
function AutoWidth(table, start, end) {
    $(table + ">tbody>tr>td").on('dblclick', function () {
        if (this.cellIndex >= start && this.cellIndex <= end) {
            wideindex = this.cellIndex;
            if ($(table + ">thead>tr>th").eq(wideindex).hasClass("wide")) {
                $(table + ">tbody>tr").each(function () {
                    $(this).find("td").eq(wideindex).find("div").width($(this).find("td").eq(wideindex).find("div").attr("originalwidth"));
                });
                $(table + ">thead>tr>th").eq(wideindex).removeClass("wide");
            } else {
                width_old = $(table + ">tbody>tr:eq(0)>td").eq(wideindex).find("div").width();
                var maxsize = 0;
                $(table + ">tbody>tr>td:nth-child(" + (wideindex + 1) + ")").each(function () {
                    //					$(this).css("border","solid red 1px");
                    FontSize = $(this).css("font-size");
                    content = $(this).text();
                    contentwidth = textSize(FontSize, content);
                    if (contentwidth > maxsize) {
                        maxsize = contentwidth;
                    }
                });
                if (maxsize > width_old) {
                    $(table + ">tbody>tr").each(function () {
                        $(this).find("td").eq(wideindex).find("div").width(maxsize + 20);
                    });
                    $(table + ">thead>tr>th").eq(wideindex).addClass("wide");
                }
            }
        }
    });

}


 /*//异步提交封装
 ajaxPost({
		url :"./deleteStaff.json",//请求url
		data:"id="+id, //请求参数
		success:function(result){
			//返回成功后，结果处理
		}
	});
 */


function myajaxPost(options) {
    var realOptions = {
        type: "POST",
        timeout: 100000,
        cache: false,
        error: function (request, textStatus, errorThrown) {

            if ($.trim(request.responseText) == "{operror:900001}") {
                Login();
            }

            try {
                var result = eval('({0})'.format(request.responseText));
                if (result) {
                    //showResult(result);
                } else {
                    //showError('请求发生错误！');
                }
            } catch (e) {
                //showError('请求发生错误！');
            }
        },
        async: true,
        dataType: "json",
        beforeSend: function (request) {

            request.setRequestHeader('jQueryAjaxRequest', 'true');

            if ($("#loading").length == 0) {
                var html = "<div id='loading' style='width:98%;height:98%;position:fixed;top:2%;filter:alpha(Opacity=50);-moz-opacity:0.5;opacity:0.5; background-color:#CCCCCC;'><center><i style='margin-top:20%;font-size:50px;' class='icon-spinner icon-spin'></i></center></div>";
                $("body").append(html);
            } else {
                $("#loading").show();
            }
        },
        complete: function (XMLHttpRequest, textStatus) {
            $("#loading").hide();
        },
        success: function (data) {
            try {
                if (data.message && data.message != null && data.message != "") {
                    alert(data.message);
                }
            } catch (e) {
            }
        }
    };
    $.extend(realOptions, options);
    $.ajax(realOptions);
}

/**
 * 判断字符串是否是合法的日期格式
 * @param str
 * @returns {Boolean}
 */
function isDate(str) {
    if (str.search(/^\d{4}-\d{1,2}-\d{1,2}$/) == 0) {
        var attr = str.split("-");
        var y = parseInt(attr[0], 10);
        var m = parseInt(attr[1], 10);
        var d = parseInt(attr[2], 10);
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (d > 31 || d == 0) {
                    return false;
                } else {
                    return true;
                }
                break;
            case 2:
                if ((y % 4 == 0 && (y % 400 == 0 || y % 100 != 0) && d > 29)
                    || (((y % 4 != 0 || y % 100 == 0 && y % 400 != 0) && d > 28))) {
                    return false;
                } else {
                    return true;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (d > 30) {
                    return false;
                } else {
                    return true;
                }
                break;
            default:
                return false;
        }
    } else {
        return false;
    }
}

/**
 * 判断值是否为空
 *
 * @param value
 * @returns {Boolean}
 */
function isNullOrEmpty(value) {
    return value == "" || value == undefined || value == null;
};

/**
 * 为数组增加indexOf方法
 */
Array.prototype.indexOf = function (obj) {
    for (var i = 0; i < this.length; i++) {
        if (obj == this[i]) {
            return i;
        }
    }
    return -1;
};

/**
 * 为数组增加indexOf方法
 */
Array.prototype.lastIndexOf = function (obj) {
    for (var i = this.length - 1; i >= 0; i--) {
        if (obj == this[i]) {
            return i;
        }
    }
    return -1;
};

/**
 * 日期时间格式化函数
 */
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, // month
        "d+": this.getDate(), // day
        "h+": this.getHours(), // hour
        "m+": this.getMinutes(), // minute
        "s+": this.getSeconds(), // second
        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
        "S": this.getMilliseconds()
        // millisecond
    };

    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
                : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};

/**
 * 页面超时自动跳转至登录页面
 */
function Login() {
    window.location.href = Global.webRoot + "/";
}

/**
 * js 获取日期函数
 */
function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate() + AddDayCount);// 获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth() + 1;// 获取当前月份的日期
    var d = dd.getDate();
    return y + '-' + (m > 9 ? m : "0" + m) + '-' + (d > 9 ? d : "0" + d);
}

/**
 * 设置cookie
 * @param name cookie的名子
 * @param value cookie的值
 */
function SetCookie(name, value) {
    var Days = 30; //此 cookie 将被保存 30 天
    var exp = new Date(); //new Date("December 31, 9998");
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=" + escape("/kcloud/");
}


/**
 * 读取cookie
 * @param name cookie的名字
 * @returns
 */
function getCookie(name) {
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null) return unescape(arr[2]);
    return null;

}

/**
 * 删除cookie
 * @param name
 */
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

/**
 * 给字符串绑定全部替换的方法
 */
String.prototype.replaceAll = function stringReplaceAll(AFindText, ARepText) {
    raRegExp = new RegExp(AFindText, "g");
    return this.replace(raRegExp, ARepText);
};

/**
 * 判断字符串是否为邮箱格式
 * @param str
 * @returns {Boolean}
 */
function isEmail(str) {
    var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if (reg.test(str)) {
        return true;
    } else {
        return false;
    }
}

/**
 * 对弹出层进行封装
 * @param config 自定义参数
 */
function myOpenWindow(config) {
    //屏幕分辨率
    var width = getMax(window.screen.width * 0.65, 700);
    var height = getMax(window.screen.height * 0.7, 530);
    //可见区宽度和高度
//	var width = getMax(document.body.clientWidth*0.7,700);
//	var height = getMax(document.body.clientHeight*0.8,530);

    layer.open($.extend({
        title: "自定义页面",
        type: 2,
        area: [width + 'px', height + 'px'],
//	    area: ['70%','80%' ],
        fix: false, //不固定
        maxmin: true
    }, config));
}

/**
 * @param v1
 * @param v2
 * @returns 返回两个参数的最大值
 */
function getMax(v1, v2) {
    return v1 > v2 ? v1 : v2;
}

/**
 * 关闭弹出层
 * @param isCancel 判断是否为取消关闭，或是保存成功关闭
 */
function closeWindow(isCancel) {
    var index = parent.layer.getFrameIndex(window.name);
    //必须在执行关闭之前执行
    if (!isCancel) {
        parent.layer.alert("保存成功！", 6);
    }
    parent.layer.close(index);
}

/**
 * 重载数据刷新table
 * 系统管理中用到
 * @param table 表对象
 * @param aaData 表数据
 */
function RefreshTable(table, aaData) {
    oSettings = table.fnSettings();
    table.fnClearTable();

    if (aaData != null) {
        for (var i = 0; i < aaData.length; i++) {
            table.oApi._fnAddData(oSettings, aaData[i]);
        }
    }

    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
    table.fnDraw();
}

function push(newsid, newstitle) {
    myOpenWindow({
        title: "新闻推送",
        closeBtn: 1,
        content: Global.webRoot + "/push?newsid=" + newsid + "&newstitle=" + newstitle
    });
}

window.alert = function (msg, callback) {
    layer.alert(msg, {closeBtn: 0}, function (index) {
        if (callback) {
            callback();
        }
        layer.close(index);
    });
};

window.confirm = function (msg, callback, cancelCallback) {
    layer.confirm(msg, {icon: 3}, callback, cancelCallback);
};