package com.yongxian.factory.controller;


import com.alibaba.fastjson.JSON;
import com.yongxian.factory.bean.GoodsshelvesBean;
import com.yongxian.factory.service.ShelvesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ShelvesController {
    @Autowired
    ShelvesService shelvesService;


    /* 工厂货架查询 */
    @PostMapping(value = "/selectShelves")
    public String selectShelves(){
        String toJsonString= JSON.toJSONString(shelvesService.selectShelves());
        return toJsonString;
    }

    /* 添加货架(是否符合添加货架条件) */
    @PostMapping(value = "selectShelvesRepeat")
    public int  selectShelvesRepeat(String shelves_number,String ip_address,int start_ip,int end_ip){
        //0:正常可以添加  1:该货架编号已存在  2:该IP段与其他货架冲突
        int t=shelvesService.selectShelvesRepeat(shelves_number,ip_address,start_ip,end_ip);
        return t;
    }

    /* 修改货架信息(回显) */
    @PostMapping(value = "/selectShelves2")
    public String selectShelves2(int id){
        String toJsonString= JSON.toJSONString(shelvesService.selectShelves2(id));
        return toJsonString;
    }

    /* 修改货架信息 */
    @PostMapping(value = "/updateShelves")
    public String updateShelves(String goodsshelvesBean){
        GoodsshelvesBean goodsshelvesBean1=JSON.parseObject(goodsshelvesBean,GoodsshelvesBean.class);
        shelvesService.updateShelves(goodsshelvesBean1);
        return "toJsonString";
    }










}
