package com.company.springboot.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.List;

public class Province {


    /**
     * 校验省是否正确
     * @param name
     * @return
     */
    public static boolean isProvince(JSONArray Array,String name){
        boolean re=false;
        try {
           if(Array!=null){
               for (int i=0;i<Array.size();i++){
                   if(JSONObject.fromObject(Array.get(i)).get("name").equals(name)){
                       re=true;
                   }
               }
           }
        } catch (Exception e) {
            re=false;
        }
        return re;
    }

    /**
     * 校验市是否正确
     * @param Array
     * @param provinceName
     * @param cityName
     * @return
     */
    public static boolean isCity(JSONArray Array,String provinceName,String cityName){
        boolean re=false;
        try {
            for (int i=0;i<Array.size();i++){
                if(JSONObject.fromObject(Array.get(i)).get("name").equals(provinceName)){
                    //获取到市级
                    JSONArray arrayCity=JSONObject.fromObject(Array.get(i)).getJSONArray("city");
                    //遍历市
                    for (int j=0;j<arrayCity.size();j++){
                        if(JSONObject.fromObject(arrayCity.get(j)).get("name").equals(cityName)){
                            re=true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            re=false;
        }
        return re;
    }

    /**
     * 校验市是否正确
     * @param Array
     * @param provinceName
     * @param cityName
     * @param areaName
     * @return
     */
    public static boolean isArea(JSONArray Array,String provinceName,String cityName,String areaName){
        boolean re=false;
        try {
            for (int i=0;i<Array.size();i++){
                if(JSONObject.fromObject(Array.get(i)).get("name").equals(provinceName)){
                    //获取到市级
                    JSONArray arrayCity=JSONObject.fromObject(Array.get(i)).getJSONArray("city");
                    //遍历市
                    for (int j=0;j<arrayCity.size();j++){
                        if(JSONObject.fromObject(arrayCity.get(j)).get("name").equals(cityName)){
                            //获取区
                            JSONArray areaCity=JSONObject.fromObject(arrayCity.get(j)).getJSONArray("area");
                            //遍历区
                            List<String> lsit1 = (List)areaCity;
                            if(lsit1.contains(areaName)){
                                re=true;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            re=false;
        }
        return re;
    }
}
