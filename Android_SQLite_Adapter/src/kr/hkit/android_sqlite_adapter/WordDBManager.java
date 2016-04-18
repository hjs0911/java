package kr.hkit.android_sqlite_adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class WordDBManager extends SQLiteOpenHelper {
	private final static String DATABASE_NAME = "EngWordSecond.db";
	private final static String TABLE_NAME = "dic";
	private final static int DATABASE_VER = 1;

	private static WordDBManager instance;

	private WordDBManager(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	public static WordDBManager getInstance(Context context) {
		if(instance == null){
			instance = new WordDBManager(context, DATABASE_NAME, null, DATABASE_VER);
		}
		return instance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table if not exists dic("
				+ "_id integer primary key autoincrement,"
				+ "eng text,"
				+ "han text"
				+ ");";
		db.execSQL(sql);
		db.execSQL("insert into dic values(null, 'girl', '소녀');");
		db.execSQL("insert into dic values(null, 'boy', '소년');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists dic");
		onCreate(db);
	}
	
	public long insert(ContentValues addRowValue){
		return getWritableDatabase().insert(TABLE_NAME, null, addRowValue);
	}
	
	public int update(ContentValues updateRowValue, String whereClause, String[] whereArgs){
		return getWritableDatabase().update(TABLE_NAME, updateRowValue, whereClause, whereArgs);
	}
	
	public int delete(String whereClause, String[] whereArgs){
		return getWritableDatabase().delete(TABLE_NAME, whereClause, whereArgs);
	}
	
	public Cursor select(String[] columns, String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy){
		return getReadableDatabase().query(TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy);
	}

}
