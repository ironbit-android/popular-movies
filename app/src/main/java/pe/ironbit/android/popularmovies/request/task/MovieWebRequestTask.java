package pe.ironbit.android.popularmovies.request.task;

import android.os.AsyncTask;
import android.text.TextUtils;

import java.util.List;

import pe.ironbit.android.popularmovies.model.movie.MovieData;
import pe.ironbit.android.popularmovies.request.base.MovieWebRequestService;
import pe.ironbit.android.popularmovies.request.base.WebRequestService;
import pe.ironbit.android.popularmovies.view.base.ModelUpdate;

/**
 * It extends the functionality of the AsyncTask.
 * It executes in other thread the web request to the movie database.
 */
public class MovieWebRequestTask
        extends AsyncTask<String, Void, List<MovieData>>
        implements WebRequestTask {
    /**
     * Store the ApiKey for Web Request.
     */
    private final String mApiKey;

    /**
     * Guard variable.
     * Execute task when it is idle.
     */
    private boolean mIsActive;

    /**
     * Store information when task finished.
     */
    private ModelUpdate mModelUpdate;

    /**
     * Unique constructor.
     *
     * @param apiKey value required for access to movie database.
     * @param model  Interface that store the information when the task finished.
     */
    public MovieWebRequestTask(String apiKey, ModelUpdate model) {
        mApiKey = apiKey;
        mIsActive = false;
        mModelUpdate = model;
    }

    @Override
    public void start(String param) {
        if (mIsActive == true) {
            return;
        }
        if (param == null || TextUtils.isEmpty(param)) {
            return;
        }

        mIsActive = true;
        execute(new String[]{param});
    }

    /**
     * Class AsyncTask.
     * Executed when task finished.
     *
     * @param list Output of the task.
     */
    @Override
    protected void onPostExecute(List<MovieData> list) {
        mIsActive = false;
        mModelUpdate.update(list);
    }

    @Override
    protected List<MovieData> doInBackground(String... params) {
        if (params.length != 1) {
            return null;
        }

        WebRequestService service = new MovieWebRequestService();
        return service.makeWebRequest(mApiKey, params[0]);
    }
}
