package com.huangguang.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


public class HttpClientUtil extends HttpClientBase{

    public static String httpGet(URI uri, Integer connectTimeout) {
        return httpGet(uri, "UTF-8", connectTimeout);
    }

    public static String httpGet(URI uri) {
        return httpGet(uri, "UTF-8", null);
    }


    public static String httpGet(String url, Map<String, String> params) {
        return httpGet(url, params, "UTF-8", null);
    }


    public static String httpGet(String url, Map<String, String> params, Integer connectTimeout) {
        return httpGet(url, params, "UTF-8", connectTimeout);
    }

    public static String sslHttpGet(URI uri, String charsetEncoding, Integer connectTimeout) {
        HttpClient httpClient = createHttpsClient();
        return doHttpGet(uri, httpClient, charsetEncoding, connectTimeout);
    }

    public static String sslHttpGet(URI uri, Integer connectTimeout) {
        return sslHttpGet(uri, "UTF-8", connectTimeout);
    }

    public static String sslHttpGet(String url, Map<String, String> params, Integer connectTimeout) {
        return sslHttpGet(url, params, "UTF-8", connectTimeout);
    }



    public static String httpPost(URI uri, Map<String, String> params, Integer connectTimeout) {
        return httpPost(uri, params, "UTF-8", connectTimeout);
    }

    public static String httpPost(String url, Map<String, String> params, String charsetEncoding, Integer connectTimeout) {
        URI uri = URI.create(url);
        return httpPost(uri, params, charsetEncoding, connectTimeout);
    }


    public static String httpPost(String url, Map<String, String> params) {
        return httpPost(url, params, "UTF-8", null);
    }

    public static String httpPost(URI uri, Map<String, String> params) {
        return httpPost(uri, params, "UTF-8", null);
    }


    public static String httpPost(String url, Map<String, String> params, Integer connectTimeout) {
        return httpPost(url, params, "UTF-8", connectTimeout);
    }


    public static String httpPost(String url, Map<String, String> params, boolean proxy, String proxyHost, Integer proxyPort) {
        return httpPost(url, params, "UTF-8", proxy, proxyHost, proxyPort);
    }

    public static String httpPost(String url, Map<String, String> params, String charsetEncoding, Integer connectTimeout, boolean proxy, String proxyHost, Integer proxyPort) {
        if (proxy) {
            return httpPostProxy(url, params, charsetEncoding, connectTimeout, proxyHost, proxyPort);
        }
        return httpPost(url, params, charsetEncoding, connectTimeout);
    }


    public static String httpPost(String url, Map<String, String> params, String charsetEncoding, boolean proxy, String proxyHost, Integer proxyPort) {
        if (proxy) {
            return httpPostProxy(url, params, charsetEncoding, null, proxyHost, proxyPort);
        }
        return httpPost(url, params, charsetEncoding, null);
    }

    public static String httpPostProxy(String url, Map<String, String> params, Integer connectTimeout, String proxyHost, Integer proxyPort) {
        return httpPostProxy(url, params, "UTF-8", connectTimeout, proxyHost, proxyPort);
    }

    public static String httpPostProxy(String url, Map<String, String> params, String charsetEncoding, Integer connectTimeout, String proxyHost, Integer proxyPort) {
        URI uri = URI.create(url);
        return httpPostProxy(uri, params, charsetEncoding, connectTimeout, proxyHost, proxyPort);
    }



    public static String sslHttpPost(String url, Map<String, String> params, String charsetEncoding, Integer connectTimeout) {
        URI uri = URI.create(url);
        return sslHttpPost(uri, params, charsetEncoding, connectTimeout);
    }

    public static String sslHttpPost(String url, Map<String, String> params, Integer connectTimeout) {
        return sslHttpPost(url, params, "UTF-8", connectTimeout);
    }

    public static String sslHttpPost(String url, Map<String, String> params, String charsetEncoding) {
        URI uri = URI.create(url);
        return sslHttpPost(uri, params, charsetEncoding, null);
    }

    public static String sslHttpPost(String url, Map<String, String> params) {
        return sslHttpPost(url, params, "UTF-8", null);
    }


    public static String sslJsonPost(URI uri, String json, String charsetEncoding, Integer connectTimeout) {
        HttpClient httpClient = createHttpsClient();
        return doJsonPost(uri, httpClient, json, charsetEncoding, connectTimeout);
    }

    public static String sslJsonPost(URI uri, String json, Integer connectTimeout) {
        return sslJsonPost(uri, json, "UTF-8", connectTimeout);
    }

