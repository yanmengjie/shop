package com.edu.ldu.core.duty.service;

import com.edu.ldu.core.common.entity.Message;
import com.edu.ldu.core.duty.entity.Duty;

import java.util.List;

/**
 * @author yanmengjie
 * 2018/3/11
 */
public interface DutyService {

    /**
     * 新增职务
     *
     * @param duty 职务实体
     * @return
     */
    Message addDuty(Duty duty);

    /**
     * 查询职务列表
     *
     * @return
     */
    List<Duty> listDuty();

    /**
     * 修改职务
     *
     * @param duty 职务实体
     * @return
     */
    Message updateDuty(Duty duty);
}