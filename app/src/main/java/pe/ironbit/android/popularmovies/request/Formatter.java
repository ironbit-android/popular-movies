package pe.ironbit.android.popularmovies.request;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.ironbit.android.popularmovies.model.MovieBuilder;
import pe.ironbit.android.popularmovies.model.MovieData;

/**
 * Helper class that transform json information to a list of movies.
 */
public final class Formatter {
    /**
     * Method that transform ifnormation between json and movie.
     * @param param Contains the json information
     * @return List of Movies
     * @throws JSONException
     */
    public static List<MovieData> extractJSON(String param) throws JSONException {
        if (TextUtils.isEmpty(param)) {
            return null;
        }

        MovieBuilder builder = new MovieBuilder();
        List<MovieData> movies = new ArrayList<>();

        JSONObject document = new JSONObject(param);
        JSONArray results = document.getJSONArray("results");

        for (int index = 0; index < results.length(); ++index) {
            builder.clear();
            JSONObject object = results.getJSONObject(index);

            builder.setOriginalTitle(object.getString("original_title"))
                   .setPosterPath(object.getString("poster_path"))
                   .setOverview(object.getString("overview"))
                   .setVoteAverage(object.getDouble("vote_average"))
                   .setReleaseDate(object.getString("release_date"));

            movies.add(builder.build());
        }

        return movies;
    }
}
