/**
 * Created by 0162673 on 2017/4/10.
 */
var bar = function(){
    'use strict'
    //datatables配置参数
    var dataTableParams = {
        "language": {
            processing: "玩命加载中...",
            lengthMenu: "显示 _MENU_ 项结果",
            zeroRecords: "没有匹配结果",
            info: "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            infoEmpty: "显示第 0 至 0 项结果，共 0 项",
            infoFiltered: "(由 _MAX_ 项结果过滤)",
            infoPostFix: "",
            search: "搜索:",
            url: "",
            paginate: {
                first: "首页",
                previous: "上页",
                next: "下页",
                last: "末页"
            }
        },
        searching: false,
        bDestroy: true,
        lengthChange: false,
        //scrollX: 1300,
        responsive: true
    }

    //插件
    var pluginsInit = {
        selectpicker: function (opt) {
            //bootstrap-select
            $('.selectpicker').selectpicker($.extend({
                'selectedText': 'cat',
            }, opt));
        },
        layerExportTable: function () {
            var exportTableHtml = template("tpl-exportTable", {});
            layer.open({
                type: 1 //Page层类型
                , area: ['300px', '150px']
                , title: '请选择导出报表类型'
                , shade: 0.6 //遮罩透明度
                , maxmin: false //允许全屏最小化
                , content: exportTableHtml,
                btn: ['确定', '取消'], //按钮
            });

        },
        datePick: function (opt) {
            //wdatePicker
            return utilFn.dataPickerOpt(opt);
        }
    };

    //通用方法
    var utilFn = {
        //当天前一天
        dateDiv: function (startDate) {
            startDate = new Date(startDate);
            startDate = startDate - 1000 * 60 * 60 * 24;
            startDate = new Date(startDate);
            var nextStartDate = startDate.getFullYear() + "-" + (startDate.getMonth() + 1) + "-" + startDate.getDate();
            return nextStartDate;
        },
        dateToday: function () {
            //当天
            var startDate = new Date();
            var nextStartDate = startDate.getFullYear() + "-" + (startDate.getMonth() + 1) + "-" + startDate.getDate();
            return nextStartDate;
        },
        dateMinute: function () {
            //2017/4/7 13:12
            var startDate = new Date();
            var nextStartDate = startDate.getFullYear() + "/" + (startDate.getMonth() + 1) + "/" + startDate.getDate() + " " + startDate.getHours() + ":" + startDate.getMinutes();
            return nextStartDate;
        },
        dataPickerOpt: function (opt) {
            //dataPicker参数
            var defaults = {
                //maxDate:'%y-%M-%d',
                firstDayOfWeek: 1,
                readOnly: true,
                isShowClear: false,
                $crossFrame: false,
                startDate: utilFn.dateDiv(new Date())
            }
            opt = $.extend(defaults, opt);
            return opt;
        }
    };

    //事件绑定
    var  BindEvent = function() {
        //添加title属性
        $('td,th').each(function () {
            var $this = $(this);
            $this.attr('title', $this.text())
        })

        //初始化显示时间默认值
        $('#inputDate01').val(utilFn.dateDiv(new Date()))
        $('#inputDate1').val(utilFn.dateDiv(new Date()))

        //导出excel
        $('#exportTable').click(function () {
            pluginsInit.layerExportTable()
        })

        //集团财务
        //初始化时间
        //$('#inputDate1').attr('onfocus', "WdatePicker(pluginsInit.datePick({startDate:utilFn.dateToday()}))");
        //初始化表格
        $('#example').DataTable(dataTableParams);
        $('.nav-tabs').on('click', 'li', function () {
            if ($(this).index() == 0) {
                $('#inputDate1').attr('onfocus', "WdatePicker(pluginsInit.datePick())");
            }
            if ($(this).index() == 1) {
                $('#inputDate1').attr('onfocus', "WdatePicker(pluginsInit.datePick({dateFmt:'yyyy-MM'}))");
                var now = new Date();
                $('#inputDate1').val(now.getFullYear() + '-' + (now.getMonth() + 1));
                setTimeout(function () {
                    $('#example2').DataTable(dataTableParams);
                }, 0)

            } else if ($(this).index() == 2) {
                $('#inputDate1').attr('onfocus', "WdatePicker(pluginsInit.datePick({dateFmt:'yyyy'}))");
                $('#inputDate1').val(new Date().getFullYear());
                setTimeout(function () {
                    $('#example3').DataTable(dataTableParams);
                }, 0)
            }
        })

        //地区财务
        //初始化时间
        $('#inputDate1').attr('onfocus', "WdatePicker(pluginsInit.datePick())");
        //初始化第一个表格
        var t = $('#example').DataTable(dataTableParams);
        //tab切换表格
        $('.nav-tabs').on('click', 'li', function (e) {
            if ($(this).index() == 1) {
                //切换时间格式为年
                $('#inputDate1').attr('onfocus', "WdatePicker(pluginsInit.datePick({dateFmt:'yyyy'}))");
                $('#inputDate1').val(new Date().getFullYear())
                $('#showIfDay').hide();
                setTimeout(function () {
                    //初始化第二个表格
                    $('#example3').DataTable(dataTableParams);
                }, 0)
            } else {
                $('#inputDate1').attr('onfocus', "WdatePicker(pluginsInit.datePick())");
                $('#showIfDay').show();

            }
        })
        //今日填报
        $('#fillToday').on('click', function () {
            //弹出填表弹框
            var obj = {
                list: [{}]
            }
            var editHtml = template("tpl-edit", obj);
            layer.open({
                type: 1,
                area: ['800px', '700px'],
                title: '创收回款修改',
                shade: 0.6,
                maxmin: true,
                content: editHtml,
                btn: ['完成修改', '取消'], //按钮
                yes: function () {
                    var arr = [
                        $('#layerDate').val(),
                        $('#layerRegion').val(),
                        $('#layerDaili').val(),
                        $('#layerCunliang').val(),
                        $('#layerFanglianbao').val(),
                        $('#layerYewu').val(),
                        $('#layerZhuangxiu').val(),
                        $('#layerGongshang').val(),
                        $('#layerGuwen').val(),
                        $('#layerGongyu').val(),
                        $('#layerJinrong').val(),
                        $('#layerXiaoyang').val(),
                        $('#layerXiaoji').val(),
                        $('#layerHuiDaili').val(),
                        $('#layerHuiGuwen').val(),
                        '<a href="javascript:;" class="editTable">修改</a>'
                    ]
                    layer.closeAll();
                    t.row.add(
                        arr
                    ).draw();
                }
            });
            //初始化地区选择
            pluginsInit.selectpicker({
                'noneSelectedText': '龙岗'
            });

        });
        //layer 修改表格
        //编辑表格
        $('table').on('click', '.editTable', function () {
            //保存this
            var $this = $(this);
            var $td = $(this).closest('tr').find('td');
            var tmpArr = [];
            $td.each(function (index, item) {
                var $text = $(item).text();
                if ($text == '删除' || $text == '修改') {
                    return;
                }
                tmpArr.push($text);
            })
            var data = tmpArr || {};
            var obj = {
                list: [data]
            }
            var editHtml = template("tpl-edit", obj);
            //layer
            layer.open({
                type: 1,
                area: ['800px', '700px'],
                title: '创收回款修改',
                shade: 0.6,
                maxmin: true,
                content: editHtml,
                btn: ['完成修改', '取消'], //按钮
                yes: function () {
                    var arr = [
                        $('#layerDate').val(),
                        $('#layerRegion').val(),
                        $('#layerDaili').val(),
                        $('#layerCunliang').val(),
                        $('#layerFanglianbao').val(),
                        $('#layerYewu').val(),
                        $('#layerZhuangxiu').val(),
                        $('#layerGongshang').val(),
                        $('#layerGuwen').val(),
                        $('#layerGongyu').val(),
                        $('#layerJinrong').val(),
                        $('#layerXiaoyang').val(),
                        $('#layerXiaoji').val(),
                        $('#layerHuiDaili').val(),
                        $('#layerHuiGuwen').val(),
                    ]
                    layer.closeAll();
                    var $td = $this.closest('tr').find('td');
                    //修改表格
                    $td.each(function (index, item) {
                        $(item).text(arr[index]);
                    })
                }
            });
            pluginsInit.selectpicker();
        })

        //项目维护
        //编辑表格
        $('table').on('click', '.editProjectMaintenanceForm', function () {
            //保存this
            var $this = $(this);
            var $td = $(this).closest('tr').find('td');
            var tmpArr = [$td.eq(1).text(), $td.eq(2).text(), $td.eq(3).text(), $td.eq(4).text()];
            var data = tmpArr || {};
            var obj = {
                list: [data]
            }
            var editHtml = template("tpl-projectMaintenanceForm", obj);
            //layer
            layer.open({
                type: 1,
                area: ['400px', '320px'],
                title: '修改项目名称',
                shade: 0.6,
                maxmin: true,
                content: editHtml,
                btn: ['完成修改', '取消'], //按钮
                yes: function () {
                    var arr = [
                        $('#editCompany').val(),
                        $('#editBusinseeName').val(),
                        $('#editFinanceName').val(),
                        $('#editProjectName').val(),
                    ]
                    layer.closeAll();
                    var $td = $this.closest('tr').find('td');
                    //修改表格
                    $td.eq(1).text(arr[0]);
                    $td.eq(2).text(arr[1]);
                    $td.eq(3).text(arr[2]);
                    $td.eq(4).text(arr[3]);
                }
            });
        })

        //客户维护
        //编辑表格
        $('table').on('click', '.editCustomerMaintenanceForm', function () {
            //保存this
            var $this = $(this);
            var $td = $(this).closest('tr').find('td');
            var tmpArr = [$td.eq(1).text(), $td.eq(2).text()];
            var data = tmpArr || {};
            var obj = {
                list: [data]
            }
            var editHtml = template("tpl-CustomerMaintenanceForm", obj);
            //layer
            layer.open({
                type: 1,
                area: ['400px', '230px'],
                title: '修改客户信息',
                shade: 0.6,
                maxmin: true,
                content: editHtml,
                btn: ['完成修改', '取消'], //按钮
                yes: function () {
                    var arr = [
                        $('#editParentCustomer').val(),
                        $('#editCustomer').val(),
                    ]
                    layer.closeAll();
                    var $td = $this.closest('tr').find('td');
                    //修改表格
                    $td.eq(1).text(arr[0]);
                    $td.eq(2).text(arr[1]);
                }
            });
        })

        //项目客户关系维护
        //编辑表格
        $('table').on('click', '.editCRM', function () {
            //保存this
            var $this = $(this);
            var $td = $(this).closest('tr').find('td');
            var tmpArr = [$td.eq(2).text(), $td.eq(3).text(), $td.eq(4).text()];
            var data = tmpArr || {};
            var obj = {
                list: [data]
            }
            var editHtml = template("tpl-projectCRM", obj);
            //layer
            layer.open({
                type: 1,
                area: ['400px', '260px'],
                title: '修改项目客户映射关系',
                shade: 0.6,
                maxmin: true,
                content: editHtml,
                btn: ['完成修改', '取消'], //按钮
                yes: function () {
                    var arr = [
                        $('#editProjectName').val(),
                        $('#editCustomerName').val(),
                        $('#editParentcustomerName').val(),
                    ]
                    layer.closeAll();
                    var $td = $this.closest('tr').find('td');
                    if (arr.toString() == tmpArr.toString()) {
                        return;
                    }
                    //修改表格
                    $td.eq(2).text(arr[0]);
                    $td.eq(3).text(arr[1]);
                    $td.eq(4).text(arr[2]);
                    $td.eq(6).text(utilFn.dateMinute());
                }
            });
        })
    }

    var init = function () {
        BindEvent();
    }
    return {
        init: init,
    }
}();