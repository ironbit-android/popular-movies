package pe.ironbit.android.popularmovies.view.base;

import java.util.List;

/**
 * Interface used for transfer information.
 * When the task finishes the job, then it updates the Model.
 */
public interface ModelUpdate {
    void update(List list);
}
