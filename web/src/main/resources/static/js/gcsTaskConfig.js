function updateGcsTaskConfig(){
    $.get("/finGcsTaskConfig",function(data){
          //添加数据
          $("#configId").val(data.id);
          $("#configTime").val(data.createTime);
          $("#luaUrl").val(data.luaUrl);
          $("#runTimeMax").val(data.runTimeMax);
          $("#configState").val(data.state);
          $("#version").val(data.version);
    },"json")
}