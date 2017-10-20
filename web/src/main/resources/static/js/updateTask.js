function updateTask(id){
    var groupId=0 ;
      $.get("/findOneTask",{"id":id},function(data){
            $("#taskid").val(data.id);
            $("#apkUrl").val(data.apkUrl);
            $("#appName").val(data.appName);
            $("#findSet").val(data.findSet);
            $("#marketPackName").val(data.marketPackName);
            $("#marketUrl").val(data.marketUrl);
            $("#packageName").val(data.packageName);
            $("#runNumber").val(data.runNumber);
            $("#searchTxt").val(data.searchTxt);
            $("#taskMode").val(data.taskMode);
            if(data.taskModeCode=="1"){
                $("#cpa").attr("selected","seleced")
            }else if(data.taskModeCode=="2"){
                $("#market").attr("selected","seleced")
            }
            $("#taskModeCode").val(data.taskModeCode);
            if (data.taskStatus==0){
                $("#off").attr("selected","seleced")
            }else if (data.taskStatus==1){
                $("#on").attr("selected","seleced")
            }
            $("#weight").val(data.weight);
            $("#remainCurveId").val(data.remainCurveId);
            $("#machineIds").val(data.machineIds);
            $("#newAddRemainCurveId").val(data.newAddRemainCurveId);
            $("#nichijouRemainCurveId").val(data.nichijouRemainCurveId);
            $("#taskCount").val(data.taskCount);
            groupId=data.group.id;
          getGroups(groupId)
      });

}
function getGroups(groupId) {
    $.get("/findGroups",function (data) {
        var str = "";
        $.each(data ,function (index) {
            if(data[index].id==groupId){
                var append = "<option selected='selected' value='"+data[index].id+"'>"+data[index].groupName+"</option>"
                str+=append;
            }else{
                var append = "<option value='"+data[index].id+"'>"+data[index].groupName+"</option>"
                str+=append;
            }
        })
        $("#groups").empty();
        $("#groups").append(str);
        $("#updateGroup").empty();
        $("#updateGroup").append(str);
    })
}

