package pe.ironbit.android.popularmovies.request.parser;

import org.json.JSONException;

import java.util.List;

/**
 * Interface that transform web request into a collection of data.
 */
public interface WebRequestParser {
    /**
     * It perform the parsing of the response obtained in the web request.
     *
     * @param response the information obtained by the web request.
     * @return a collection of data obtained by parsing the web response.
     * @throws JSONException
     */
    List parseData(String response) throws JSONException;
}
