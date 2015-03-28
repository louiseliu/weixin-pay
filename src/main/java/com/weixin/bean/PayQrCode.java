package com.weixin.bean;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import com.weixin.utils.Configure;
import com.weixin.utils.MapUtil;
import com.weixin.utils.Signature;

/**
 * 
 * @author louiseliu
 *
 */
public class PayQrCode {

	private String appid = "";
	private String mch_id = "";
	private String time_stamp ="";
	private String nonce_str ="";
	private String product_id = "";
	private String sign = "";
	
	/**
	 * @param product_id
	 */
	public PayQrCode(String product_id){
		setAppid(Configure.getAppid());
		setMch_id(Configure.getMchid());
		setTime_stamp(System.currentTimeMillis()/1000+"");
		setNonce_str(UUID.randomUUID().toString().replace("-", ""));
		setProduct_id(product_id);
		
		try {
			Map<String, String> map = BeanUtils.describe(this);
			map.remove("class");
			
			String sign = Signature.generateSign(map);
	        setSign(sign);
		} catch (Exception e) {
		}
	}
	
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}

