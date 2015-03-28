package com.weixin.utils;

public class Configure {

	private static final String sdkVersion = "1.0";

	private static String appID = "";

	private static String mchID = "";

	private static String subMchID = "";

	private static String certLocalPath = "";

	private static String certPassword = "";
	
	private static String key = "";
	
	private static String notifyCallbackUrl = "";
			
	//是否使用异步线程的方式来上报API测速，默认为异步模式
	private static boolean useThreadToDoReport = true;

	
	//机器IP
	private static String ip = "";

	//以下是几个API的路径：
	//1）被扫支付API
	public static String PAY_API = "https://api.mch.weixin.qq.com/pay/micropay";

	//2）订单查询API
	public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

	//3）退款API
	public static String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

	//4）退款查询API
	public static String REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";

	//5）撤销API
	public static String REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";

	//6）下载对账单API
	public static String DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";

	//7) 统计上报API
	public static String REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";
	
	//8) 关闭订单
	public static String PAY_CLOSE_API = "https://api.mch.weixin.qq.com/pay/closeorder";
	
	//8) 统一下单
	public static String UNIFY_PAY_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	/**
	 * 
	 * @param appID 微信分配的公众号ID
	 * @param mchID 微信支付分配的商户号ID
	 * @param subMchID 受理模式下给子商户分配的子商户号, 默认可填 ""
	 * @param certLocalPath  HTTPS证书的本地路径
	 * @param certPassword HTTPS证书密码，默认密码等于商户号MCHID
	 * @param key 加密秘钥
	 */
	public static void initialize(String appID, String mchID, String subMchID, 
			String certLocalPath, String certPassword, String key, String notifyCallbackUrl){
		
		Configure.key = key;
		Configure.appID = appID;
		Configure.mchID = mchID;
		Configure.subMchID = subMchID;
		Configure.certLocalPath = certLocalPath;
		Configure.certPassword = certPassword;
		Configure.key = key;
		Configure.setNotifyCallbackUrl(notifyCallbackUrl);
	} 
	
	public static boolean isUseThreadToDoReport() {
		return useThreadToDoReport;
	}

	public static void setUseThreadToDoReport(boolean useThreadToDoReport) {
		Configure.useThreadToDoReport = useThreadToDoReport;
	}

	public static String HttpsRequestClassName = "com.tencent.common.HttpsRequest";

	public static void setKey(String key) {
		Configure.key = key;
	}

	public static void setAppID(String appID) {
		Configure.appID = appID;
	}

	public static void setMchID(String mchID) {
		Configure.mchID = mchID;
	}

	public static void setSubMchID(String subMchID) {
		Configure.subMchID = subMchID;
	}

	public static void setCertLocalPath(String certLocalPath) {
		Configure.certLocalPath = certLocalPath;
	}

	public static void setCertPassword(String certPassword) {
		Configure.certPassword = certPassword;
	}

	public static void setIp(String ip) {
		Configure.ip = ip;
	}

	public static String getKey(){
		return key;
	}
	
	public static String getAppid(){
		return appID;
	}
	
	public static String getMchid(){
		return mchID;
	}

	public static String getSubMchid(){
		return subMchID;
	}
	
	public static String getCertLocalPath(){
		return certLocalPath;
	}
	
	public static String getCertPassword(){
		return certPassword;
	}

	public static String getIP(){
		return ip;
	}

	public static void setHttpsRequestClassName(String name){
		HttpsRequestClassName = name;
	}

	public static String getSdkVersion(){
		return sdkVersion;
	}

	public static String getNotifyCallbackUrl() {
		return notifyCallbackUrl;
	}

	public static void setNotifyCallbackUrl(String notifyCallbackUrl) {
		Configure.notifyCallbackUrl = notifyCallbackUrl;
	}

}
