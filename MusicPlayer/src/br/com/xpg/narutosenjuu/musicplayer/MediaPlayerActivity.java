package br.com.xpg.narutosenjuu.musicplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MediaPlayerActivity extends Activity{
	
	private MediaPlayer player;
	public final static String BUNDLE_EXTRA = "bundle";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		player = new MediaPlayer();
	}
	
	public void play(View v){
		
	}
	
	public void stop(View v){
		
	}
	
	public void pause(View v){
		
	}
	
	//make factory
	public static Intent makeIntent(final Context context, final Bundle bundle)
	{
		//make the intent and set the bundle of data
		Intent intent = new Intent(context,MediaPlayerActivity.class);
		intent.putExtra(BUNDLE_EXTRA, bundle);//put the bundle
		return intent;
	}

}
