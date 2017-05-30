package pe.ironbit.android.popularmovies.contract;

import android.text.TextUtils;

/**
 * It is used to select which web request will be performed.
 */
public final class MovieContract {
    /**
     * Private unique constructor
     */
    private MovieContract() {
    }

    /**
     * Option popular movies.
     */
    public static String POPULAR_MOVIES = "Popular";

    /**
     * Option top rated movies.
     */
    public static String TOP_RATED_MOVIES = "Top Rated";

    /**
     * Option favorite movies.
     */
    public static String FAVORITE_MOVIES = "Favorite";

    /**
     * Key for saving state for the MainActivity.
     */
    public static String KEY_OPTION_MOVIES = "Option Movies";
}
