package com.weixin.api;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.weixin.bean.PayCallbackNotify;
import com.weixin.bean.PayNativeInput;
import com.weixin.bean.PayPackage;
import com.weixin.bean.PayQrCode;
import com.weixin.utils.Configure;
import com.weixin.utils.HttpsRequest;
import com.weixin.utils.MapUtil;
import com.weixin.utils.Signature;

/**
 * 
 * @author louiseliu
 *
 */
public class PayUtils {
	private static final Logger logger = Logger.getLogger(PayUtils.class);
	 
	public static String generateMchPayNativeRequestURL(String productid){
		PayQrCode qrCode = new PayQrCode(productid);
		Map<String, String> map = new HashMap<String, String>();
		map.put("sign", qrCode.getSign());
		map.put("appid", qrCode.getAppid());
		map.put("mch_id", qrCode.getMch_id());
		map.put("product_id", qrCode.getProduct_id());
		map.put("time_stamp", qrCode.getTime_stamp());
		map.put("nonce_str", qrCode.getNonce_str());
		
		return "weixin://wxpay/bizpayurl?" + MapUtil.mapJoin(map, false, false);
	}
	
	/**
	 * 
	 * @param inputStream request.getInputStream()
	 * @return
	 */
	public static PayNativeInput convertRequest(InputStream inputStream){
		try {
			String content = IOUtils.toString(inputStream);
			
			XmlMapper xmlMapper = new XmlMapper();
			PayNativeInput payNativeInput = xmlMapper.readValue(content, PayNativeInput.class);
			
			return payNativeInput;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean validateAppSignature(PayNativeInput payNativeInput){
		try {
			Map<String, String> map = BeanUtils.describe(payNativeInput);
			map.remove("class");
			map.put("sign", "");
			
			String sign = Signature.generateSign(map);
			return payNativeInput.getSign().equals(sign) ? true : false;
		} catch (Exception e) {
		}
		
		return false;
	}
	
	public static String generatePayNativeReplyXML(PayPackage payPackage){
		try {
			
			Map<String, String> map = BeanUtils.describe(payPackage);
			map.remove("class");
			
			String sign = Signature.generateSign(map);
			payPackage.setSign(sign);
			
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.setSerializationInclusion(Include.NON_EMPTY);
			
			String xmlContent = xmlMapper.writeValueAsString(payPackage);
			
			HttpsRequest httpsRequest = new HttpsRequest();
			String result = httpsRequest.sendPost(Configure.UNIFY_PAY_API, xmlContent);
			return result;
		} catch (Exception e) {
			logger.info("e:" + e);
		}
		
		return null;
	}
	
	public static PayCallbackNotify payCallbackNotify(InputStream inputStream){
		try {
			String content = IOUtils.toString(inputStream);
			
			XmlMapper xmlMapper = new XmlMapper();
			PayCallbackNotify payCallbackNotify = xmlMapper.readValue(content, PayCallbackNotify.class);
			if(payCallbackNotify.getResult_code().equals("SUCCESS")
					&& payCallbackNotify.getReturn_code().equals("SUCCESS")){
				payCallbackNotify.setPaySuccess(true);
			}
			return payCallbackNotify;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String generatePaySuccessReplyXML(){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<xml>")
					.append("<return_code><![CDATA[SUCCESS]]></return_code>")
					.append("<return_msg><![CDATA[OK]]></return_msg>")
					.append("</xml>");
		return stringBuffer.toString();
	}
}
