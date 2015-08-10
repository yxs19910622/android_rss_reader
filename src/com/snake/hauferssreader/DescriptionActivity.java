package com.snake.hauferssreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.TextView;

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
		String head = "<head><style>img{max-width:100% !important;}</style></head>";
		String str = head + description;
		
		webView.loadDataWithBaseURL("about:blank" , str, "text/html","utf-8", null); 
	}

	
}
