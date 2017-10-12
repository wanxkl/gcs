/*<div class="form-group">
    <lable class="col-sm-3 control-lable">曲线名称：</lable>
<div class="col-sm-7">
    <input class="form-control" name="remainName"/>
    </div>
    </div>*/
function getRemain(id) {
    console.log(id);
    $.get("/findRemain",{"id":id},function (data) {
        console.log(data)
        for(var i=0;i<data.length;i++){
            $("#updateForm")._append("<div class=\'form-group\'>" +
                "<lable class=\'col-sm-3 control-lable\'>曲线名称：</lable>" +
                "<div class=\'col-sm-7\'>" +
                "<input class=\'form-control\' name=\'remainName\' value=\'"+data.remainName+"\'/>" +
                "</div>" +
                "</div>");
        }
    },'json')
}