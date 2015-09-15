package com.qingbo.ginkgo.common.util.access;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public String post(String url) {
		String result = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(url);
			List <NameValuePair> params = new ArrayList<NameValuePair>();  
	        params.add(new BasicNameValuePair("ak", "sTKmoGmE9LLaOdHuTUF0f9NE1ejnvMFACG"));
	        params.add(new BasicNameValuePair("openid", "11223366"));
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
	
	public static void main(String[] args) {
		/*String queryUrl = "http://sdk.mobilesell.cn/ws/SelSum.aspx?CorpID=CQLKJ0003513&Pwd=cn888";
		System.out.println(HttpAccess.getInstance().get(queryUrl));
		String sendUrl = "http://sdk.mobilesell.cn/ws/BatchSend.aspx?CorpID=CQLKJ0003513&Pwd=cn888&Mobile=18623193509&Content=YouAreHandsome";
		System.out.println(HttpAccess.getInstance().get(sendUrl));
		try {
			System.out.println(URLEncoder.encode("http://sdk.mobilesell.cn/ws/SelSum.aspx?CorpID=CQLKJ0003513&Pwd=cn888中通", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String queryUrl = "http://120.25.215.147:9000/runUser/findByOpenid.json";
		System.out.println(HttpAccess.getInstance().post(queryUrl));
	}
}
