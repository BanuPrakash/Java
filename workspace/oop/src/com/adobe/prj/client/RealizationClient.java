package com.adobe.prj.client;

import com.adobe.prj.dao.MobileDao;
import com.adobe.prj.dao.MobileDaoFactory;
//import com.adobe.prj.dao.MobileDaoFileImpl;
//import com.adobe.prj.dao.MobileDaoMySqlImpl;
import com.adobe.prj.entity.Mobile;

// OCP
public class RealizationClient {
    public static void main(String[] args) {
//        MobileDao mobileDao = new MobileDaoFileImpl();
//        MobileDao mobileDao = new MobileDaoMySqlImpl(); // switch the strategy --> Strategy design Pattern
        MobileDao mobileDao = MobileDaoFactory.getMobileDao();
        Mobile m = new Mobile(90, "OnePlus 14", 78000, "4G");
        mobileDao.addMobile(m);
    }
}
