package pe.ironbit.android.popularmovies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.images.ImageAdapter;
import pe.ironbit.android.popularmovies.images.ImageSettings;
import pe.ironbit.android.popularmovies.model.MovieData;

/**
 * It shows the information related to the movies.
 */
public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        // get movie data and create helper image class.
        MovieData movie = (MovieData) getIntent().getExtras().getSerializable(MovieData.class.getSimpleName());
        ImageAdapter imageAdapter = new ImageAdapter(getApplicationContext(), ImageSettings.URI, ImageSettings.W185);

        // Movie poster image
        ImageView moviePoster = (ImageView)findViewById(R.id.movie_poster);
        imageAdapter.setImage(moviePoster, movie.getPosterPath().replaceAll("^/", ""));

        // Movie original title.
        ((TextView) findViewById(R.id.movie_title)).setText(movie.getOriginalTitle());

        // Movie release date.
        ((TextView) findViewById(R.id.movie_date)).setText(movie.getReleaseDate());

        // Movie synopsis
        ((TextView) findViewById(R.id.movie_synopsis)).setText(movie.getOverview());

        // Movie vote average
        ((TextView) findViewById(R.id.movie_rating)).setText(String.valueOf(movie.getVoteAverage()));
    }
}
