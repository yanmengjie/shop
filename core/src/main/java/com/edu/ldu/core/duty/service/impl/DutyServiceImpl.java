package com.edu.ldu.core.duty.service.impl;

import com.edu.ldu.core.common.entity.Message;
import com.edu.ldu.core.duty.dao.DutyDao;
import com.edu.ldu.core.duty.entity.Duty;
import com.edu.ldu.core.duty.service.DutyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.List;

/**
 * @author yanmengjie
 * 2018/3/11
 */
@Slf4j
@Service
public class DutyServiceImpl implements DutyService {

    @Autowired
    private DutyDao dutyDao;


    /**
     * 新增职务
     *
     * @param duty 职务实体
     * @return
     */
    @Override
    public Message addDuty(Duty duty) {
        duty.setCreateTime(new Date());
        if (dutyDao.addDuty(duty) != 1) {
            return Message.fail("新增职务失败");
        }
        return Message.success("新增职务成功");
    }

    /**
     * 查询职务列表
     *
     * @return
     */
    @Override
    public List<Duty> listDuty() {
        return dutyDao.listDuty();
    }

    /**
     * 修改职务
     *
     * @param duty 职务实体
     * @return
     */
    @Override
    public Message updateDuty(Duty duty) {
        if (dutyDao.updateDuty(duty) != 1) {
            return Message.fail("修改职务失败");
        }
        return Message.fail("修改成功");
    }


}
