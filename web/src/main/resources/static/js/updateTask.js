function updateTask(id){
      $.get("/findOneTask",{"id":id},function(data){
          $("#updateGroup").empty();
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
            $("#taskModeCode").val(data.taskModeCode);
            $("#taskStatus").val(data.taskStatus);
            $("#weight").val(data.weight);
            $("#remainCurveId").val(data.remainCurveId);
            $("#machineIds").val(data.machineIds);
            $("#newAddRemainCurveId").val(data.newAddRemainCurveId);
            $("#nichijouRemainCurveId").val(data.nichijouRemainCurveId);
            $("#taskCount").val(data.taskCount);
            console.log(data)
            var str ="<option value='"+data.group.id+"'>"+data.group.groupName+"</option>";


          $("#updateGroup").append(str);
      });
}
function getGroups(){
      var str = "";
      $.get("/findGroups",function (data) {
          $.each(data ,function (index) {
              var append = "<option value='"+data[index].id+"'>"+data[index].groupName+"</option>"
              str+=append;
          })
          $("#groups").empty();
          $("#groups").append(str);
          $("#updateGroup").empty();
          $("#updateGroup").append(str);
      })
}