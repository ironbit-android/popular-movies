package pe.ironbit.android.popularmovies.storage.loader;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import pe.ironbit.android.popularmovies.model.movie.MovieData;
import pe.ironbit.android.popularmovies.model.movie.MovieMapper;
import pe.ironbit.android.popularmovies.storage.listerner.OnEventStorageListListener;

/**
 * Loader for Main Activity.
 * Query for all movies in the database.
 */
public class MainStorageLoader implements LoaderManager.LoaderCallbacks<Cursor> {
    private Context mContext;

    private OnEventStorageListListener mListener;

    public MainStorageLoader(Context context, OnEventStorageListListener listener) {
        mContext = context;
        mListener = listener;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return MovieMapper.query(mContext);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null) {
            return;
        }

        List<MovieData> list = new ArrayList();
        while (cursor.moveToNext()) {
            list.add(MovieMapper.generateData(cursor));
        }

        if (list.isEmpty() == false) {
            mListener.onEventStorageAction(list);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mListener.onEventStorageAction(null);
    }
}