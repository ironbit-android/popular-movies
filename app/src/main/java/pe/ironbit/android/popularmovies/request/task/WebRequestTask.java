package pe.ironbit.android.popularmovies.request.task;

/**
 * Interface for AsyncTask class.
 */
public interface WebRequestTask {
    /**
     * Start the execution of the AsyncTask.
     *
     * @param param Optional value for Movie ID.
     */
    void start(String param);
}
