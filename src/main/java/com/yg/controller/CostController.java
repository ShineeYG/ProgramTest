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

    //跳转到修改Cost界面
    @RequestMapping("feemodi")
    public String jumpFeeModi() {
        return "/fee/fee_modi";
    }

    //跳转到查看信息的界面
    @RequestMapping("feedetail")

    public String jumpfeedetail() {

        System.out.println("走你 ");
        return "/fee/fee_detail";
    }


    //资费管理
    @RequestMapping("getAllCost")
    @ResponseBody
    public PageInfo<Cost> searchAllCost(@RequestParam("pageNum") Integer pageNum,
                                        @RequestParam("pageSize") Integer pageSize) {
        PageInfo<Cost> costList = costService.searchAllCost(pageNum, pageSize);
        System.out.println("查询的结果  : " + costList);
        return costList;
    }

    //删除Cost信息
    @RequestMapping("/delectCost")
    public String delectCost(@RequestParam("bid") Integer id) {

        System.out.println("走到这了   ...");
        System.out.println("获取到的 id     : " + id);
        costService.delectCost(id);
        return "fee/fee_list";
    }


    //添加Cost信息
    @RequestMapping("addCost")
    public String addCost(Cost cost) {

//        默认创建时 状态为1   时间为系统时间
        cost.setStatus("1");
        cost.setCreatetime(new Timestamp(System.currentTimeMillis()));
        costService.addCost(cost);
        return "fee/fee_list";
    }


    //根据id查询
    @RequestMapping("getID")
    @ResponseBody
    public Cost getId(@RequestParam("id") Integer id) {
        Cost cost = costService.getId(id);
        System.out.println( "            "+ cost);
        return cost;
    }


    //登录界面
    @RequestMapping("login")
    public String login(@RequestParam("user") String user,
                        @RequestParam("password") Integer password,
                        @RequestParam("code") Integer code) {
        System.out.println(user + "" + password + "" + code);

        //如果登录账号 密码 验证码  都为空  就重新登录
        if (user == null | password == null | code == null) {
            return "login";
        } else {
            //如果验证码不是8251  就不允许登录
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


}
