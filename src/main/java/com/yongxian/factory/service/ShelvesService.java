package com.yongxian.factory.service;

import com.yongxian.factory.bean.GoodsshelvesBean;

import java.util.List;

public interface ShelvesService {
    List<GoodsshelvesBean> selectShelves();

    int selectShelvesRepeat(String shelves_numberString ,String ip_address,int start_ip,int end_ip);

    GoodsshelvesBean selectShelves2(int id);

    void updateShelves(GoodsshelvesBean goodsshelvesBean1);
}
