package com.edu.ldu.core.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanmengjie
 * 2018/3/11
 */
public enum CommonStatusEnum {
    /**
     * 正常
     */
    NORMAL("正常"),
    /**
     * 已冻结
     */
    FROZEN("已冻结"),
    /**
     * 已注销
     */
    WRITTEN_OFF("已注销"),
    /**
     * 删除标示
     */
    DELETED("已删除");
    private final String str;

    CommonStatusEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public static Map<String, String> getStatusMap() {
        Map<String, String> map = new HashMap<>();
        for (CommonStatusEnum status : CommonStatusEnum.values()) {
            map.put(status.name(), status.getStr());
        }
        return map;
    }
}