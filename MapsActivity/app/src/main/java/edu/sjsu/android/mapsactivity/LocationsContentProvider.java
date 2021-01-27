package edu.sjsu.android.mapsactivity;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LocationsContentProvider extends ContentProvider {

    public static final String PROVIDER_NAME = "edu.sjsu.android.locations";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/locations");
    private static final int LOCATIONS = 1;
    private static final UriMatcher uriMatcher;
    LocationsDB dataLocations;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "locations", LOCATIONS);
    }

    @Override
    public boolean onCreate() {
        dataLocations = new LocationsDB(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        if(uriMatcher.match(uri)==LOCATIONS){
            return dataLocations.getLocations();
        }
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        long rowID = dataLocations.insert(contentValues);
        Uri u=null;
        if(rowID > 0) {
            u = ContentUris.withAppendedId(CONTENT_URI, rowID);
        }
        else {
            try {
                throw new SQLException("Failed to insert : " + uri);
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return u;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        int count = 0;
        count = dataLocations.del();
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}