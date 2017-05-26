package pe.ironbit.android.popularmovies.request.task;

import android.os.AsyncTask;
import android.text.TextUtils;

import java.util.List;

import pe.ironbit.android.popularmovies.model.video.VideoData;
import pe.ironbit.android.popularmovies.request.base.VideoWebRequestService;
import pe.ironbit.android.popularmovies.request.base.WebRequestService;
import pe.ironbit.android.popularmovies.view.base.ModelUpdate;

/**
 * AsyncTask for trailer or video request from MovieDB database.
 */
public class VideoWebRequestTask
        extends AsyncTask<String, Void, List<VideoData>>
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
    public VideoWebRequestTask(String apiKey, ModelUpdate model) {
        mApiKey = apiKey;
        mIsActive = false;
        mModelUpdate = model;
    }

    /**
     * Interface WebRequestTask.
     *
     * @param movieId The movie id value.
     */
    @Override
    public void start(String movieId) {
        if (mIsActive == true) {
            return;
        }
        if (movieId == null || TextUtils.isEmpty(movieId)) {
            return;
        }

        mIsActive = true;
        execute(new String[]{movieId});
    }

    /**
     * Class AsyncTask.
     * Executed when task finished.
     *
     * @param list Output of the task.
     */
    @Override
    protected void onPostExecute(List<VideoData> list) {
        mIsActive = false;
        mModelUpdate.update(list);
    }

    /**
     * Class AsyncTask.
     * Task executed in background thread.
     *
     * @param params param[0] contains the movie id value.
     * @return
     */
    @Override
    protected List<VideoData> doInBackground(String... params) {
        if (params.length != 1) {
            return null;
        }

        WebRequestService service = new VideoWebRequestService();
        return service.makeWebRequest(mApiKey, params[0]);
    }
}
