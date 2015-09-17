package com.qingbo.ginkgo.common.util.access;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpAccess {

	private static HttpAccess instance;

	public static HttpAccess getInstance() {
		if (instance == null) {
			instance = new HttpAccess();
		}
		return instance;
	}

	private HttpAccess() {
		super();
	}

	public String get(String url) {
		String result = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet(url);
//			String str = "Mozilla/5.0 (Linux; U; Android 2.3; zh-CN; MI-ONEPlus) AppleWebKit/534.13 (KHTML, like Gecko)  UCBrowser/8.6.0.199 U3/0.8.0 Mobile Safari/534.13";
//			httpGet.setHeader("user-agent", str);        // 设置浏览器UA
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public String post(String url, Map<String, String> map) {
		String result = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(url);
			
			List <NameValuePair> params = new ArrayList<NameValuePair>();
			for (String key : map.keySet()) {
				params.add(new BasicNameValuePair(key,	map.get(key)));
			}
	        httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
