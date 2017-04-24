package pe.ironbit.android.popularmovies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.model.MovieData;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        //MovieData movie = (MovieData) getIntent().getExtras().getSerializable(MovieData.class.getSimpleName());
    }
}
