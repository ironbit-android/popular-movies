package pe.ironbit.android.popularmovies.storage.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pe.ironbit.android.popularmovies.storage.base.MovieStorageContract.MovieStorageEntry;

/**
 * Database initialization.
 */
public class MovieStorageHelper extends SQLiteOpenHelper {
    /**
     * Database name
     */
    private static final String DATABASE_NAME = "movies_database.db";

    /**
     * Database version
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Unique constructor.
     */
    public MovieStorageHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Create database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String statement = "CREATE TABLE " + MovieStorageEntry.TABLE_NAME + " ("
                + MovieStorageEntry._ID + " TEXT PRIMARY KEY, "
                + MovieStorageEntry.COL_MOVIE_TITLE + " TEXT NOT NULL, "
                + MovieStorageEntry.COL_MOVIE_POSTER + " TEXT NOT NULL, "
                + MovieStorageEntry.COL_MOVIE_OVERVIEW + " TEXT NOT NULL, "
                + MovieStorageEntry.COL_MOVIE_RATING + " REAL NOT NULL, "
                + MovieStorageEntry.COL_MOVIE_DATE + " TEXT NOT NULL);";

        db.execSQL(statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
