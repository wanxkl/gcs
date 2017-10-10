function updateGcsTaskConfig(){
    $.get("/finGcsTaskConfig",function(data){
          //添加数据
          $("#configId").val(data.id);
          $("#configTime").val(data.createTime);
          $("#luaUrl").val(data.luaUrl);
          $("#runTimeMax").val(data.runTimeMax);
          if(data.state==true){
            $("#configState option").eq(1).attr("selected",true);
          }else{
            $("#configState option").eq(0).attr("selected",true);
          }
          $("#version").val(data.version);
    },"json")
}