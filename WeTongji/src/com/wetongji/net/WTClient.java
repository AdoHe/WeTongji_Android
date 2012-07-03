/**
 * 
 */
package com.wetongji.net;

import java.net.URI;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author hezibo
 *
 */
public class WTClient 
{
	private static WTClient client = null;
	
	private HttpClient httpClient;
	private HttpGet request;
	
	private boolean hasError;
	private String errorDesc;
	private int responseStatusCode;
	private boolean sessionRequired;
	
	private Map<String, String> params;
	
	private static String APIDomain = "http://we.tongji.edu.cn/api/call";
	
	//ʵ�ֵ���ģʽ
	private WTClient()
	{
		httpClient = new DefaultHttpClient();
		request = new HttpGet();
		hasError = false;
		sessionRequired = false;
		errorDesc = null;
		responseStatusCode = 0;
		params = new HashMap<String, String>();
		params.put("D", "android");
		params.put("V", "1.0");
	}
	public static synchronized WTClient getInstance()
	{
		if(client == null)
			client = new WTClient();
		return client;
	}
	
	//��������MD5 HASHɢ��ֵ
	public String hashQueryString(String s)
	{
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',   
				  'a', 'b', 'c', 'd', 'e', 'f' };   
		  try {   
			   byte[] strTemp = s.getBytes();   
			   //ʹ��MD5����MessageDigest����   
			   MessageDigest mdTemp = MessageDigest.getInstance("MD5");   
			   mdTemp.update(strTemp);   
			   byte[] md = mdTemp.digest();   
			   int j = md.length;   
			   char str[] = new char[j * 2];   
			   int k = 0;   
			   for (int i = 0; i < j; i++) {   
				    byte b = md[i];   
				    //System.out.println((int)b);   
				    //��û����(int)b����˫�ֽڼ���   
				    str[k++] = hexDigits[b >> 4 & 0xf];   
				    str[k++] = hexDigits[b & 0xf];   
			   }   
			   return new String(str);   
		  } 
		  catch (Exception e) {
			  return null;
		  } 
	}
	
	//�γ������Ĳ�����
	public String queryString()
	{
		String str = "?";
		List<Map.Entry<String, String>> mappingList = new ArrayList<Map.Entry<String, String>>(params.entrySet());
		
		Collections.sort(mappingList, new Comparator<Map.Entry<String, String>>(){
					public int compare(Map.Entry<String, String> entry1, Map.Entry<String, String> entry2)
					{
						return entry1.getKey().compareTo(entry2.getKey());
					}
				}
				);
		
		for(Map.Entry<String, String> entry : mappingList)
		{
			str += entry.getKey() + "=" + entry.getValue();
			str += "&";
		}
		
		String subStr = str.substring(1, str.length() - 1);
		return subStr;
	}
	
	//�γ��µ�URLֵ
	public void buildURL() throws Exception
	{
		String queryStr = queryString();
		String hashStr = hashQueryString(queryStr);
		String url = APIDomain + "?" + queryStr + "&H=" + hashStr;
		
		URI finalURI = new URI(url);
		request.setURI(finalURI);
	}
	
	//ִ��request
	public void executeRequest() throws Exception
	{
		this.buildURL();
		HttpResponse response = httpClient.execute(request);
	}
	
	//�����û��˺�
	public void activeUser(String num, String name, String password) throws Exception
	{
		params.put("M", "User.Active");
		params.put("NO", num);
		params.put("Name", name);
		params.put("Password", password);
		this.executeRequest();
	}
	
	//��֤�û���¼
	public void login(String name, String password) throws Exception
	{
		params.put("M", "User.LogOn");
		params.put("NO", name);
		params.put("Password", password);
		this.sessionRequired = true;
		this.executeRequest();
	}
	
	//�޸��û�����
	public void updatePassword(String oldPassword, String newPassword) throws Exception
	{
		params.put("M", "User.Update.Password");
		params.put("Old", oldPassword);
		params.put("New", newPassword);
		this.sessionRequired = true;
		this.executeRequest();
	}
	
	//�û��ǳ�
	public void logout() throws Exception
	{
		params.put("M", "User.LogOut");
		this.executeRequest();
	}
	
	//�޸��û�ͷ��
	public void updateUserAvatar()
	{
		params.put("M", "User.Update.Avatar");
		this.sessionRequired = true;
	}
	
	//�޸��û�����
	public void updateUser()
	{
		params.put("M", "User.Update");
		this.sessionRequired = true;
	}
	
	//��ȡ�û���Ϣ
	public void getUser()
	{
		params.put("M", "User.Get");
		this.sessionRequired = true;
	}
}
