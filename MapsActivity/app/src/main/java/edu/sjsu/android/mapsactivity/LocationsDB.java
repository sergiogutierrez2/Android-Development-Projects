package edu.sjsu.android.mapsactivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;


public class LocationsDB extends SQLiteOpenHelper {

    private static String dataBaseName = "dataBase";
    private static final String DATABASE_TABLE = "locations";
    private SQLiteDatabase sqlData;
    private static int VERSION = 1;
    public static final String LAT = "latitude";
    public static final String LNG = "longitude";
    public static final String ZOOM = "zoom";
    public static final String rowID = "k";

    public LocationsDB(Context context){
        super(context, dataBaseName, null, VERSION);
        this.sqlData = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       String sql = "create table " + DATABASE_TABLE + " ( " + rowID + " integer primary key autoincrement, " +
                                                          LNG + " double , " + LAT + " double , " +
                                                          ZOOM + " text " + " ) ";
       sqLiteDatabase.execSQL(sql);
    }

    public long insert(ContentValues contentValues) {
        long insert = sqlData.insert(DATABASE_TABLE, null, contentValues);
        return insert;
    }

    public int del() {
        int delete = sqlData.delete(DATABASE_TABLE, null, null);
        return delete;
    }

    public Cursor getLocations() {
        return sqlData.query(DATABASE_TABLE, new String[] {
                rowID, LAT, LNG, ZOOM }, null, null, null, null, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
