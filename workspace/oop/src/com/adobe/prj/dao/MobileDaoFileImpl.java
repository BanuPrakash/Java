package com.adobe.prj.dao;

import com.adobe.prj.entity.Mobile;
// implements is for realization
// extends is for specialization
public class MobileDaoFileImpl implements  MobileDao{
    @Override
    public void addMobile(Mobile m) {
        System.out.println(m.getName() + " stored in file!!!");
    }
}
