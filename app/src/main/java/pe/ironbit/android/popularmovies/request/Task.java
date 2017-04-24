package pe.ironbit.android.popularmovies.request;

import android.os.AsyncTask;

import java.util.List;

import pe.ironbit.android.popularmovies.model.MovieData;
import pe.ironbit.android.popularmovies.view.ModelUpdate;

/**
 * It extends the functionality of the AsyncTask.
 * It executes in other thread the web request to the movie database.
 */
public class Task<Model extends ModelUpdate> extends AsyncTask<Selector, Void, List<MovieData>> {

    /**
     * Store the ApiKey for Web Request.
     */
    private String mApiKey;

    /**
     * The result of the async task will be stored in the Model.
     */
    private Model mModel;

    /**
     * Unique Constructor
     * Save ApiKey for Web Request
     * @param apiKey {@link #mApiKey}
     * @param model  {@link #mModel}
     */
    public Task(String apiKey, Model model) {
        mModel = model;
        mApiKey = apiKey;
    }

    /**
     * Override method executed in other thread (not main thread).
     * //@param selector {@link Selector}
     * @return List of Movies
     */
    @Override
    protected List<MovieData> doInBackground(Selector... selectors) {
        if (selectors.length != 1) {
            return null;
        }

        return WebRequest.makeWebApiRequest(selectors[0], mApiKey);
    }

    /**
     * The information is updated when the task completes the job.
     * @param movies
     */
    @Override
    protected void onPostExecute(List<MovieData> movies) {
        mModel.updateList(movies);
    }
}
