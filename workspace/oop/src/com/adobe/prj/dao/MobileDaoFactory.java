package com.adobe.prj.dao;

public class MobileDaoFactory {
    public static  MobileDao getMobileDao() {
        return new MobileDaoMySqlImpl();
    }
}
