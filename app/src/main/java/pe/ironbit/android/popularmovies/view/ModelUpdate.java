package pe.ironbit.android.popularmovies.view;

import java.util.List;

import pe.ironbit.android.popularmovies.model.MovieData;

/**
 * Interface used for transfer information.
 * When the task finishes the job, then it updates the Model.
 */
public interface ModelUpdate {
    public void updateList(List<MovieData> list);
}
