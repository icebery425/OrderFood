define(function (require, exports, module) {
    //模块依赖
    require('echarts');
    var obj = {
        init: function () {
            obj.a();
            obj.b();
        },
        //x轴可拖动,demo1
        a:function () {
            // 基于准备好的dom，初始化echarts图表
            var myChart = echarts.init(document.getElementById('echarts-bar-chart'), 'macarons');
            /*macarons为可选主题*/

            // 过渡---------------------
            myChart.showLoading({
                text: '正在努力的读取数据中...',    //loading
            });

            //                    参数配置
            var option = {
                //                        鼠标悬浮交互时的信息提示
                tooltip: {
                    trigger: 'axis'
                },
                //                        图例,最多一个
                legend: {
                    data: ['最高', '最低']
                },
                //                        工具箱,最多一个
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        dataZoom: {show: true},
                        dataView: {show: true},
                        magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                dataZoom: {
                    show: true,
                    realtime: true,
                    start: 20,
                    end: 80
                },
                //                        x轴区间
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: function () {
                            var list = [];
                            for (var i = 1; i <= 30; i++) {
                                list.push('2013-03-' + i);
                            }
                            return list;
                        }()
                    }
                ],
                //                        y轴
                yAxis: [
                    {
                        type: 'value'
                    },
                    {
                        type: 'value',
                        name: '温度',
                        axisLabel: {
                            formatter: '{value} °C'
                        }
                    }
                ],
                //                        y轴随机数模拟
                series: [
                    {
                        name: '最高',
                        type: 'line',
                        data: function () {
                            var list = [];
                            for (var i = 1; i <= 30; i++) {
                                list.push(Math.round(Math.random() * 30));
                            }
                            return list;
                        }()
                    },
                    {
                        name: '最低',
                        type: 'line',
                        data: function () {
                            var list = [];
                            for (var i = 1; i <= 30; i++) {
                                list.push(Math.round(Math.random() * 10));
                            }
                            return list;
                        }()
                    }
                ]
            };
    //                    模拟请求阻塞
            setTimeout(function () {
                // ajax getting data...............

                // ajax callback
                myChart.hideLoading();
                // 为echarts对象加载数据
                myChart.setOption(option);
            }, 1000)
        },
        //混合,demo2
        b:function(){
            var myChart = echarts.init(document.getElementById('echarts-mix-chart'), 'macarons');
            var option = {
                //鼠标悬浮提示
                tooltip : {
                    trigger: 'axis'
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                //拖拽重计算,默认false
                calculable : true,
                //图例,图标中上部分
                legend: {
                    data:['蒸发量','降水量','平均温度']
                },
                //x轴坐标
                xAxis : [
                    //数组中每一项代表一条横轴坐标轴，仅有一条时可省略数组，最多同时存在2条
                    {
                        type : 'category',
                        data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                    },
                    //{
                    //    type : 'category',
                    //    data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','13月']
                    //}
                ],
                //y轴坐标
                yAxis : [
                    {
                        type : 'value',
                        name : '水量',
                        axisLabel : {
                            formatter: '{value} ml'
                        }
                    },
                    {
                        type : 'value',
                        name : '温度',
                        axisLabel : {
                            formatter: '{value} °C'
                        }
                    }
                ],
                series : [

                    {
                        name:'蒸发量',
                        type:'bar',
                        data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
                    },
                    {
                        name:'降水量',
                        type:'bar',
                        data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                    },
                    {
                        name:'平均温度',
                        type:'line',
                        yAxisIndex: 1,
                        data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
                    },
                    {
                        name:'平均温度',
                        type:'line',
                        yAxisIndex: 1,
                        data:[2.0, 2.2, 3.3, 4.5, 6.5, 12, 26, 23.4, 23.0, 16.5, 12.0, 6.2]
                    }
                ]
            };
            myChart.setOption(option);
        }
    }
    //接口暴露
    module.exports = {
        a:obj.init,
        b:obj.init
    }
});