package pe.ironbit.android.popularmovies.request.parser;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.ironbit.android.popularmovies.model.video.VideoBuilder;
import pe.ironbit.android.popularmovies.model.video.VideoData;

/**
 * Parser for MovieDB (Get Videos).
 * Obtain the video or trailer of the movies.
 */
public class VideoWebRequestParser implements WebRequestParser {

    /**
     * Execute the parsing.
     *
     * @param response the information obtained by the web request.
     * @return collection of VideoData.
     * @throws JSONException
     */
    @Override
    public List parseData(String response) throws JSONException {
        if (response == null || TextUtils.isEmpty(response)) {
            return null;
        }

        List<VideoData> data = new ArrayList<>();
        VideoBuilder builder = new VideoBuilder();

        JSONObject document = new JSONObject(response);
        JSONArray results = document.getJSONArray("results");

        for (int index = 0; index < results.length(); ++index) {
            builder.clear();
            JSONObject object = results.getJSONObject(index);

            builder.setId(object.getString("id"))
                   .setKey(object.getString("key"))
                   .setName(object.getString("name"))
                   .setSite(object.getString("site"))
                   .setType(object.getString("type"));

            data.add(builder.build());
        }

        return data;
    }
}
