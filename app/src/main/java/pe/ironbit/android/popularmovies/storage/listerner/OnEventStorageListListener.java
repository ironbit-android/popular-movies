package pe.ironbit.android.popularmovies.storage.listerner;

import java.util.List;

/**
 * Interface listener for a collection of movies information.
 * It is used to associate view component with database information.
 */
public interface OnEventStorageListListener {
    void onEventStorageAction(List list);
}
