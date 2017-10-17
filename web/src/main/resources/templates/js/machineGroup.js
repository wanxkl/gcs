function getMachines() {
    $.get("/findMachines",function (data) {
        var str = "";
        $.each(data,function (index) {
            str+="<input type='checkbox' name='id' value='data[index].id'></input>"
        })
        $("#machines").append(str)
    });
}