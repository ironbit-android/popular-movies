package pe.ironbit.android.popularmovies.request.factory;

import android.net.Uri;

import pe.ironbit.android.popularmovies.request.base.WebRequestContract;

/**
 * Helper class that generates the uri for the web request.
 */
public final class MovieUriFactory {
    /**
     * Unique private constructor.
     */
    private MovieUriFactory() {
    }

    /**
     * Perform the generation of the uri.
     *
     * @param apiKey value required for access to movie database.
     * @param param  the movie path (popular or top_rated).
     * @return the uri (https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>).
     */
    public static Uri createMovieUri(String apiKey, String param) {
        return Uri.parse(WebRequestContract.REQUEST_MOVIE_BASE)
                  .buildUpon()
                  .appendPath(param)
                  .appendQueryParameter(WebRequestContract.REQUEST_PARAM_API_KEY, apiKey)
                  .build();
    }
}
