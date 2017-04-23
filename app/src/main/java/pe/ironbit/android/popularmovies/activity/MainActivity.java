package pe.ironbit.android.popularmovies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.request.Selector;
import pe.ironbit.android.popularmovies.request.Task;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = getString(R.string.web_request_api_key);
        new Task(apiKey).execute(Selector.POPULAR);
    }
}
