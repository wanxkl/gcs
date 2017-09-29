$("#timeIn").bootstrapDatepickr({
    format: 'yyyy-mm-dd',
    pickDate: true,
    pickTime: true,
    hourStep: 1,
    minuteStep: 15,
    secondStep: 30,
    todayHighlight: true,
    startDate:'2017-1-1',
    endDate:'2117-12-31'
});
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
     $(window).resize(lineChart.resize);
    // 异步加载数据
    var date = new Date();
    var year = date.getFullYear();
    var mm = date.getMonth()+1;
    var day = date.getDate();
    var timeInVal = year+"-"+mm+"-"+day;
    $("#timeIn").val(timeInVal);
    var time = $("#timeIn").val();
        var taskName = $("#taskName").val();
        console.log(time,"time","taskname",taskName);
        $.get("/countDayChart",{"timeIn":time,"taskName":taskName},function(data){return data},"json").done(function (data) {
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


    });

});
function clickAddChart(){
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
         $(window).resize(lineChart.resize);
        // 异步加载数据
        var date = new Date();
        var year = date.getFullYear();
        var mm = date.getMonth()+1;
        var day = date.getDate();
        var timeInVal = year+"-"+mm+"-"+day;
        $("#timeIn").val(timeInVal);
        var time = $("#timeIn").val();
            var taskName = $("#taskName").val();
            console.log(time,"time","taskname",taskName);
            $.get("/countDayChart",{"timeIn":time,"taskName":taskName},function(data){return data},"json").done(function (data) {
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


    });
}