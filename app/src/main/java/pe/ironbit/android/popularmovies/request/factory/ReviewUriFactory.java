package pe.ironbit.android.popularmovies.request.factory;

import android.net.Uri;

import pe.ironbit.android.popularmovies.request.base.WebRequestContract;

/**
 * Helper class that generates the uri for the web request.
 */
public final class ReviewUriFactory {
    /**
     * Unique private constructor.
     */
    private ReviewUriFactory() {
    }

    /**
     * Perform the generation of the uri.
     *
     * @param apiKey  value required for access to movie database.
     * @param movieId the movie id value.
     * @return the uri (https://api.themoviedb.org/3/movie/{movie_id}/reviews?api_key=<<api_key>>).
     */
    public static Uri createReviewUri(String apiKey, String movieId) {
        return Uri.parse(WebRequestContract.REQUEST_MOVIE_BASE)
                  .buildUpon()
                  .appendPath(movieId)
                  .appendPath(WebRequestContract.REQUEST_REVIEW_PATH)
                  .appendQueryParameter(WebRequestContract.REQUEST_PARAM_API_KEY, apiKey)
                  .build();
    }
}
