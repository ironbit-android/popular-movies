package pe.ironbit.android.popularmovies.storage.base;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Contract for the movie favorite functionality.
 */
public final class MovieStorageContract {
    /**
     * Unique constructor.
     * No instantiation.
     */
    private MovieStorageContract() {
    }

    /**
     * Loader identifier.
     */
    public static final int LOADER_IDENTIFIER = 1;

    /**
     * Path for the table
     */
    public static final String PATH_MOVIES = "movies";

    /**
     * Name of Content Provider
     */
    public static final String CONTENT_AUTHORITY = "pe.ironbit.android.popularmovies";

    /**
     * Base Uri to contact with the content provider
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     *
     */
    public static final class MovieStorageEntry implements BaseColumns {
        /**
         * The content URI to access the movies in the provider
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_MOVIES);

        /**
         * The MIME type of the {@link #BASE_CONTENT_URI} for a list of movies.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIES;

        /**
         * The MIME type of the {@link #BASE_CONTENT_URI} for a single movie.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIES;

        /**
         * Name of database table.
         */
        public static final String TABLE_NAME = "movies";

        /**
         * Name of the movie.
         *
         * Type: TEXT
         */
        public static final String COL_MOVIE_TITLE = "title";

        /**
         * Poster path of the movie.
         *
         * Type: TEXT
         */
        public static final String COL_MOVIE_POSTER = "poster";

        /**
         * Overview of the movie.
         *
         * Type: TEXT
         */
        public static final String COL_MOVIE_OVERVIEW = "overview";

        /**
         * Rating of the movie.
         *
         * Type: Real
         */
        public static final String COL_MOVIE_RATING = "rating";

        /**
         * Release date of the movie.
         *
         * Type: TEXT
         */
        public static final String COL_MOVIE_DATE = "date";
    }
}
