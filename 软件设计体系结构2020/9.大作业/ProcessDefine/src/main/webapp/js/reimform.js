var reimObj;

function deleteForm(obj) {
    $.ajax({
        type: "GET",
        url: path + "/jsp/reimbursement/reimform.do",
        data: {method: "delform", id: obj.attr("formid")},
        dataType: "json",
        success: function (data) {
            if (data.delResult == "true") {//删除成功：移除删除行
                changeDLGContent("删除成功");
                cancleBtn();
                obj.parents("tr").remove();
            } else if (data.delResult == "false") { //删除失败
                changeDLGContent("对不起，删除【" + obj.attr("formid") + "】失败");
            } else if (data.delResult == "notexist") {
                changeDLGContent("对不起，【" + obj.attr("formid") + "】不存在");
            }
        },
        error: function (data) {
            alert("对不起，删除失败");
        }
    });
}

function openYesOrNoDLG() {
    $('.zhezhao').css('display', 'block');
    $('#removeForm').fadeIn();
}

function cancleBtn() {
    $('.zhezhao').css('display', 'none');
    $('#removeForm').fadeOut();
}

function changeDLGContent(contentStr) {
    var p = $(".removeMain").find("p");
    p.html(contentStr);
}

$(function () {
    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        deleteForm(reimObj);
    });

    $(".deleteForm").on("click", function () {
        reimObj = $(this);
        changeDLGContent("你确定要删除【" + reimObj.attr("formid") + "】吗？");
        openYesOrNoDLG();
    });
});