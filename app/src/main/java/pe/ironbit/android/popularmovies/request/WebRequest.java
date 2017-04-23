package pe.ironbit.android.popularmovies.request;

import android.net.Uri;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;

import pe.ironbit.android.popularmovies.model.MovieData;

/**
 * Class used for functionalities related to web information request.
 */
public class WebRequest {

    /**
     * Name of the class and it is used for log purpose.
     */
    private static final String LOG_TAG = WebRequest.class.getSimpleName();

    /**
     * Correct response code from the request.
     */
    private static final int RESPONSE_CODE = 200;

    /**
     * Estabish the read timeout for the request.
     */
    private static final int READ_TIMEOUT = 10_000;

    /**
     * Establish the connect timeout for the request.
     */
    private static final int CONNECT_TIMEOUT = 15_000;

    /**
     * The schema of the uri in case of popular movies.
     */
    private static String QUERY_SCHEMA_POPULAR = "https://api.themoviedb.org/3/movie/popular";

    /**
     * The schema of the uri in case of top rated movies.
     */
    private static String QUERY_SCHEMA_TOPRATED = "https://api.themoviedb.org/3/movie/top_rated";

    /**
     * The parameter 'api_key' of the web request.
     */
    private static String QUERY_PARAM_API_KEY = "api_key";

    /**
     * Public method that is in charge to perform the web request.
     * @param selector {@link Selector}
     * @param apiKey The 'Api Key' for the web request.
     * @return List of Movies.
     */
    public static List<MovieData> makeWebApiRequest(Selector selector, String apiKey) {
        Uri uri = createUri(selector, apiKey);

        URL url = null;
        try {
            url = createUrl(uri.toString());
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem creating URL ", e);
            return null;
        }

        String response = null;
        try {
            response = makeHttpRequest(url);
            if (response == null) {
                Log.e(LOG_TAG, "Problem in response.");
                return null;
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem performing web api.", e);
            return null;
        }

        List<MovieData> movies = null;
        try {
            movies = Formatter.extractJSON(response);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the JSON results.", e);
            return null;
        }

        return movies;
    }

    /**
     * Creates the Uri with the request.
     * @param selector {@link Selector}
     * @param apiKey The 'Api Key' for the web request.
     * @return The Uri with the request.
     */
    private static Uri createUri(Selector selector, String apiKey) {
        Uri.Builder builder = null;
        if (selector == Selector.POPULAR) {
            builder = Uri.parse(QUERY_SCHEMA_POPULAR).buildUpon();
        } else {
            builder = Uri.parse(QUERY_SCHEMA_TOPRATED).buildUpon();
        }
        builder.appendQueryParameter(QUERY_PARAM_API_KEY, apiKey);
        return builder.build();
    }

    /**
     * Transform the Uri to Url.
     * @param param Uri in string.
     * @return The Url from the Uri.
     * @throws MalformedURLException
     */
    private static URL createUrl(String param) throws MalformedURLException {
        return new URL(param);
    }

    /**
     * Make the web request.
     * @param url The url with the request.
     * @return The response of the request.
     * @throws IOException
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String response = null;
        HttpURLConnection urlConnection = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(READ_TIMEOUT);
            urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == RESPONSE_CODE) {
                response = readHttpResponse(urlConnection);
            }
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return response;
    }

    /**
     * Transform the binary information to UTF-8 format.
     * @param urlConnection The buffer with the information
     * @return The string in UTF-8 format.
     * @throws IOException
     */
    private static String readHttpResponse(URLConnection urlConnection) throws IOException {
        String response = null;
        InputStream inputStream = null;

        try {
            inputStream = urlConnection.getInputStream();
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            response = output.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return response;
    }
}
