package com.example.common.utils;

import java.util.UUID;

public class UUIDUtils {
    /*
    获取一个UUID
     */
    public static String getOneUUID(){
       //获取UUID
        String s = UUID.randomUUID().toString();
        //去掉“-”
        return s.substring(0,0)+s.substring(9,15)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
    }
    /*
    获取指定数目的UUID
     */
    public static String[] getUUID(int number){
        if(number < 1){
            return  null;
        }
        String[] ss = new String[number];
        for (int i=0;i<number;i++){
            ss[i] = getOneUUID();
        }
        return ss;
    }
}
