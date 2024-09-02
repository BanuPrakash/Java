package com.adobe.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
    private static String DAO = "";

    // static block gets called as soon as class is loaded
    // can't call it explicitly
    // loading of drivers, reading config files should be done here
    static  {
        ResourceBundle res = ResourceBundle.getBundle("config");
        DAO = res.getString("MOBILE_DAO"); //com.adobe.prj.dao.MobileDaoMySqlImpl
    }

    public static  MobileDao getMobileDao() {
        //return new MobileDaoMySqlImpl();
        try {
            return (MobileDao) Class.forName(DAO).getConstructor().newInstance();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }
}
