package pe.ironbit.android.popularmovies.request.base;

import android.net.Uri;

import java.util.List;

import pe.ironbit.android.popularmovies.request.factory.VideoUriFactory;
import pe.ironbit.android.popularmovies.request.parser.VideoWebRequestParser;
import pe.ironbit.android.popularmovies.request.parser.WebRequestParser;

/**
 * Implements the service for retrieve from the movie database (web
 * request) the movie trailers of a specific movie.
 */
public class VideoWebRequestService implements WebRequestService {

    /**
     * Unique constructor
     */
    public VideoWebRequestService() {
    }

    /**
     * Perform the web request.
     * Create the uri and the appropriate parser for the response.
     *
     * @param apiKey  value required for access to movie database.
     * @param movieId optional value that is the movie id.
     * @return the collection of VideoData.
     */
    @Override
    public List makeWebRequest(String apiKey, String movieId) {
        Uri uri = VideoUriFactory.createVideoUri(apiKey, movieId);
        WebRequestParser formatter = new VideoWebRequestParser();
        return WebRequestHelper.makeWebRequest(uri, formatter);
    }
}
