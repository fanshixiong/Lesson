var reimid = null;
var reason = null;
var addBtn = null;
var backBtn = null;



$(function () {
    reimid = $("#id");
    reason = $("#reason");
    addBtn = $("#add");
    backBtn = $("#back");
    //初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
    reimid.next().html("*");
    reason.next().html("*");
    /*
     * 验证
     * 失焦\获焦
     * jquery的方法传递
     */
    reimid.on("blur", function () {
        if (reimid.val() != null && reimid.val() != "") {
            validateTip(reimid.next(), {"color": "green"}, imgYes, true);
        } else {
            validateTip(reimid.next(), {"color": "red"}, imgNo + " 不能为空，请重新输入", false);
        }
    }).on("focus", function () {
        //显示友情提示
        validateTip(reimid.next(), {"color": "#666666"}, "* 请输入申请单编号", false);
    }).focus();

    reason.on("focus", function () {
        validateTip(reason.next(), {"color": "#666666"}, "* 请输入申请理由", false);
    }).on("blur", function () {
        if (reason.val() != null && reason.val() != "") {
            validateTip(reason.next(), {"color": "green"}, imgYes, true);
        } else {
            validateTip(reason.next(), {"color": "red"}, imgNo + " 理由不能为空，请重新输入", false);
        }

    });




    addBtn.on("click", function () {
        if (reimid.attr("validateStatus") != "true") {
            reimid.blur();
        } else if (reason.attr("validateStatus") != "true") {
            reason.blur();
        } else {
            if (confirm("是否确认提交数据")) {
                $("#leaveForm").submit();
            }
        }
    });

    backBtn.on("click", function () {
        if (referer != undefined
            && null != referer
            && "" != referer
            && "null" != referer
            && referer.length > 4) {
            window.location.href = referer;
        } else {
            history.back(-1);
        }
    });
});