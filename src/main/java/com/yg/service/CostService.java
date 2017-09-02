package com.yg.service;

import com.github.pagehelper.PageInfo;
import com.yg.bean.Admin;
import com.yg.bean.Cost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yg on 17/8/30.
 */

public interface CostService {
    PageInfo<Cost> searchAllCost(Integer pageNum , Integer pageSize);

    void delectCost(@Param("id") Integer id);

    void addCost(Cost cost);

    Cost getId(Integer id);

    boolean findInfo(@Param("user") String user, @Param("password") Integer password);

}
