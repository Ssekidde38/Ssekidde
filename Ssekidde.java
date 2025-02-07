package com.a143fd.ssekidde;
import android.provider.*;
import android.database.*;
import android.content.*;
import android.net.*;
import java.util.*;
import android.media.*;
import android.annotation.*;

public class Ssekidde
{
	static private Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
	static private Cursor cursor;
	private Context context;
	private String[] projection={
		MediaStore.Audio.Media.ALBUM,
		MediaStore.Audio.Media.DATA,
		MediaStore.Audio.Media.ARTIST,
		MediaStore.Audio.Media.TITLE

	};
	public void initialize(Context context){
		this.context=context;
		cursor=context.getContentResolver().query(uri,projection,null,null,null,null);
	}

	public void getTitle(ArrayList<String> arrayList){
		while(cursor.moveToNext()){
			int columnIndex =  cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE);
			arrayList.add(cursor.getString(columnIndex));
		}
	}

	public void getArtist(ArrayList<String> arrayList){
		while(cursor.moveToNext()){
			int columnIndex =  cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST);
			arrayList.add(cursor.getString(columnIndex));
		}
	}

	public void getUri(ArrayList<String> arrayList){
		while(cursor.moveToNext()){
			int columnIndex =  cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
			arrayList.add(cursor.getString(columnIndex));
		}
	}

	public void getAlbum(ArrayList<String> arrayList){
		while(cursor.moveToNext()){
			int columnIndex =  cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM);
			arrayList.add(cursor.getString(columnIndex));
		}
	}

	public Cursor reader(){

		return this.cursor;
	}
}
