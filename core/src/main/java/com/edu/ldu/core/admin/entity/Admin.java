package com.edu.ldu.core.admin.entity;

import com.edu.ldu.core.common.enums.CommonStatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author yanmengjie
 * 2018/3/11
 */
@Data()
public class Admin {
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 职务
     */
    private Integer dutyId;
    /**
     * 手机号
     */
    private String phoneNo;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;
    /**
     * 盐值
     */
    private String saltValue;
    /**
     * 状态
     */
    private CommonStatusEnum status;

    /**
     * 是否是超级管理员(0否1是)
     */
    private boolean isSuperAdmin;
}