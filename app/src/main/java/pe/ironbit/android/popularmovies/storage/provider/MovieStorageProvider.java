package pe.ironbit.android.popularmovies.storage.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import pe.ironbit.android.popularmovies.storage.base.MovieStorageContract;
import pe.ironbit.android.popularmovies.storage.base.MovieStorageContract.MovieStorageEntry;
import pe.ironbit.android.popularmovies.storage.base.MovieStorageHelper;

/**
 * Unique provider for the application.
 */
public class MovieStorageProvider extends ContentProvider {
    /**
     * Tag for log messages.
     */
    public static final String TAG = MovieStorageProvider.class.getSimpleName();

    /**
     * URI matcher code for the content URI for the table
     */
    private static final int MOVIES = 100;

    /**
     * URI matcher code for the content URI for a single row in the table
     */
    private static final int MOVIE_ID = 101;

    /**
     * UriMatcher object to match a content URI to a corresponding code.
     */
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        /**
         * Map integer code to provide access to multiple rows in the table
         */
        sUriMatcher.addURI(MovieStorageContract.CONTENT_AUTHORITY, MovieStorageContract.PATH_MOVIES, MOVIES);

        /**
         * Map integer code to provide access to a single row in the table using the ID
         */
        sUriMatcher.addURI(MovieStorageContract.CONTENT_AUTHORITY, MovieStorageContract.PATH_MOVIES + "/#", MOVIE_ID);
    }

    /**
     * Database Helper.
     */
    private MovieStorageHelper mMovieStorageHelper;

    @Override
    public boolean onCreate() {
        mMovieStorageHelper = new MovieStorageHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case MOVIES:
                return MovieStorageEntry.CONTENT_LIST_TYPE;
            case MOVIE_ID:
                return MovieStorageEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database = mMovieStorageHelper.getReadableDatabase();

        Cursor cursor = null;
        int match = sUriMatcher.match(uri);
        switch (match) {
            case MOVIE_ID:
                selection = MovieStorageEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
            case MOVIES:
                cursor = database.query(MovieStorageEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final int match = sUriMatcher.match(uri);
        if (match != MOVIES) {
            throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }

        SQLiteDatabase database = mMovieStorageHelper.getWritableDatabase();
        long id = database.insert(MovieStorageEntry.TABLE_NAME, null, values);
        if (id == -1) {
            Log.e(TAG, "Failed to insert row for " + uri);
            return null;
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int deleted = 0;
        final int match = sUriMatcher.match(uri);
        SQLiteDatabase database = mMovieStorageHelper.getWritableDatabase();

        switch (match) {
            case MOVIE_ID:
                selection = MovieStorageEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
            case MOVIES:
                deleted = database.delete(MovieStorageEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }

        if (deleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return deleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int updated = 0;
        final int match = sUriMatcher.match(uri);
        SQLiteDatabase database = mMovieStorageHelper.getWritableDatabase();

        switch (match) {
            case MOVIE_ID:
                selection = MovieStorageEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
            case MOVIES:
                updated = database.update(MovieStorageEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Update is not supported for " + uri);
        }

        if (updated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return updated;
    }
}
