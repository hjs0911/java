package kr.hkit.android_sqlite_adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	private WordDBManager mDbmanager;
	private SimpleCursorAdapter cusorAdapter;

	private static final String[] COLUMNS = { "_id", "eng", "han" };
	private static final int[] TO = { R.id.listnum, R.id.listeng, R.id.listhan };

	private EditText insEngEdit, insHanEdit;
	private EditText delNumEdit;
	private EditText upNumEdit, upHanEdit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDbmanager = WordDBManager.getInstance(this);
		ListView list = (ListView) findViewById(R.id.word_list);

		Cursor cursor = mDbmanager.select(COLUMNS, null, null, null, null, null);
		startManagingCursor(cursor);
		cusorAdapter = new SimpleCursorAdapter(this, R.layout.list_row, cursor, COLUMNS, TO,
				cusorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		list.setAdapter(cusorAdapter);
		
		insEngEdit = (EditText) findViewById(R.id.et_insertEng);
		insHanEdit = (EditText) findViewById(R.id.et_insertHan);
		
		delNumEdit = (EditText) findViewById(R.id.et_deleteNum);
		
		upNumEdit = (EditText) findViewById(R.id.et_updateNum);
		upHanEdit = (EditText) findViewById(R.id.et_updateHan);
	}

	public void insertOnClick(View v) {
		ContentValues addRowValue = new ContentValues();
		addRowValue.put("eng", insEngEdit.getText().toString());
		addRowValue.put("han", insHanEdit.getText().toString());
		
		mDbmanager.insert(addRowValue);
		insEngEdit.setText("");
		insHanEdit.setText("");
		Toast.makeText(this, "추가되었습니다.", 0).show();
		selectDisplay();
	}

	public void deleteOnClick(View v) {
		String whereClause = "_id=?";
		String[] whereArgs = new String[1];
		whereArgs[0] = delNumEdit.getText().toString();
		mDbmanager.delete(whereClause, whereArgs);
		
		delNumEdit.setText("");
		Toast.makeText(this, "삭제되었습니다!!!", 0).show();
		selectDisplay();
	}

	public void updateOnClick(View v) {
		ContentValues updateRowValue = new ContentValues();
		updateRowValue.put("han", upHanEdit.getText().toString());
		
		String whereClause = "_id=?";
		String[] whereArgs = new String[1];
		whereArgs[0] = upNumEdit.getText().toString();
		
		mDbmanager.update(updateRowValue, whereClause, whereArgs);
		upHanEdit.setText("");
		upNumEdit.setText("");
		
		Toast.makeText(this, "변경되었습니다!!!", 0).show();
		selectDisplay();
	}

	public void selectOnClick(View v) {
		selectDisplay();
	}
	
	private void selectDisplay(){
		Cursor cursor = mDbmanager.select(COLUMNS, null, null, null, null, null);
		cusorAdapter.swapCursor(cursor);
	}
}
