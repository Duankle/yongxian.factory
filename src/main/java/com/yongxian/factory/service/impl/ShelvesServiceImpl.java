package com.yongxian.factory.service.impl;

import com.yongxian.factory.bean.GoodsshelvesBean;
import com.yongxian.factory.mapper.ShelvesMapper;
import com.yongxian.factory.service.ShelvesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

@Service
public class ShelvesServiceImpl implements ShelvesService {

    @Autowired
    ShelvesMapper shelvesMapper;

    @Override
    public List<GoodsshelvesBean> selectShelves() {
        return shelvesMapper.selectShelves();
    }

    @Override
    public int selectShelvesRepeat(String shelves_number,String ip_address,int start_ip,int end_ip) {
        int t=0;
        if (shelves_number !=null || shelves_number !=""){
            GoodsshelvesBean goodsshelvesBean=shelvesMapper.selectShelvesRepeatShelves_number(shelves_number);
            if(goodsshelvesBean !=null){
                return 1;
            }
        }
            List<GoodsshelvesBean> GoodsshelvesBeanList=shelvesMapper.selectShelvesRepeatIp_address(ip_address);
            if (GoodsshelvesBeanList.size() != 0 ){
                for (GoodsshelvesBean goodsshelvesBean: GoodsshelvesBeanList) {
                    if(max(goodsshelvesBean.getStart_ip(),start_ip)<=min(goodsshelvesBean.getEnd_ip(),end_ip)){
                        return 2;
                    }
                }
                return t;
            }
        return t;
    }

    @Override
    public GoodsshelvesBean selectShelves2(int id) {
        return shelvesMapper.selectShelves2(id);
    }

    @Override
    public void updateShelves(GoodsshelvesBean goodsshelvesBean1) {
        shelvesMapper.updateShelves(goodsshelvesBean1);
    }
}
