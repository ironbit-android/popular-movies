package pe.ironbit.android.popularmovies.activity;

import android.app.LoaderManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.contract.MovieContract;
import pe.ironbit.android.popularmovies.images.ImageSettings;
import pe.ironbit.android.popularmovies.request.task.MovieWebRequestTask;
import pe.ironbit.android.popularmovies.storage.base.MovieStorageContract;
import pe.ironbit.android.popularmovies.storage.listerner.OnEventStorageListListener;
import pe.ironbit.android.popularmovies.storage.loader.MainStorageLoader;
import pe.ironbit.android.popularmovies.view.movie.MovieAdapter;

/**
 * It shows the movies in a grid matrix.
 */
public class MainActivity extends AppCompatActivity implements OnEventStorageListListener {
    /**
     * Required for Web Request for MovieDB.
     * The key must be set in the string.xml file in 'web_request_api_key'
     */
    private String mApiKey;

    /**
     * Set value of 2 columns when orientation is portrait.
     */
    private static final int PORTRAIT_MATRIX_SIZE = 2;

    /**
     * Set value of 3 columns when orientation is landscape.
     */
    private static final int LANDSCAPE_MATRIX_SIZE = 3;

    /**
     * The size of the grid
     */
    private static int MATRIX_SIZE = PORTRAIT_MATRIX_SIZE;

    /**
     * View Adapter used to store information retrieved from internet
     */
    private MovieAdapter mMovieAdapter;

    /**
     * Interface for the loader.
     */
    LoaderManager.LoaderCallbacks<Cursor> mLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get main container
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_view);
        recyclerView.setHasFixedSize(true);

        // set number of columns for movie to display
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            MATRIX_SIZE = LANDSCAPE_MATRIX_SIZE;
        } else {
            MATRIX_SIZE = PORTRAIT_MATRIX_SIZE;
        }

        // create layout and register it
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, MATRIX_SIZE);
        recyclerView.setLayoutManager(layoutManager);

        // create adapter and register it
        mMovieAdapter = new MovieAdapter(recyclerView, ImageSettings.URI, ImageSettings.W185);
        recyclerView.setAdapter(mMovieAdapter);

        // create AsyncTask and update MovieAdapter
        mApiKey = getString(R.string.web_request_api_key);
        new MovieWebRequestTask(mApiKey, mMovieAdapter).start(MovieContract.POPULAR_MOVIES);

        // Loader
        mLoader = new MainStorageLoader(getApplicationContext(), this);
    }

    /**
     * Initialization of the Menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Executed when an action was performed in the menu.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int resourceId = item.getItemId();
        if (resourceId == R.id.menu_action_search_popular) {
            new MovieWebRequestTask(mApiKey, mMovieAdapter).start(MovieContract.POPULAR_MOVIES);
        } else if (resourceId == R.id.menu_action_search_toprated) {
            new MovieWebRequestTask(mApiKey, mMovieAdapter).start(MovieContract.TOP_RATED_MOVIES);
        } else if (resourceId == R.id.menu_action_search_favorite) {
            getLoaderManager().restartLoader(MovieStorageContract.LOADER_IDENTIFIER, null, mLoader);
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * From OnEventStorageListListener interface.
     */
    @Override
    public void onEventStorageAction(List list) {
        if (list == null) {
            return;
        }

        mMovieAdapter.update(list);
    }
}
