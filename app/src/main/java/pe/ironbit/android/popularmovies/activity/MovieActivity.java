package pe.ironbit.android.popularmovies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.images.ImageAdapter;
import pe.ironbit.android.popularmovies.images.ImageSettings;
import pe.ironbit.android.popularmovies.model.movie.MovieData;
import pe.ironbit.android.popularmovies.request.task.ReviewWebRequestTask;
import pe.ironbit.android.popularmovies.request.task.VideoWebRequestTask;
import pe.ironbit.android.popularmovies.view.base.ModelUpdate;
import pe.ironbit.android.popularmovies.view.review.ReviewAdapter;
import pe.ironbit.android.popularmovies.view.video.VideoAdapter;

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

        // Get api key for movie database.
        String apiKey = getString(R.string.web_request_api_key);

        // Configure video section
        {
            ModelUpdate model = configVideoRecyclerView();
            createVideoAsyncTask(model, apiKey, movie.getId());
        }

        // Configure review section
        {
            ModelUpdate model = configReviewRecyclerView();
            createReviewAsyncTask(model, apiKey, movie.getId());
        }
    }

    /**
     * Configure the RecyclerView for the video section.
     *
     * @return The adapter of the RecyclerView
     */
    protected ModelUpdate configVideoRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_movie_video_section);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        VideoAdapter adapter = new VideoAdapter();
        recyclerView.setAdapter(adapter);

        return adapter;
    }

    /**
     * Execute the AsyncTask of the web request for the movie videos.
     *
     * @param model  The adapter of the RecyclerView.
     * @param apiKey The key used for the movie database.
     * @param id     The movie id.
     */
    protected void createVideoAsyncTask(ModelUpdate model, String apiKey, String id) {
        new VideoWebRequestTask(apiKey, model).start(id);
    }

    /**
     * Configure the RecyclerView for the review section.
     *
     * @return The adapter of the RecyclerView
     */
    protected ModelUpdate configReviewRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_movie_review_section);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        ReviewAdapter adapter = new ReviewAdapter();
        recyclerView.setAdapter(adapter);

        return adapter;
    }

    /**
     * Execute the AsyncTask of the web request for the movie reviews.
     *
     * @param model  The adapter of the RecyclerView.
     * @param apiKey The key used for the movie database.
     * @param id     The movie id.
     */
    protected void createReviewAsyncTask(ModelUpdate model, String apiKey, String id) {
        new ReviewWebRequestTask(apiKey, model).start(id);
    }
}
