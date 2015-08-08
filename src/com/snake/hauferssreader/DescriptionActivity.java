package com.snake.hauferssreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;

public class DescriptionActivity extends Activity{

	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.description);
		
		webView = (WebView) this.findViewById(R.id.webView);
		
		
		
		webView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS); 
		Intent intent = getIntent();
		Bundle bundle = intent.getBundleExtra("news");
		
		String title = bundle.getString("title");
		String description = bundle.getString("description");
		String link = bundle.getString("link");
		String punDate = bundle.getString("punDate");
		
		webView.loadDataWithBaseURL("about:blank" , description, "text/html","utf-8", null); 
	}

	
}
