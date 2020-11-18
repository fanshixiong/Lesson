var reimObj;

function modifyForm(obj) {
    $.ajax({
        type: "GET",
        url: path + "/jsp/reimbursement/reimform.do",
        data: {method: "modify", id: obj.attr("formid"), formstate: obj.attr("formstate")},
        dataType: "json",
        success: function (data) {
            if (data.result == "true") {
                changeDLGContent("操作成功");
                cancleBtn();
                obj.parents("tr").remove();
            } else if (data.result == "false") {
                changeDLGContent("对不起，操作失败");
            }
        },
        error: function (data) {
            alert("对不起，操作失败");
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
        console.log(reimObj.attr("formstate"))
        modifyForm(reimObj)
    });

    $(".modifyForm").on("click", function () {
        reimObj = $(this);
        changeDLGContent("确定操作？");
        openYesOrNoDLG();
    });
});