    public static String sslJsonPost(String url, String json, String charsetEncoding, Integer connectTimeout) {
        URI uri = URI.create(url);
        return sslJsonPost(uri, json, charsetEncoding, connectTimeout);
    }

    public static String sslJsonPost(String url, String json, Integer connectTimeout) {
        return sslJsonPost(url, json, "UTF-8", connectTimeout);
    }


    public static String sslJsonPost(String url, String json) {
        return sslJsonPost(url, json, "UTF-8", null);
    }


    public static String jsonPost(String url, String json) {
        return jsonPost(url, json, "UTF-8", null);
    }


    public static String jsonPost(String url, String json, Integer connectTimeout) {
        return jsonPost(url, json, "UTF-8", connectTimeout);
    }


    public static String jsonPost(String url, String json, boolean proxy, String proxyHost, Integer proxyPort) {
        if (proxy) {
            return jsonPostProxy(url, json, "UTF-8", null, proxyHost, proxyPort);
        }
        return jsonPost(url, json, "UTF-8", null);
    }


    public static String jsonPost(String url, String json, Integer connectTimeout, boolean proxy, String proxyHost, Integer proxyPort) {
        if (proxy) {
            return jsonPostProxy(url, json, "UTF-8", connectTimeout, proxyHost, proxyPort);
        }
        return jsonPost(url, json, "UTF-8", connectTimeout);
    }


    public static String jsonPost(String url, String json, String charsetEncoding) {
        URI uri = URI.create(url);
        return jsonPost(uri, json, charsetEncoding, null);
    }


    public static String jsonPost(String url, String json, String charsetEncoding, Integer connectTimeout) {
        URI uri = URI.create(url);
        return jsonPost(uri, json, charsetEncoding, connectTimeout);
    }

    public static String jsonPostProxy(String url, String json, Integer connectTimeout, String proxyHost, Integer proxyPort) {
        return jsonPostProxy(url, json, "UTF-8", connectTimeout, proxyHost, proxyPort);
    }


    public static String jsonPostProxy(String url, String json, String charsetEncoding, Integer connectTimeout, String proxyHost, Integer proxyPort) {
        URI uri = URI.create(url);
        return jsonPostProxy(uri, json, charsetEncoding, connectTimeout, proxyHost, proxyPort);
    }


    public static String jsonPost(URI uri, String json, String charsetEncoding, Integer connectTimeout) {
        HttpClient httpClient = HttpClients.createDefault();
        return doJsonPost(uri, httpClient, json, charsetEncoding, connectTimeout);
    }


    public static String xmlPostProxy(String url, String xml, String proxyHost, Integer proxyPort) {
        return xmlPostProxy(url, xml, "UTF-8", null, proxyHost, proxyPort);
    }


    public static String xmlPostProxy(String url, String xml, Integer connectTimeout, String proxyHost, Integer proxyPort) {
        return xmlPostProxy(url, xml, "UTF-8", connectTimeout, proxyHost, proxyPort);
    }

    public static String xmlPostProxy(String url, String xml, String charsetEncoding, Integer connectTimeout, String proxyHost, Integer proxyPort) {
        URI uri = URI.create(url);
        return xmlPostProxy(uri, xml, charsetEncoding, connectTimeout, proxyHost, proxyPort);
    }

    public static String xmlPost(String url, String xml, String charsetEncoding, Integer connectTimeout, boolean proxy, String proxyHost, Integer proxyPort) {
        if (proxy) {
            return xmlPostProxy(url, xml, charsetEncoding, connectTimeout, proxyHost, proxyPort);
        }
        return xmlPost(url, xml, charsetEncoding, connectTimeout);
    }


    public static String xmlPost(String url, String xml, Integer connectTimeout, boolean proxy, String proxyHost, Integer proxyPort) {
        if (proxy) {
            return xmlPostProxy(url, xml, connectTimeout, proxyHost, proxyPort);
        }
        return xmlPost(url, xml, connectTimeout);
    }


    public static String xmlPost(String url, String xml) {
        return xmlPost(url, xml, "UTF-8", null);
    }

    public static String xmlPost(String url, String xml, Integer connectTimeout) {
        return xmlPost(url, xml, "UTF-8", connectTimeout);
    }


    public static String xmlPost(String url, String xml, String charsetEncoding) {
        URI uri = URI.create(url);
        return xmlPost(uri, xml, charsetEncoding, null);
    }


