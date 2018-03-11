/**
 * Created by dxkj on 2017/5/3.
 */
function add0(m) {
    return m < 10 ? '0' + m : m
}
//将时间戳转换为标准时间格式
function format(shijianchuo) {

    if (shijianchuo == null || shijianchuo == '') {
        return '-';
    }
//shijianchuo是整数，否则要parseInt转换
    var time = new Date(shijianchuo);
    var y = time.getFullYear();
    var m = time.getMonth() + 1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y + '-' + add0(m) + '-' + add0(d) + ' ' + add0(h) + ':' + add0(mm) + ':' + add0(s);
}
//确认提示插件关闭
function closeX0p() {
    var t="x0popup",y="x0p-overlay"
    var n = document.getElementById(t);
    null != n && n.parentNode.removeChild(n)
    var m = document.getElementById(y);
    null != m && m.parentNode.removeChild(m)
}
//搜索按钮响应回车事件
$(document).keydown(function (event) {
    if (event.keyCode == 13) {
        $("#searchData").click();
    }
});
//日期控件汉化文字
Flatpickr.l10n.weekdays.longhand = ['星期天', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
Flatpickr.l10n.weekdays.shorthand = [ '日','一', '二', '三', '四', '五', '六'];
Flatpickr.l10n.months.longhand = ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'];
function getDefaultStartTime() {
    var d=new Date();
    d.setHours(0);
    d.setMinutes(0);
    d.setSeconds(0)
    return d;
}
function getDefaultEndTime() {

    var d=new Date();
    d.setHours(23);
    d.setMinutes(59);
    d.setSeconds(59)
    return d;
}
// 手机号码验证
jQuery.validator.addMethod("isPhoneNo", function(value, element) {
    var tel = /^1[3|5|7|8|9][0-9]\d{8}$/;
    return this.optional(element) || (tel.test(value));
}, "请填写正确的手机号码");
// 身份证号验证
jQuery.validator.addMethod("idNoCheck",function (value, element) {
    var reg=/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/
    return this.optional(element) || (reg.test(value));
},"请输入正确的身份证号码");