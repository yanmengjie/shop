package com.edu.ldu.core.common.constant;

import java.math.BigDecimal;

/**
 * description:
 *
 * @author 唐全成
 * @date 2018/2/8
 */
public class Constants {
    /**
     * 默认余额预警值
     */
    public static BigDecimal DEFAULT_THRESHOLD=new BigDecimal(100);
    public static final String HEADERS ="accept, content-type";
    public static final String METHOD_GET = "GET";
    public static final String ORIGIN = "http://172.16.0.165:8068";
    public static final String STRING_TRUE = "true";
    /**
     * 公钥
     */
    public static final String PUBLIC_KEY="public_key";
    /**
     * 私钥
     */
    public static final String PRIVATE_KEY="private_key";
    /**
     * 随机字符串
     */
    public static final String RANDOM_STR="random_str";
    /**
     * 平台key
     * 用于账户密码、支付密码的加密（与盐值组合）
     */
    public static final String APP_KEY="decent_marketing";
    /**
     * 默认管理员密码
     */
    public static final String DEFAULT_ADMIN_PWD="a123456";
    /**
     * 默认请求参数异常的返回消息
     */
    public static final String DEFAULT_PARAM_ERROR_MSG="请求参数不合法";
    /**
     * 短信消息订单前缀
     */
    public static final String SMS_ORDER_PREFIX="SMS";
    /**
     * 流量充值订单前缀
     */
    public static final String MLL_ORDER_PREFIX="MLL";
    /**
     * 常用成功返回码
     */
    public static final String COMMON_SUCCESS_CODE="0000";
    /**
     * 短成功返回码（米流量）
     */
    public static final String MLL_SUCCESS_CODE="0";
    /**
     * 通用编码格式
     */
    public static final String CHARSET="UTF-8";

}
