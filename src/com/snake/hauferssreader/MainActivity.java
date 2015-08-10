package com.snake.hauferssreader;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	private Button button;

	private ListView listView;

	private List<News> newsList;

	private ArrayAdapter<String> arrayAdapter;

	private Handler handler = new Handler() {
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
		
		listView = getListView();
		new Thread() {

			@Override
			public void run() {
				String path = "http://www.zhihu.com/rss";
				InputStream is = HttpUtil.getXml(path);
				newsList = SaxFactory.readXml(is);
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

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		News news = newsList.get(position);
		//点击后跳转到详细页查看信息
		Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("title", news.getTitle());
		bundle.putString("description", news.getDescription());
		bundle.putString("link", news.getLink());
		bundle.putString("pubDate", news.getPubDate());
		intent.putExtra("news", bundle);
		startActivity(intent);
	}
	
	
	
	class MyAdapter extends BaseAdapter {
		
		List<String> titles;
		public MyAdapter (List<String> titles){
			this.titles = titles;
		}

		@Override
		public int getCount() {
			return titles.size();
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View contentView, ViewGroup arg2) {
			
			ViewHolder holder;
			View view;
			if(contentView == null) {
				holder = new ViewHolder();
				view = View.inflate(MainActivity.this, R.layout.title, null);
				holder.title = (TextView) view.findViewById(R.id.title);
				
				view.setTag(holder);
			}else {
				view = contentView;
				holder = (ViewHolder) view.getTag();
			}
			
			String titleStr = titles.get(position);
			holder.title.setText(titleStr);
			
			return view;
		}
		
	}
	
	class ViewHolder {
		TextView title;
	}

}

		
		
		/*Intent viewMessage = null;
		try {
			viewMessage = new Intent(
					Intent.ACTION_VIEW,
					Uri.parse(new URL(this.newsList.get(position).getLink()).toExternalForm()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.startActivity(viewMessage);*/

