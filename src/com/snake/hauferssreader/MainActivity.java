package com.snake.hauferssreader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	

	private Button button;
	private ListView listView;

	private ArrayAdapter<String> arrayAdapter;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			List<String> titles = (List<String>) msg.obj;
			
			
			arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
					R.layout.title, titles);
			listView.setAdapter(arrayAdapter);
		};
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ListView) this.findViewById(R.id.list);
		new Thread() {
			
			@Override
			public void run() {
				String path = "http://www.zhihu.com/rss";
//				String path = "http://rss.haufe.cn";
				InputStream is = HttpUtil.getXml(path);
				if(is==null){
					Log.i("snake", "null值");
				}else{
					Log.i("snake", "success");
				}
				List<News> newsList = SaxFactory.readXml(is, "item");
				List<String> titles = new ArrayList<String>(newsList.size());
				for (News news : newsList) {
					titles.add(news.getTitle());
				}
				
				
				
				
				Message message = Message.obtain();
				message.what = 1;
				message.obj = titles;
				handler.sendMessage(message);
				
				
			}
		}.start();

	}
}

