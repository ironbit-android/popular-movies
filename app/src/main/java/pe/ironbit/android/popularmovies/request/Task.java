package pe.ironbit.android.popularmovies.request;

import android.os.AsyncTask;

import java.util.List;

import pe.ironbit.android.popularmovies.model.MovieData;

/**
 * It extends the functionality if the AsyncTask.
 * It executed in other thread the web request to the movie database.
 */
public class Task extends AsyncTask<Selector, Void, List<MovieData>> {

    /**
     * Store the ApiKey for Web Request
     */
    private String mApiKey;

    /**
     * Unique Constructor
     * Save ApiKey for Web Request
     * @param apiKey {@link #mApiKey}
     */
    public Task(String apiKey) {
        mApiKey = apiKey;
    }

    /**
     * Override method executed in other thread (not main thread).
     * @param selector {@link Selector}
     * @return List of Movies
     */
    @Override
    protected List<MovieData> doInBackground(Selector... selector) {
        if (selector.length != 1) {
            return null;
        }

        return WebRequest.makeWebApiRequest(selector[0], mApiKey);
    }
}
