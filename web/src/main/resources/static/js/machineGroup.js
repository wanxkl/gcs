function getMachines() {
    $.get("/findMachines",function (data) {
        var str = "";
        $.each(data,function (index) {
            str+="<span style='width: 15%' ><input style='width:10%;' type='checkbox' name='id' value='"+data[index].id+"'/><label style='width: 10%'>"+data[index].machineName+"</label></span>"
        })
        $("#machines").append(str)
    });
}