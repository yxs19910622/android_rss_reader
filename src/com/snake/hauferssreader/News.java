package com.snake.hauferssreader;


import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class News {
	//新闻实体类
	static SimpleDateFormat FORMATTER = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.UK);
	private String title;
	private String description;
	private URL link;
	private Date pubDate;
	
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
	public URL getLink() {
		return link;
	}
	public void setLink(String l) {
		try {
			this.link = new URL(l);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(String date) {
		
		try {
			this.pubDate = FORMATTER.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String strs = "<title:"+title+"><description:"+description+"><link:"+link+"><pubDate:"+pubDate;
		return strs;
	}
}
