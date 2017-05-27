package pe.ironbit.android.popularmovies.request.parser;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.ironbit.android.popularmovies.model.review.ReviewBuilder;
import pe.ironbit.android.popularmovies.model.review.ReviewData;

/**
 * Parser for MovieDB (Get Reviews).
 * Obtain the video or trailer of the movies.
 */
public class ReviewWebRequestParser implements WebRequestParser {
    /**
     * Execute the parsing.
     *
     * @param response the information obtained by the web request.
     * @return collection of ReviewData.
     * @throws JSONException
     */
    @Override
    public List parseData(String response) throws JSONException {
        if (response == null || TextUtils.isEmpty(response)) {
            return null;
        }

        List<ReviewData> data = new ArrayList<>();
        ReviewBuilder builder = new ReviewBuilder();

        JSONObject document = new JSONObject(response);
        JSONArray results = document.getJSONArray("results");

        for (int index = 0; index < results.length(); ++index) {
            builder.clear();
            JSONObject object = results.getJSONObject(index);

            builder.setId(object.getString("id"))
                    .setAuthor(object.getString("author"))
                    .setContent(object.getString("content"))
                    .setUrl(object.getString("url"));

            data.add(builder.build());
        }

        return data;
    }
}
