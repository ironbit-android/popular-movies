package pe.ironbit.android.popularmovies.request.base;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import pe.ironbit.android.popularmovies.contract.MovieContract;
import pe.ironbit.android.popularmovies.request.factory.MovieUriFactory;
import pe.ironbit.android.popularmovies.request.parser.MovieWebRequestParser;
import pe.ironbit.android.popularmovies.request.parser.WebRequestParser;

/**
 * Implements the service for retrieve from the movie database (web
 * request) the popular movies or top rated movies.
 */
public class MovieWebRequestService implements WebRequestService {
    /**
     * Tag for log messages.
     */
    public static final String TAG = MovieWebRequestService.class.getSimpleName();

    /**
     * Perform the web request.
     * Create the uri and the appropriate parser for the response.
     *
     * @param apiKey value required for access to movie database.
     * @param param  selector for popular ot top_rated movie.
     * @return collection of MovieData.
     */
    @Override
    public List makeWebRequest(String apiKey, String param) {
        if (param == null) {
            Log.v(TAG, "param is null");
            return null;
        }

        if (TextUtils.equals(MovieContract.POPULAR_MOVIES, param)) {
            Uri uri = MovieUriFactory.createMovieUri(apiKey, WebRequestContract.REQUEST_MOVIE_POPULAR_PATH);
            WebRequestParser parser = new MovieWebRequestParser();
            return WebRequestHelper.makeWebRequest(uri, parser);
        }
        if (TextUtils.equals(MovieContract.TOP_RATED_MOVIES, param)) {
            Uri uri = MovieUriFactory.createMovieUri(apiKey, WebRequestContract.REQUEST_MOVIE_TOP_RATED_PATH);
            WebRequestParser parser = new MovieWebRequestParser();
            return WebRequestHelper.makeWebRequest(uri, parser);
        }
        Log.v(TAG, "param is not processed: " + param);
        return null;
    }
}
