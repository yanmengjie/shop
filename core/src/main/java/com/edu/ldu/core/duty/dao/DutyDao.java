package com.edu.ldu.core.duty.dao;

import com.edu.ldu.core.duty.entity.Duty;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yanmengjie
 * 2018/3/11
 */
@Repository
public interface DutyDao {

    /**
     * 新增职务
     *
     * @param duty 职务实体
     * @return
     */
    @Insert(" insert " +
            " into " +
            " tbl_duty(" +
            " name," +
            " create_time," +
            " modified_time) " +
            " values(" +
            " #{duty.name}," +
            " #{duty.createTime}," +
            " #{duty.modifiedTime})")
    int addDuty(@Param("duty") Duty duty);


    /**
     * 查询职务列表
     *
     * @return
     */
    @Select("select id, name,create_time as createTime,modified_time as modifiedTime from tbl_duty")
    List<Duty> listDuty();

    /**
     * 修改职务
     *
     * @param duty 职务实体
     * @return
     */
    @Update("update tbl_duty set name =#{duty.name},modified_time=#{modified_time.modifiedTime} where id=#{duty.id}")
    int updateDuty(@Param("duty") Duty duty);

    /**
     * 删除职务
     *
     * @param id 职务id
     * @return
     */
    @Delete("delete from tbl_duty where id=#{id}")
    int deleteDuty(@Param("id") Integer id);

}