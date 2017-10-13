/*<div class="form-group">
    <lable class="col-sm-3 control-lable">曲线名称：</lable>
<div class="col-sm-7">
    <input class="form-control" name="remainName"/>
    </div>
    </div>*/
function getRemain(id) {
    $.get("/findRemain",{"id":id},function (data) {
        $("#updateForm").empty();
        console.log(data.id)
        $("#updateForm").append("<div class=\'form-group\'>" +
            "<lable class=\'col-sm-3 control-lable\'>曲线名称：</lable>" +
            "<div class=\'col-sm-7\'>" +
            "<input class=\'form-control\' name=\'remainName\'  value=\'"+data.remainName+"\'/>" +
            "</div>" +
            "</div>");
        $("#updateForm").append("<div hidden class=\'form-group\'>" +
            "<lable class=\'col-sm-3 control-lable\'>id：</lable>" +
            "<div class=\'col-sm-7\'>" +
            "<input type='hidden' class=\'form-control\' name=\'id\' value=\'"+data.id+"\'/>" +
            "</div>" +
            "</div>");
        $("#updateForm").append("<div hidden class=\'form-group\'>" +
            "<lable class=\'col-sm-3 control-lable\'>remainType：</lable>" +
            "<div class=\'col-sm-7\'>" +
            "<input type='hidden' class=\'form-control\' name=\'remainType\' value=\'"+data.remainType+"\'/>" +
            "</div>" +
            "</div>");
        var arr = data.remainCurveDetails;
        console.log(arr);
        $.each(arr,function (index) {
            console.log("each",arr[index].distance," --",arr[index].percent)
            $("#updateForm").append("<div class=\'form-group\'>" +
                "<lable class=\'col-sm-3 control-lable\'>时间"+arr[index].distance+"：</lable>" +
                "<div class=\'col-sm-7\'>" +
                "<input class=\'form-control\' name=\'percent\' value=\'"+arr[index].percent+"\'/>" +
                "</div>" +
                "</div>");
        });
        $("#updateForm").append("<div class=\'form-group\'>" +
            "<input class=\'form-control\'type=\'submit\'  value=\'修改\'/>" +
            "</div>");
    },'json')
}