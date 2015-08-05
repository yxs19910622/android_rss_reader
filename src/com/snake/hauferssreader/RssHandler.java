package com.snake.hauferssreader;

import java.util.List;

import org.xml.sax.helpers.DefaultHandler;

public class RssHandler extends DefaultHandler {

	private News news;
	private List<News> newsList;
	
	final String ITEM = "item";
	final String TITLE = "title";
	final String DESCRIPTION = "description";
	final String LINK = "link";
	final String PUBDATE = "pubDate";
	
}
