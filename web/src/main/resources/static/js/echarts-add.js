$(function () {
    var lineChart = echarts.init(document.getElementById("echarts-line-chart"));
    var lineoption = {
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['新增用户']
        },
        grid:{
            x:40,
            x2:40,
            y2:24
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23']
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel : {
                    formatter: '{value}'
                }
            }
        ],

    };
    lineChart.setOption(lineoption);

    // 异步加载数据
    var time = $("#timeIn");
        var taskName = $("#taskName");
        console.log(time,"time","taskname",taskName);
        $.get("/countDayChart",{"time":time,"taskName":taskName},function(data){return data},"json").done(function (data) {
                // 填入数据
                console.log(data)
                lineChart.setOption({

                    series : [
                                {
                                    name:'新增用户',
                                    type:'line',
                                    data: data,
                                    markPoint : {
                                        data : [
                                            {type : 'max', name: '最大值'},
                                            {type : 'min', name: '最小值'}
                                        ]
                                    },
                                    markLine : {
                                        data : [
                                            {type : 'average', name: '平均值'}
                                        ]
                                    }
                                }
                            ]
             });

    $(window).resize(lineChart.resize);
});

});
