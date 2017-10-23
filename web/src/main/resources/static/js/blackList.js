function findOneBlack(id) {
    $.get("/findOneBlack",{"id":id},function (data) {
        $("#blackId").val(data.id);
        $("#blackName").val(data.blackName)
    });
}