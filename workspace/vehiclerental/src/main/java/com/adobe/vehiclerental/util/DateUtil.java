package com.adobe.vehiclerental.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date toDate(String strDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            return sdf.parse(strDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }
}
