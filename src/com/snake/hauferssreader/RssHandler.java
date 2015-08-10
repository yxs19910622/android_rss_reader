package com.snake.hauferssreader;


import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class RssHandler extends DefaultHandler {

	private News news;
	private List<News> newsList;
	private String currentTag;
	
	public RssHandler() {
	}
	final String ITEM = "item";
	final String TITLE = "title";
	final String DESCRIPTION = "description";
	final String LINK = "link";
	final String PUBDATE = "pubDate";
	@Override
	public void startDocument() throws SAXException {
		// 当读到第一个标签的时候 触发方法
		newsList = new ArrayList<News>();
	}
	
	public List<News> getNewsList() {
		return newsList;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// 当遇到文档开头的时候 调用
		if(qName.equals(ITEM)){
			news = new News();
		}
		currentTag = qName;
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// 处理xml文件所读取到的内容
		String data = new String(ch, start, length);
		 
			
			
		if(news!=null){
			
			if(currentTag.equals(TITLE)){
				if(news.getTitle()!=null){
					String l = news.getTitle();
					news.setTitle(l+data);
				}else{
					news.setTitle(data);
				}
			} 
			if(currentTag.equals(DESCRIPTION)){
				if(news.getDescription()!=null){
					String l = news.getDescription();
					news.setDescription(l+data);
				}else{
					news.setDescription(data);
				}
			}
			if(currentTag.equals(LINK)){
				if(news.getLink()!=null){
					String l = news.getLink();
					news.setLink(l+data);
				}else{
					news.setLink(data);
				}
			}
			if(currentTag.equals(PUBDATE)){
				news.setPubDate(data);
			}
		}
			
		
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// 遇到结束标记时调用
		if(qName.equals(ITEM)){
			newsList.add(news);
		}
	}
	
}
