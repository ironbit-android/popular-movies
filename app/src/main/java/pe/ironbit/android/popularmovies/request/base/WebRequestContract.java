package pe.ironbit.android.popularmovies.request.base;

public final class WebRequestContract {
    /**
     * Correct response code from the request.
     */
    public static final int RESPONSE_CODE = 200;

    /**
     * Estabish the read timeout for the request.
     */
    public static final int READ_TIMEOUT = 10_000;

    /**
     * Establish the connect timeout for the request.
     */
    public static final int CONNECT_TIMEOUT = 15_000;

    /**
     * The parameter 'api_key' of the web request.
     */
    public static final String REQUEST_PARAM_API_KEY = "api_key";

    /**
     * The base schema of the uri for movie database.
     */
    public static final String REQUEST_MOVIE_BASE = "https://api.themoviedb.org/3/movie";

    /**
     * Used for movie trailer (or videos) request (MovieDB - Movies - Get Videos).
     * https://api.themoviedb.org/3/movie/{movie_id}/videos?api_key=<<api_key>>
     */
    public static final String REQUEST_VIDEO_PATH = "videos";

    /**
     * Used for movie review request (MovieDB - Movies - Get Reviews).
     * https://api.themoviedb.org/3/movie/{movie_id}/reviews?api_key=<<api_key>>
     */
    public static final String REQUEST_REVIEW_PATH = "reviews";
}
