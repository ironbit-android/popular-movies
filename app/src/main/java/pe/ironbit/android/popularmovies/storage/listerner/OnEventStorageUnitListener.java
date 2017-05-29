package pe.ironbit.android.popularmovies.storage.listerner;

import pe.ironbit.android.popularmovies.model.movie.MovieData;

/**
 * Interface listener for one movie information.
 * It is used to associate view component with database information.
 */
public interface OnEventStorageUnitListener {
    void onEventStorageAction(MovieData data);
}
