package pe.ironbit.android.popularmovies.request.base;

import java.util.List;

/**
 * Interface that perform the web request service.
 */
public interface WebRequestService {
    /**
     * Perform the web request service.
     *
     * @param apiKey value required for access to movie database.
     * @param param  optional value.
     * @return       collection of data.
     */
    List makeWebRequest(String apiKey, String param);
}
