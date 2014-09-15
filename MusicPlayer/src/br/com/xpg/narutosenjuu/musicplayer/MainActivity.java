package br.com.xpg.narutosenjuu.musicplayer;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {
	
	//instance of MusicAdapter
	private MusicAdapter adapter;

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
		
		//debug
		if(cursor.moveToFirst()){
			do{
				Log.w("DEBUG", "" +
						cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media._ID)));
			}while(cursor.moveToNext());
		}
		
		//set the cursor adapter for this list view
		adapter = new MusicAdapter(cursor , this);
		listView.setAdapter(adapter);
		
		//set a listener for the ListView
		listView.setOnItemClickListener(this);
		
	}

	//when user click on item on ListView , it's open a Activity for play the music
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		//new bundle
		Bundle bundle = new Bundle();
		
		//get the specific music on ListView
		Music music = (Music)adapter.getItem(position);
		
		//put all music data on bundle
		putData(bundle, music);
		
		//start the music player and send the bundle for activity player
		startActivity(MediaPlayerActivity.makeIntent(this, bundle));
		
	}

	//put all data on music on the bundle
	private void putData(Bundle bundle, Music music) {
		bundle.putInt(Music._ID, music.getId());
		bundle.putString(Music.NAME, music.getName());
		bundle.putString(Music.URL, music.getUrl());
	}

}
