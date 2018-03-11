/**
 * Created by dxkj on 2017/5/3.
 */
//通用状态
var commenStatus = {
    "NORMAL": '<span style="color: green">正常</span>',
    "FREEZE": '<span style="color: red">冻结</span>'
}
//订单状态
var orderStatus = {
    "SUCCESS": '<span style="color: green">成功</span>',
    "FAIL": '<span style="color: red">失败</span>'
}
//操作日志类型
var adminLogType = {
    0: '<span class="badge badge-success">新增</span>',
    1: '<span class="badge badge-warning">修改</span>',
    2: '<span class="badge badge-important">删除</span>',
    3: '<span class="badge badge-info">查询</span>'
}
//实名审核状态
var auditStatus = {
    0: '<span class="label  label-warning">待审核</span>',
    1: '<span class="label  label-success">已通过</span>',
    2: '<span class="label  label-important">未通过</span>'
}
var userStatus = {
    'TO_AUDITED': '<span class="label  label-success">待审核</span>',
    'NORMAL': '<span class="label  label-success">正常</span>',
    'FROZEN': '<span class="label  label-warning">已冻结</span>',
    'WRITTEN_OFF': '<span class="label  label-important">已注销</span>'
}
var certificationStatus = {
    'UN_CERTIFIED': '<span class="label  label-primary">未认证</span>',
    'CERTIFIED': '<span class="label  label-success">已认证</span>'
}
var activityType = {
    'ATTRACT_FANS': '<span class="label  label-success">微信吸粉</span>',
    'INTERVIEW': '<span class="label  label-warning">问卷调查</span>'
}

var activityStatus = {
    'INITIALIZING': '<span class="label  label-default">初始化中</span>',
    'BEFORE_START': '<span class="label  label-blue">未开始</span>',
    'ONGOING': '<span class="label  label-success">进行中</span>',
    'LACK_PRIZE': '<span class="label  label-important">缺少奖品</span>',
    'FINISHED': '<span class="label  label-gray">已结束</span>'
}
//消息状态
var MsgStatus = {
    "UN_PUBLISHED": '<span style="color: red">未发布</span>',
    "PUBLISHED": '<span style="color: green">已发布</span>'
}
//消息类型
var MsgType = {
    "ORDINARY": '<span style="color: green">普通</span>',
    "URGENT": '<span style="color: red">紧急</span>'
}
var rechargeType = {
    "ZFB": '<span class="label recharge-zfb recharge-type"></span>',
    "ALLIN_PAY": '<span class="label recharge-tlzf recharge-type"></span>',
    "CFT": '<span class="label recharge-cft recharge-type"></span>'
}
var rechargeWay = {
    "ONLINE": '<span style="color: green">线上</span>',
    "OFFLINE": '<span style="color: blue">线下</span>'
}
var rechargeStatus = {
    "CHECKING": '<span style="color: blue">待审核</span>',
    "ABNORMAL": '<span style="color: orange">异常</span>',
    "SUCCESS": '<span style="color: green">成功</span>',
    "FAIL": '<span style="color: red">失败</span>'
}

//产品状态
var productStatus = {
    "ON": '<span style="color: green">上架</span>',
    "OFF": '<span style="color: red">下架</span>',
    "DELETE": '<span>删除</span>'


}

//产品类型
var productType = {

    "FLOW": '<span>流量</span>',
    "BILL": '<span>话费</span>',
    "TENCENT": '<span>腾讯产品</span>',
    "SERVICE": '<span>服务</span>'

}

//产品范围
var productArea = {
    "PROVINCIAL": '<span style="color: green">省内</span>',
    "DOMESTIC": '<span style="color: blue">全国</span>'

}

//生效类型
var effectTime = {

    "IMMEDIATE": '<span style="color: green">即时生效</span>',
    "FOLLOWING_DAY": '<span style="color: blue">次日生效</span>',
    "FOLLOWING_MONTH": '<span style="color: red">次月生效</span>'
}
//流量有效期
var flowValidity = {

    0: '<span style="color: green">当月有效</span>',
    1: '<span style="color: blue">其他</span>'

}


//活动记录状态
var partakeRecordStatus = {

    "SUCCESS": '<span style="color: green">参与成功</span>',
    "NOAWARD": '<span style="color: red">奖品已领完</span>'

}