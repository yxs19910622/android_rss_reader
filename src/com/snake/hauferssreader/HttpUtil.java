package com.snake.hauferssreader;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUtil {
	
	public static InputStream getXml(String path){
		
		InputStream is = null;
		
		try {
			URL url = new URL(path);
			if(url!=null){
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(0);
				connection.setDoInput(true);
				connection.setRequestMethod("GET");
				int code = connection.getResponseCode();
				if(code==200){
					is = connection.getInputStream();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return is;
	}
}
