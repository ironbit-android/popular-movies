package pe.ironbit.android.popularmovies.model.movie;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;

import pe.ironbit.android.popularmovies.storage.base.MovieStorageContract.MovieStorageEntry;

/**
 * Helper class for MovieData.
 * It associates data with database.
 */
public class MovieMapper {
    /**
     * When column not found in cursor class.
     */
    private static final int NON_INDEX = -1;

    /**
     * Projection array for MovieData.
     */
    private static String[] mProjection = {
            MovieStorageEntry._ID,
            MovieStorageEntry.COL_MOVIE_TITLE,
            MovieStorageEntry.COL_MOVIE_POSTER,
            MovieStorageEntry.COL_MOVIE_OVERVIEW,
            MovieStorageEntry.COL_MOVIE_RATING,
            MovieStorageEntry.COL_MOVIE_DATE
    };

    public static Loader<Cursor> query(Context context) {
        return new CursorLoader(context, MovieStorageEntry.CONTENT_URI, mProjection, null, null, null);
    }

    public static Loader<Cursor> query(Context context, long id) {
        Uri uri = ContentUris.withAppendedId(MovieStorageEntry.CONTENT_URI, id);
        return new CursorLoader(context, uri, mProjection, null, null, null);
    }

    public static Uri insert(ContentResolver resolver, MovieData data) {
        return resolver.insert(MovieStorageEntry.CONTENT_URI, generateValues(data));
    }

    public static int delete(ContentResolver resolver, MovieData data) {
        Uri uri = ContentUris.withAppendedId(MovieStorageEntry.CONTENT_URI, Integer.parseInt(data.getId()));
        return resolver.delete(uri, null, null);
    }

    public static MovieData generateData(Cursor cursor) {
        int index = 0;
        MovieBuilder builder = new MovieBuilder();

        index = cursor.getColumnIndex(MovieStorageEntry._ID);
        if (index != NON_INDEX) {
            builder.setId(cursor.getString(index));
        }

        index = cursor.getColumnIndex(MovieStorageEntry.COL_MOVIE_TITLE);
        if (index != NON_INDEX) {
            builder.setOriginalTitle(cursor.getString(index));
        }

        index = cursor.getColumnIndex(MovieStorageEntry.COL_MOVIE_POSTER);
        if (index != NON_INDEX) {
            builder.setPosterPath(cursor.getString(index));
        }

        index = cursor.getColumnIndex(MovieStorageEntry.COL_MOVIE_OVERVIEW);
        if (index != NON_INDEX) {
            builder.setOverview(cursor.getString(index));
        }

        index = cursor.getColumnIndex(MovieStorageEntry.COL_MOVIE_RATING);
        if (index != NON_INDEX) {
            builder.setVoteAverage(cursor.getDouble(index));
        }

        index = cursor.getColumnIndex(MovieStorageEntry.COL_MOVIE_DATE);
        if (index != NON_INDEX) {
            builder.setReleaseDate(cursor.getString(index));
        }

        return builder.build();
    }

    private static ContentValues generateValues(MovieData data) {
        ContentValues values = new ContentValues();

        values.put(MovieStorageEntry._ID, data.getId());
        values.put(MovieStorageEntry.COL_MOVIE_TITLE, data.getOriginalTitle());
        values.put(MovieStorageEntry.COL_MOVIE_POSTER, data.getPosterPath());
        values.put(MovieStorageEntry.COL_MOVIE_OVERVIEW, data.getOverview());
        values.put(MovieStorageEntry.COL_MOVIE_RATING, data.getVoteAverage());
        values.put(MovieStorageEntry.COL_MOVIE_DATE, data.getReleaseDate());

        return values;
    }
}
