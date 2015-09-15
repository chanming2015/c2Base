/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.ginkgo.common.util;

/**
 * Project:c2-base
 * Package:com.qingbo.ginkgo.base.util
 * FileName:LatitudeLongitudeUtil.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年7月30日 下午2:26:07
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public class LongitudeLatitudeUtil {
	
	private static final  double EARTH_RADIUS = 6378.137;       // 赤道半径(单位km)
	
	/** 
     * 经纬度转化为弧度(rad) 
     * */  
    private static double rad(double d)  
    {  
       return d * Math.PI / 180.0;  
    }  

    /**
     * 
     * @author XuMaoSen
     * Create Time:2015年7月31日 上午9:24:53
     * Description 计算两个经纬度之间的距离
     * @param lon1 位置1经度
     * @param lat1 位置1纬度
     * @param lon2 位置2经度
     * @param lat2 位置2经度
     * @return
     */
    public static double LantitudeLongitudeDist(double lon1, double lat1,double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
  
        double radLon1 = rad(lon1);
        double radLon2 = rad(lon2);
  
        if (radLat1 < 0)  
            radLat1 = Math.PI / 2 + Math.abs(radLat1);// south  
        if (radLat1 > 0)  
            radLat1 = Math.PI / 2 - Math.abs(radLat1);// north  
        if (radLon1 < 0)  
            radLon1 = Math.PI * 2 - Math.abs(radLon1);// west  
        if (radLon1 > 0)  
            radLon1 = Math.PI * 2 + Math.abs(radLon1);// east  
        if (radLat2 < 0)  
            radLat2 = Math.PI / 2 + Math.abs(radLat2);// south  
        if (radLat2 > 0)  
            radLat2 = Math.PI / 2 - Math.abs(radLat2);// north  
        if (radLon2 < 0)  
            radLon2 = Math.PI * 2 - Math.abs(radLon2);// west  
        if (radLon2 > 0)  
            radLon2 = Math.PI * 2 + Math.abs(radLon2);// east 
        double x1 = EARTH_RADIUS * Math.cos(radLon1) * Math.sin(radLat1);  
        double y1 = EARTH_RADIUS * Math.sin(radLon1) * Math.sin(radLat1);  
        double z1 = EARTH_RADIUS * Math.cos(radLat1);  
  
        double x2 = EARTH_RADIUS * Math.cos(radLon2) * Math.sin(radLat2);  
        double y2 = EARTH_RADIUS * Math.sin(radLon2) * Math.sin(radLat2);  
        double z2 = EARTH_RADIUS * Math.cos(radLat2);  
  
        double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)+ (z1 - z2) * (z1 - z2));  
        //余弦定理求夹角  
        double theta = Math.acos((EARTH_RADIUS * EARTH_RADIUS + EARTH_RADIUS * EARTH_RADIUS - d * d) / (2 * EARTH_RADIUS * EARTH_RADIUS));  
        double dist = theta * EARTH_RADIUS;  
        return dist;  
    }
    
    /**
     * 
     * @author XuMaoSen
     * Create Time:2015年7月31日 上午9:24:53
     * Description 计算两个经纬度之间的距离（纬度需在同一半球）优先
     * @param lon1 位置1经度
     * @param lat1 位置1纬度
     * @param lon2 位置2经度
     * @param lat2 位置2纬度
     * @return km
     */
    public static double GetDistance(double lon1,double lat1,double lon2, double lat2) {  
       double radLat1 = rad(lat1);  
       double radLat2 = rad(lat2);  
       double a = radLat1 - radLat2;  
       double b = rad(lon1) - rad(lon2);  
       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
       s = s * EARTH_RADIUS;  
       s = Math.round(s * 100) / 100.0;
       return s;
    }
    
}
