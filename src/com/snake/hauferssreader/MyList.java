package com.snake.hauferssreader;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ListView;

public class MyList extends ListActivity {

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		URL link = null;
		try {
			link = new URL("123");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Intent viewMessage = new Intent(
				Intent.ACTION_VIEW,
				Uri.parse(link.toExternalForm()));
		this.startActivity(viewMessage);
	}

}
