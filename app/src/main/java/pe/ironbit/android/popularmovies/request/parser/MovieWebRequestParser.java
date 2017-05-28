package pe.ironbit.android.popularmovies.request.parser;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.ironbit.android.popularmovies.model.movie.MovieBuilder;
import pe.ironbit.android.popularmovies.model.movie.MovieData;

/**
 * Helper class that transform json information to a list of movies.
 */
public class MovieWebRequestParser implements WebRequestParser {
    /**
     * Method that transform ifnormation between json and movie.
     *
     * @param response Contains the json information
     * @return List of Movies
     * @throws JSONException
     */
    @Override
    public List parseData(String response) throws JSONException {
        if (TextUtils.isEmpty(response)) {
            return null;
        }

        MovieBuilder builder = new MovieBuilder();
        List<MovieData> movies = new ArrayList<>();

        JSONObject document = new JSONObject(response);
        JSONArray results = document.getJSONArray("results");

        for (int index = 0; index < results.length(); ++index) {
            builder.clear();
            JSONObject object = results.getJSONObject(index);

            builder.setId(object.getString("id"))
                   .setOriginalTitle(object.getString("original_title"))
                   .setPosterPath(object.getString("poster_path"))
                   .setOverview(object.getString("overview"))
                   .setVoteAverage(object.getDouble("vote_average"))
                   .setReleaseDate(object.getString("release_date"));

            movies.add(builder.build());
        }

        return movies;
    }
}
