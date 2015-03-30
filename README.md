# weixin-pay
微信支付最新版 java 实现

实现微信支付 Native 扫码支付

支付场景在 [微信支付文档](http://pay.weixin.qq.com/wiki/doc/api/index.php?chapter=6_1)

<img src="http://pay.weixin.qq.com/wiki/doc/api/img/chapter6_1_1.png"/>
<br>
<img src="http://pay.weixin.qq.com/wiki/doc/api//img/chapter6_1_2.jpg"/>
<br>
<img src="http://pay.weixin.qq.com/wiki/doc/api//img/chapter6_1_3.jpg"/>
<br>


步骤：

1 生成二维码链接地址

```
String payNativeUrl = PayUtils.generateMchPayNativeRequestURL(productId);
```
然后可以通过jqueyQrcode的插件，在页面上生成二维码

2 扫码二维码后微信发送的请求处理

封装输入信息

```
PayNativeInput payNativeInput = PayUtils.convertRequest(request.getInputStream());

```

验证合法性

```
			
boolean validate = PayUtils.validateAppSignature(payNativeInput);

if(!validate){
	return null;
}
```

封装商品信息

```
			
PayPackage payPackage = new PayPackage();

payPackage.setAppid(payNativeInput.getAppid());
payPackage.setAttach("test");
payPackage.setBody("product");
payPackage.setNonce_str(payNativeInput.getNonce_str());
payPackage.setMch_id(payNativeInput.getMch_id());
payPackage.setOpenid(payNativeInput.getOpenid());
payPackage.setOut_trade_no(UUID.randomUUID().toString().replace("-", ""));
payPackage.setProduct_id(payNativeInput.getProduct_id());
payPackage.setSpbill_create_ip("127.0.0.1");
payPackage.setTotal_fee("1");
payPackage.setTrade_type("NATIVE");

```

发送统一下单请求

```
	String replyXml = PayUtils.generatePayNativeReplyXML(payPackage);
```

3 支付成功回调

```
PayCallbackNotify payCallbackNotify = PayUtils.payCallbackNotify(request.getInputStream());
if(payCallbackNotify.isPaySuccess()){
	String content = PayUtils.generatePaySuccessReplyXML();
	return content;
}
			
```

系统依赖jar包

```
compile 'com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.4.0'
compile 'org.apache.httpcomponents:httpclient:4.4'
compile 'log4j:log4j:1.2.17'
compile 'commons-io:commons-io:2.3'
compile 'commons-beanutils:commons-beanutils:1.9.2'
	
```