    public static String xmlPost(String url, String xml, String charsetEncoding, Integer connectTimeout) {
        URI uri = URI.create(url);
        return xmlPost(uri, xml, charsetEncoding, connectTimeout);
    }


    public static String xmlPost(URI uri, String xml, String charsetEncoding, Integer connectTimeout) {
        HttpClient httpClient = HttpClients.createDefault();
        return doXmlPost(uri, httpClient, xml, charsetEncoding, connectTimeout);
    }




    public static void main(String[] args) throws Exception {
        //CryptoUtils desCrypto = new CryptoUtils();
        HashMap<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("userID", "admin");
        paramMap.put("password", "founder");
        paramMap.put("version", "1.0");
        paramMap.put("ismi", "123");
        paramMap.put("serviceName", "userLogin");

        final HashMap<String, String> map = new HashMap<String, String>();
        //CryptoUtils.encryptParams(map, paramMap);
        map.put("access_token", "g1-XgBh8GQVIpIj3u_GYj8d8I4hRbelGuPqVtQ-IkQvKuHHI-MrpAKX1lxnbAYVaKjmXBtteVHV_FmUDlPm_VtNxDo3JraayKcWjFoE76LQ");
        map.put("openid", "os712wgj6-95tMtV6Td4BLZsIEGg");

		/*//String result = HttpClientUtil.sslHttpGet("https://www.baidu.com/?tn=91485939_hao_pg", map);
        //如果当前订单号没有生成过prepayId，则正常流程先统一下单得到prepayId,再封装返回唤起微信支付的数据
        String nonceStr = PayCommonUtil.CreateNoncestr();
		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("appid", "wx03c92eec4fc7c9d1");
        parameters.put("body", "蓄牧电商");//商品描述，例：腾讯-游戏/蓄牧电商
        parameters.put("mch_id", "1443207302");
        parameters.put("nonce_str", nonceStr);
        parameters.put("notify_url", "http://mfinanc.hk1.mofasuidao.cn/pay/wechatPayAsynCallBack.html"); // 回调地址
        parameters.put("openid", "oyhccv8GpEQZS_awK5qIu10gTCb4");
        parameters.put("out_trade_no", "123321123");
        parameters.put("spbill_create_ip", "127.0.0.1");
        parameters.put("total_fee", 100);
        parameters.put("trade_type", "JSAPI");
        parameters.put("time_start", DateFormatUtil.convertCurrentDate("yyyyMMddHHmmss"));
        //parameters.put("time_expire", DateFormatUtil.convertDate(expireTime, "yyyyMMddHHmmss"));
        String sign = PayCommonUtil.createSign("UTF-8", parameters, "QAZWSXEDCRFVTGBYHNUJMIKOLPLOKMIJ");
        parameters.put("sign", sign);
		*/
        //String requestXML = PayCommonUtil.getRequestXml(parameters);
        Map<String, String> aMap = new HashMap<>();
        String result = HttpClientUtil.jsonPost("https://test1.jytpay.com:8080/pay/unifiedorder", "", 1000 * 3);
        result = HttpClientUtil.httpPost("https://test1.jytpay.com:8080/pay/unifiedorder", aMap,1000*10);
        System.out.println(result);
        //Map<String, Object> respData = PayCommonUtil.doXMLParse(result);
        //System.out.println(respData.toString());
//		Map<String,Object> resultMap = JsonUtils.fromJson(result, Map.class);
//		System.out.println(resultMap.get("errcode"));
//		if(!"0".equals(resultMap.get("errcode").toString())){
//			System.err.println(resultMap.get("errcode"));
//		}
//		
//		for (int i = 0; i < 1000; i++) {
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					String result = httpPost("http://127.0.0.1:8081/lucky/openLuckyMoney.json?id=73c08160f38e44c0a382b68360e9c5c3&token=Bg4wNwKmrr9XfMUn5vWxidPf7VCTRzlRKCLFpK461i2oaKUeTjmU25170raa5LlR2ahv3jGJC4n2DnQbD-zUY6_kTvx3h-siTbsuUozbnmzcqNJzhL1QdCPgNDcVmIr4", map, "UTF-8");
//					System.out.println(result);
//				}
//			}).start();
//		}  
    }
//
//	public static void encryptParams(Map<String, String> target, HashMap<String, String> source) {
//		DESPlus desCrypto = new DESPlus();
//		if (source != null) {
//			for (String keyset : source.keySet()) {
//				target.put(keyset, desCrypto.encrypt((String) source.get(keyset)));
//			}
//		}
//	}


}