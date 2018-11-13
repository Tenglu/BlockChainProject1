package com.example.demo.dao;

import com.example.demo.model.WorkOrder;

public interface WorkOrderMapper {
    int deleteByPrimaryKey(String workOrderNumber);

    int insert(WorkOrder record);

    int insertSelective(WorkOrder record);

    WorkOrder selectByPrimaryKey(String workOrderNumber);

    int updateByPrimaryKeySelective(WorkOrder record);

    int updateByPrimaryKey(WorkOrder record);
}