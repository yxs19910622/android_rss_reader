package com.snake.hauferssreader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	

	private Button button;

	private ListView listView;

	private ArrayAdapter<String> arrayAdapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		String path = "http://news.163.com/special/00011K6L/rss_gn.xml";
		InputStream is = HttpUtil.getXml(path);
		List<News> newsList = SaxFactory.readXml(is, "item");
		listView = (ListView) this.findViewById(R.id.list);
		List<String> titles = new ArrayList<String>(newsList.size());
		for (News news : newsList) {
			titles.add(news.getTitle());
		}
		arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
				R.layout.title, titles);
		listView.setAdapter(arrayAdapter);
		

	}



}
