package br.com.xpg.narutosenjuu.musicplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MusicAdapter extends BaseAdapter {

	private Cursor cursor;
	private Context context;

	public MusicAdapter(Cursor cursor , Context context) {
		this.cursor = cursor;
		this.context = context;
	}

	@Override
	public int getCount() {
		return cursor.getCount();
	}

	// get the Music on ListView when clicked in one item
	@Override
	public Object getItem(int position) {

		// move to element position
		if (cursor.moveToPosition(position)) {

			//get and return the music on cursor
			Music music = new Music(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media._ID)),
					cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)), //title
					cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))); //data url
			return music;
		}

		return null;
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	//inflate a layout and set this on list view
	@SuppressLint("ViewHolder") @Override
	public View getView(int position, View view, ViewGroup group) {
		// get layout inflater
		LayoutInflater inflater = (LayoutInflater)context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//inflate the layout
		View v = inflater.inflate(R.layout.activity_music_list, null);
		
		//get a music item on cursor
		Music music = (Music)getItem(position);
		
		//set the TextView with the music name
		TextView text = (TextView)v.findViewById(R.id.text_music_title);
		text.setText(music.getName());
		
		return v;
	}

}
