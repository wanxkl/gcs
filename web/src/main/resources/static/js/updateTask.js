function updateTask(id){

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
            $("#taskModeCode").val(data.taskModeCode);
            $("#taskStatus").val(data.taskStatus);
            $("#weight").val(data.weight);
            $("#remainCurveId").val(data.remainCurveId);
            $("#machineIds").val(data.machineIds);
            $("#newAddRemainCurveId").val(data.newAddRemainCurveId);
            $("#nichijouRemainCurveId").val(data.nichijouRemainCurveId);
            $("#taskCount").val(data.taskCount);
      });
}