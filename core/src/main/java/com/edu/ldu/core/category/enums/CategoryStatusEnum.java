package com.edu.ldu.core.category.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 分类状态
 *
 * @author yanmengjie
 * 2018/3/11
 */
public enum CategoryStatusEnum {

    /**
     * 正常
     */
    NORMAL("正常"),
    /**
     * 删除
     */
    DELETE("删除");
    private final String str;

    CategoryStatusEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public static Map<String, String> getStatusMap() {
        Map<String, String> map = new HashMap<>();
        for (CategoryStatusEnum status : CategoryStatusEnum.values()) {
            map.put(status.name(), status.getStr());
        }
        return map;
    }
}