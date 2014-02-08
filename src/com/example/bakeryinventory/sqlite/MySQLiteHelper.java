package com.example.bakeryinventory.sqlite;

import java.util.LinkedList;
import java.util.List;

import com.example.bakerinventory.model.Item;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper{
	
	private static final int db_version = 1;
	private static final String db_name = "BakeryDB";
	
	private static final String TABLE_ITEMS = "items";
	
	 private static final String KEY_ID = "id";
	 private static final String KEY_NAME = "name";
	 private static final String KEY_BRAND = "brand";
	 private static final String KEY_SIZE = "id";
	 private static final String KEY_UNIT = "name";
	 private static final String KEY_LAST = "last_check";
	 private static final String KEY_AMT = "amount";
	 private static final String KEY_COST = "cost";

	 private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_BRAND, KEY_SIZE, KEY_UNIT,
		 KEY_LAST, KEY_AMT, KEY_COST};
	
	public MySQLiteHelper(Context context) {
		super(context, db_name, null, db_version);	
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		String CREATE_ITEM_TABLE = "CREATE TABLE items ( "+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
	+ "brand VARCHAR, " + "name VARCHAR, " + "size INTEGER, " + "unit VARCHAR, " + 
	"last_check VARCHAR, " + "amount INTEGER, " + "cost INTEGER)";
		
		//execute above code in SQL
		db.execSQL(CREATE_ITEM_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		//drop older db if new one exists
		db.execSQL("DROP TABLE IF EXISTS items");

		this.onCreate(db);
	}
	
	public void addItem(Item item){
		Log.d("addItem", item.toString());
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, item.getName());
		values.put(KEY_BRAND, item.getBrand());
		values.put(KEY_SIZE, item.getSize());
		values.put(KEY_UNIT, item.getSize_unit());
		values.put(KEY_LAST, item.getLast_check());
		values.put(KEY_AMT, item.getAmount());
		values.put(KEY_COST, item.getCost());
		
        db.insert(TABLE_ITEMS, null, values); 
        
        db.close(); 
	}
	
	public Item getItem(int id){

		SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = 
        		db.query(TABLE_ITEMS, // a. table
        		COLUMNS, // b. column names
        		" id = ?", // c. selections 
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        //if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        Item item = new Item();
        item.setId(Integer.parseInt(cursor.getString(0)));
        item.setName(cursor.getString(1));
        item.setBrand(cursor.getString(2));
        item.setSize(Integer.parseInt(cursor.getString(3)));
        item.setSize_unit(cursor.getString(4));
        item.setLast_check(cursor.getString(5));
        item.setAmount(Integer.parseInt(cursor.getString(6)));
        item.setCost(Integer.parseInt(cursor.getString(7)));

	Log.d("getItem("+id+")", item.toString());

        return item;
	}
	
	 public List<Item> getAllItems() {
	        List<Item> items = new LinkedList<Item>();

	        String query = "SELECT  * FROM " + TABLE_ITEMS;

	        SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(query, null);

	        //go over each row, build Item and add it to list
	        Item item = null;
	        if (cursor.moveToFirst()) {
	            do {
	            	item = new Item();
	            	item.setId(Integer.parseInt(cursor.getString(0)));
	                item.setName(cursor.getString(1));
	                item.setBrand(cursor.getString(2));
	                item.setSize(Integer.parseInt(cursor.getString(3)));
	                item.setSize_unit(cursor.getString(4));
	                item.setLast_check(cursor.getString(5));
	                item.setAmount(Integer.parseInt(cursor.getString(6)));
	                item.setCost(Integer.parseInt(cursor.getString(7)));

	                items.add(item);
	            } while (cursor.moveToNext());
	        }

			Log.d("getAllItems()", items.toString());

	        // return Items
	        return items;
	    }
	 
	 public int updateItem(Item item) {

	        SQLiteDatabase db = this.getWritableDatabase();

			//create ContentValues to add key "column"/value
	        ContentValues values = new ContentValues();
	        values.put(KEY_NAME, item.getName());
			values.put(KEY_BRAND, item.getBrand());
			values.put(KEY_SIZE, item.getSize());
			values.put(KEY_UNIT, item.getSize_unit());
			values.put(KEY_LAST, item.getLast_check());
			values.put(KEY_AMT, item.getAmount());
			values.put(KEY_COST, item.getCost());

	        int i = db.update(TABLE_ITEMS, values, KEY_ID+" = ?", new String[] 
	        		{ String.valueOf(item.getId()) }); //selection args

	        db.close();

	        return i;

	    }
	 
	 public void deleteItem(Item item) {

	        SQLiteDatabase db = this.getWritableDatabase();

	        db.delete(TABLE_ITEMS, KEY_ID+" = ?", new String[] 
	        		{ String.valueOf(item.getId()) }); //selections args

	        db.close();

		Log.d("deleteItem", item.toString());

	    }
	
}
