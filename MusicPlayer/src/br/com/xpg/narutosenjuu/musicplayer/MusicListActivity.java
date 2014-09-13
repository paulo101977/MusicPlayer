package br.com.xpg.narutosenjuu.musicplayer;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;

public class MusicListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//set the content view on activity
		setContentView(R.layout.activity_music_list);
		
		ListView listView = (ListView)findViewById(R.id.listMusic);

		//get instance of content resolver
		ContentResolver resolver = getContentResolver();

		//get all audio data stored on sdcard
		Cursor cursor = resolver.query(
				MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
				null);
		
		listView.setAdapter(new MusicAdapter(cursor));
		
	}

}
