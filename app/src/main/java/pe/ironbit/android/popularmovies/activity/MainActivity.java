package pe.ironbit.android.popularmovies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.request.Selector;
import pe.ironbit.android.popularmovies.request.Task;

public class MainActivity extends AppCompatActivity {

    /**
     * Required for Web Request for MovieDB.
     * The key must be set in the string.xml file in 'web_request_api_key'
     */
    private String mApiKey;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApiKey = getString(R.string.web_request_api_key);
    }

    /**
     * Initialization of the Menu.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Executed when an action was performed in the menu.
     * @param item Id of the resource.
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int resourceId = item.getItemId();
        if (resourceId == R.id.menu_action_search_popular) {
            new Task(mApiKey).execute(Selector.POPULAR);
        }
        else if (resourceId == R.id.menu_action_search_toprated) {
            new Task(mApiKey).execute(Selector.TOPRATED);
        }
        return super.onOptionsItemSelected(item);
    }
}
