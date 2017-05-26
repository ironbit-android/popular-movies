package pe.ironbit.android.popularmovies.request.base;

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

import pe.ironbit.android.popularmovies.request.parser.WebRequestParser;

/**
 * Helper class for web request.
 */
public class WebRequestHelper {
    /**
     * Name of the class and it is used for log purpose.
     */
    private static final String LOG_TAG = WebRequestHelper.class.getSimpleName();

    /**
     *
     * @param uri
     * @param formatter
     * @return
     */
    public static List makeWebRequest(Uri uri, WebRequestParser formatter) {
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

        List list = null;
        try {
            list = formatter.parseData(response);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the JSON results.", e);
            return null;
        }

        return list;
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
            urlConnection.setReadTimeout(WebRequestContract.READ_TIMEOUT);
            urlConnection.setConnectTimeout(WebRequestContract.CONNECT_TIMEOUT);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == WebRequestContract.RESPONSE_CODE) {
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
