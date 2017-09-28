// var $parentNode = window.parent.document;

// function $childNode(name) {
//     return window.frames[name]
// }

// // tooltips
// $('.tooltip-demo').tooltip({
//     selector: "[data-toggle=tooltip]",
//     container: "body"
// });

// // 使用animation.css修改Bootstrap Modal
// $('.modal').appendTo("body");

// $("[data-toggle=popover]").popover();


//判断当前页面是否在iframe中
if (top == this) {
    var gohome = '<div class="gohome"><a class="animated bounceInUp" href="index.html?v=4.0" title="返回首页"><i class="fa fa-home"></i></a></div>';
    $('body').append(gohome);
}

//animation.css
function animationHover(element, animation) {
    element = $(element);
    element.hover(
        function () {
            element.addClass('animated ' + animation);
        },
        function () {
            //动画完成之前移除class
            window.setTimeout(function () {
                element.removeClass('animated ' + animation);
            }, 2000);
        });
}

//拖动面板
function WinMove() {
    var element = "[class*=col]";
    var handle = ".ibox-title";
    var connect = "[class*=col]";
    $(element).sortable({
            handle: handle,
            connectWith: connect,
            tolerance: 'pointer',
            forcePlaceholderSize: true,
            opacity: 0.8,
        })
        .disableSelection();
};
function isNull(obj){
    if(obj.val()==null){
        console.log(obj.val())
    }
};
/*id INT(11) COMMENT '主键ID' NOT NULL AUTO_INCREMENT,
apk_url VARCHAR(64) COMMENT '任务APK下载地址' NOT NULL,
app_name VARCHAR(32) COMMENT '任务名称' NOT NULL,
machine_ids VARCHAR(1024) COMMENT '任务机器ID 空值为全部 ',
new_add_remain_curve_id INT(8) COMMENT '新增留存曲线ID' NOT NULL,
nichijou_remain_curve_id INT(8) COMMENT '日常留存曲线ID' NOT NULL,
package_name VARCHAR(32) COMMENT '任务包名(taskMode=cpa时不为空)',
 remain_curve_id INT(8) COMMENT '月留存曲线ID' NOT NULL,
 run_number INT(8) COMMENT '任务重试次数' NOT NULL,
 task_count INT(8) COMMENT '任务数量' NOT NULL,
 task_mode VARCHAR(64) COMMENT '任务类型名称' NOT NULL,
 task_mode_code INT(8) COMMENT '任务类型编码' NOT NULL,
 task_status INT(8) COMMENT '任务状态 0：暂停 1：启用 ' NOT NULL,
 find_set VARCHAR(1024) COMMENT '脚本辅助信息（taskMode=market时不为空)',
 market_pack_name VARCHAR(128) COMMENT '市场包名（taskMode=market时不为空)',
market_url VARCHAR(128) COMMENT '市场URL（taskMode=market时不为空)',
 search_txt VARCHAR(64) COMMENT '搜索关键字（taskMode=market时不为空)', */
 //字段检测

