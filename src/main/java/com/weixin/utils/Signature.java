package com.weixin.utils;

import java.util.Map;

/**
 * 
 * @author louiseliu
 *
 */
public class Signature {

	public static String generateSign(Map<String, String> map){
    	Map<String, String> orderMap = MapUtil.order(map);
		
    	String result = MapUtil.mapJoin(orderMap,true,false);
        result += "&key=" + Configure.getKey();
        result = MD5.MD5Encode(result).toUpperCase();
       
        return result;
    }
}

