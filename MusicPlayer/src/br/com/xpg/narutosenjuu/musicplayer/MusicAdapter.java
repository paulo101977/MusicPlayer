package br.com.xpg.narutosenjuu.musicplayer;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MusicAdapter extends BaseAdapter {
	
	private Cursor cursor;
	
	public MusicAdapter(Cursor cursor){
		
	}

	@Override
	public int getCount() {
		return cursor.getCount();
	}

	@Override
	public Object getItem(int index) {
		return index;
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
