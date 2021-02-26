package com.yongxian.factory.mapper;

import com.yongxian.factory.bean.GoodsshelvesBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShelvesMapper {
    List<GoodsshelvesBean> selectShelves();

    GoodsshelvesBean selectShelvesRepeatShelves_number(String shelves_number);

    List<GoodsshelvesBean> selectShelvesRepeatIp_address(String ip_address);

    GoodsshelvesBean selectShelves2(int id);

    void updateShelves(GoodsshelvesBean goodsshelvesBean1);
}
