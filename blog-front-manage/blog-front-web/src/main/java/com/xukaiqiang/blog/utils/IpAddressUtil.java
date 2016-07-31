package com.xukaiqiang.blog.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * @Description:(获取用户真实IP)
 * @author wang.zx
 * @date 2014-12-20 下午10:57:18
 * @version 1.0
 */
public class IpAddressUtil {

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String getAddressByIP(String strIP) {
		StringBuffer address=new  StringBuffer();
		try {
			URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + strIP);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = null;
			StringBuffer result = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();
				//将Json文件数据形成JSONObject对象
				JSONObject jsonObject = new JSONObject(result.toString());
				//获取JSONObject对象数据并打印
				 JSONObject jsonObject2=jsonObject.getJSONObject("data");
				 address.append(jsonObject2.getString("country"));
				 address.append(jsonObject2.getString("city"));
				 address.append(jsonObject2.getString("isp"));
		} catch (IOException e) {
			return "读取失败";
		}
		return address.toString();
	}
	public static void main(String[] args) {
		System.out.println(IpAddressUtil.getAddressByIP("122.71.97.168"));
	}
}
