package com.yg.mapper;

import com.github.pagehelper.PageInfo;
import com.yg.bean.Admin;
import com.yg.bean.Cost;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yg on 17/8/30.
 */

@Repository
public interface CostMapper {
    //查询所有Cost
    List<Cost> searchAllCost();


    //添加新的Cost
    void addCost(Cost cost);


    //删除Cost
    void deleteCost(String id);


    //修改Cost
    void updateCost(int id);

    void getId(Integer id);

    Admin findInfo(String user);
}
