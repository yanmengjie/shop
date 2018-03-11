package com.edu.ldu.admin.duty.controller;

import com.edu.ldu.core.common.entity.Message;
import com.edu.ldu.core.duty.entity.Duty;
import com.edu.ldu.core.duty.service.DutyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanmengjie
 * 2018/3/11
 */
@Slf4j
@RestController
@RequestMapping("duty")
public class DutyController {

    @Autowired
    private DutyService dutyService;

    /**
     * 新增职务
     *
     * @param duty 职务
     * @return
     */
    @RequestMapping("addDuty")
    public Message addDuty(Duty duty) {

        if (!StringUtils.isNotBlank(duty.getName())) {
            return Message.fail("职务名称不能为空");
        }
        return dutyService.addDuty(duty);
    }

    /**
     * 查询职务列表
     *
     * @return
     */
    @RequestMapping("listDuty")
    public Message listDuty() {
        Message message = new Message();
        message.setBean(dutyService.listDuty());
        message.setSuccess(true);
        return message;
    }

    /**
     * 修改职务
     *
     * @param duty
     * @return
     */
    @RequestMapping("updateDuty")
    public Message updateDuty(Duty duty) {
        if (duty.getId() == null) {
            return Message.fail("修改的职务id不能为空");
        }
        if (!StringUtils.isNotBlank(duty.getName())) {
            return Message.fail("职务名称不能为空");
        }
        return dutyService.updateDuty(duty);
    }


}