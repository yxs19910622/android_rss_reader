package com.snake.hauferssreader;


import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class News {
	//新闻实体类
	private String title;
	private String description;
	private String link;
	private String pubDate;
	
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public String getPubDate() {
		return pubDate;
	}



	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String strs = "<title:"+title+"><description:"+description+"><link:"+link+"><pubDate:"+pubDate;
		return strs;
	}
}
