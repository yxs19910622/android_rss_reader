package com.snake.hauferssreader;


import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import android.util.Log;

public class SaxFactory {

	public static List<News> readXml(InputStream is){
		
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			RssHandler rssHandler = new RssHandler();
			saxParser.parse(is, rssHandler);
			is.close();
			return rssHandler.getNewsList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
}
