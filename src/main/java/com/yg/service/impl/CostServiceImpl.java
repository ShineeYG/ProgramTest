package com.yg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yg.bean.Admin;
import com.yg.bean.Cost;
import com.yg.mapper.CostMapper;
import com.yg.service.CostService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yg on 17/8/30.
 */
@Service
public class CostServiceImpl implements CostService {


    @Resource
    public CostMapper costMapper;


    public PageInfo<Cost> searchAllCost(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 3 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Cost> costList = costMapper.searchAllCost();
        PageInfo<Cost> pageInfo = new PageInfo<Cost>(costList);
        return pageInfo;
    }

    public void delectCost(Integer id) {
        costMapper.deleteCost(id);
    }

    public void addCost(Cost cost) {
        costMapper.addCost(cost);
    }

    public Cost getId(Integer id) {
        Cost cost = costMapper.getId(id);
        return cost;
    }

    public boolean findInfo(@Param("user") String user, @Param("password") Integer password) {
//        System.out.println("查到的password    " + admin.getPassword() + "    " + "输入的密码   " + password);
        Admin admin = costMapper.findInfo(user);
        System.out.println(admin.getPassword());

        if (admin.getPassword() != password) {
            return false;
        } else {
            return true;
        }

    }
}
