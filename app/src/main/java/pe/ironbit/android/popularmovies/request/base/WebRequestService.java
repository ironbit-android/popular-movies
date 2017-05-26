package pe.ironbit.android.popularmovies.request.base;

import java.util.List;

/**
 * Interface that perform the web request service.
 */
public interface WebRequestService {
    /**
     * Perform the web request service.
     *
     * @param apiKey  value required for access to movie database.
     * @param movieId optional value that is the movie id.
     * @return
     */
    List makeWebRequest(String apiKey, String movieId);
}
