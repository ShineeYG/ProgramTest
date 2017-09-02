package com.yg.controller;

import com.github.pagehelper.PageInfo;
import com.yg.bean.Admin;
import com.yg.bean.Cost;
import com.yg.service.CostService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by yg on 17/8/30.
 */

@Controller
public class CostController {

    @Resource
    public CostService costService;


    //跳转到主页面
    @RequestMapping("/")
    public String jump() {
        return "login";
    }

    //跳转到主页面
    @RequestMapping("fee_list")
    public String jumpCost() {
        return "/fee/fee_list";
    }

    //跳转到添加界面
    @RequestMapping("addFee")
    public String jumpAddFee() {
        return "/fee/fee_add";
    }


    //资费管理
    @RequestMapping("getAllCost")
    @ResponseBody
    public PageInfo<Cost> searchAllCost(@RequestParam("pageNum") Integer pageNum,
                                        @RequestParam("pageSize") Integer pageSize) {
        System.out.println(pageNum + "  输出获取到的结果  " + pageSize);
        PageInfo<Cost> costList = costService.searchAllCost(pageNum, pageSize);
        System.out.println("查询的结果  : " + costList);
        return costList;
    }

    //删除Cost信息
    @RequestMapping("delectCost")
    public String delectCost(@RequestParam("id") String id) {
        costService.delectCost(id);
        return "fee/fee_list";
    }


    //添加Cost信息
    @RequestMapping("addCost")
    public String addCost(Cost cost) {

        System.out.println( "获取到的 Cost  "+  cost.getName());
//        默认创建时 状态为1   时间为系统时间
        cost.setStatus("1");
        cost.setCreatetime(new Timestamp(System.currentTimeMillis()));
        costService.addCost(cost);
        return "fee/fee_list";
    }


    //根据id查询
    @RequestMapping("getID")
    public String getId(@RequestParam("id") Integer id) {
        costService.getId(id);
        return "fee/fee_list";
    }


    //登录界面
    @RequestMapping("login")
    public String login(@RequestParam("user") String user,
                        @RequestParam("password") Integer password,
                        @RequestParam("code") Integer code) {
        System.out.println(user + "" + password + "" + code);

        if (code == 8251) {
            if (costService.findInfo(user, password)) {
                return "index";
            } else {
                return "login";
            }
        } else {
            return "login";
        }

    }


}
