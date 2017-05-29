package pe.ironbit.android.popularmovies.storage.loader;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

import pe.ironbit.android.popularmovies.model.movie.MovieMapper;
import pe.ironbit.android.popularmovies.storage.listerner.OnEventStorageUnitListener;

/**
 * Loader for Movie Activity.
 * Query for one movie in the database.
 */
public class MovieStorageLoader implements LoaderManager.LoaderCallbacks<Cursor> {
    private int mId;

    private Context mContext;

    private OnEventStorageUnitListener mListener;

    public MovieStorageLoader(Context context, OnEventStorageUnitListener listener, String id) {
        mContext = context;
        mListener = listener;
        mId = Integer.parseInt(id);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return MovieMapper.query(mContext, mId);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && cursor.moveToFirst()) {
            mListener.onEventStorageAction(MovieMapper.generateData(cursor));
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mListener.onEventStorageAction(null);
    }
}