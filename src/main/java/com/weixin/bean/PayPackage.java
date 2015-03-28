package com.weixin.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.weixin.utils.Configure;

@JacksonXmlRootElement(localName = "xml")
public class PayPackage {

	private String appid;	//公众账号 ID appid
	
	private String mch_id; // 商户号 mch_id

	@JacksonXmlProperty(isAttribute = false)
	private String device_info; // 设备号 device_info 
	
	private String nonce_str; //随机字符串 nonce_str
	
	private String sign; //签名 sign
	
	private String body; 		//商品描述 body

	private String attach;		//附加数据 attach

	private String out_trade_no;//商户订单号 out_trade_no

	private String total_fee;	//订单价格 total_fee

	private String spbill_create_ip;	//订单生成的客户端IP spbill_create_ip
	
	@JacksonXmlProperty(isAttribute = false)
	private String time_start;			//交易起始时间 time_start

	@JacksonXmlProperty(isAttribute = false)
	private String time_expire; 		//交易结束时间 time_expire
	 
	@JacksonXmlProperty(isAttribute = false)
	private String goods_tag;			//商品标记,优惠卷里可能用到 goods_tag
	
	private String notify_url;	//返回地址 notify_url

	private String trade_type; //交易类型 trade_type JSAPI、NATIVE、APP
	
	private String openid; // 用户标识 openid

	private String product_id; // product_id

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

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return Configure.getNotifyCallbackUrl();
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
}
