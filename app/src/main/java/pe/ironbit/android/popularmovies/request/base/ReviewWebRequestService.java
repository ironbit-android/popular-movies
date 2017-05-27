package pe.ironbit.android.popularmovies.request.base;

import android.net.Uri;

import java.util.List;

import pe.ironbit.android.popularmovies.request.factory.ReviewUriFactory;
import pe.ironbit.android.popularmovies.request.parser.ReviewWebRequestParser;
import pe.ironbit.android.popularmovies.request.parser.WebRequestParser;

/**
 * Implements the service for retrieve from the movie database (web
 * request) the movie reviews of a specific movie.
 */
public class ReviewWebRequestService implements WebRequestService {
    /**
     * Unique constructor.
     */
    public ReviewWebRequestService() {
    }

    /**
     * Perform the web request.
     * Create the uri and the appropriate parser for the response.
     *
     * @param apiKey  value required for access to movie database.
     * @param movieId optional value that is the movie id.
     * @return the collection of ReviewData.
     */
    @Override
    public List makeWebRequest(String apiKey, String movieId) {
        Uri uri = ReviewUriFactory.createReviewUri(apiKey, movieId);
        WebRequestParser parser = new ReviewWebRequestParser();
        return WebRequestHelper.makeWebRequest(uri, parser);
    }
}
