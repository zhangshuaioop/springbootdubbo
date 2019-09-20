package com.example.messenger.service.weather;

import com.baojufeng.commoncomponets.entity.message.publicss.Weather;
import com.example.messenger.utils.AliyunHttpUtils;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 天气预报信息
 * @author: zhangshuai
 * @create: 2018-11-19 09:39
 */
@Service
public class WeatherService {


    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    //获取天气api
    private static String weatherHost = "https://saweather.market.alicloudapi.com";
    private static String weatherPath = "/spot-to-weather"; //api路径



    //appcode
//    private static String appcode = "dc3115d939dd4404a80e4e8bcd54c0c1"; //appcode
    private static String appcode = "3c98c7aa5e2c44a5bc7a77b5193fe198"; //appcode



//    public static void main(String[] args){
//        WeatherService weatherUtil = new WeatherService();
//        Weather weather = new Weather();
//        weather.setArea("泰山");
//        weather.setNeed3HourForcast("0");
//        weather.setNeedAlarm("0");
//        weather.setNeedHourData("0");
//        weather.setNeedIndex("0");
//        weather.setNeedMoreDay("0");
//        JSONObject weatherString = weatherUtil.getWeather(weather);
//        System.out.println(weatherString);
//    }




    /**
     * 获取天气接口
     * 全国天气预报查询（免费版）
     *
     * 接口流量限制情况（每个用户ID）：30次流控/分钟。
     *
     * 全国3000多个省市的实时天气预报，未来7天、未来24小时天气，
     * 穿衣、运动、洗车、感冒、空气污染扩散、紫外线等指数查询接口，
     * 可按地名、经纬度、IP查询，30分钟更新一次，中国气象局权威数据。
     *
     * @return
     */
    public static JSONObject getWeather(Weather weather){
        JSONObject weatherJson = new JSONObject();
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("area", weather.getArea());
        querys.put("need3HourForcast", weather.getNeed3HourForcast());
        querys.put("needAlarm", weather.getNeedAlarm());
        querys.put("needHourData", weather.getNeedHourData());
        querys.put("needIndex", weather.getNeedIndex());
        querys.put("needMoreDay", weather.getNeedMoreDay());

        try {
            HttpResponse response = AliyunHttpUtils.doGet(weatherHost, weatherPath, method, headers, querys);
            //获取response的body
            weatherJson = JSONObject.fromObject(EntityUtils.toString(response.getEntity()));

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("获取天气失败");
            logger.info(e.toString());
            return weatherJson;
        }
        return weatherJson;
    }
}
