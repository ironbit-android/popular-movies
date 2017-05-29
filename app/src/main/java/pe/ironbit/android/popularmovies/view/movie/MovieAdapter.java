package pe.ironbit.android.popularmovies.view.movie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.activity.MovieActivity;
import pe.ironbit.android.popularmovies.images.ImageAdapter;
import pe.ironbit.android.popularmovies.model.movie.MovieData;
import pe.ironbit.android.popularmovies.view.base.ModelUpdate;

/**
 * Used in RecyclerView.
 * It contains the data.
 * It creates the ViewHolders.
 * It updates the ViewHolders.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> implements ModelUpdate {
    /**
     * Helper class for image resources.
     *
     * @see pe.ironbit.android.popularmovies.images.ImageAdapter
     */
    private ImageAdapter mImageAdapter;

    /**
     * The data or the list of movies retrieved from internet.
     */
    private List<MovieData> mMovies;

    /**
     * Interface event for all ViewHolders.
     * The definition is in the constructor.
     */
    private View.OnClickListener mOnClickListener;

    /**
     * Unique constructor.
     *
     * @param recyclerView The main container.
     * @param imageUri     The uri for retrieve images from internet.
     * @param imageSize    The size of the images.
     */
    public MovieAdapter(final RecyclerView recyclerView, String imageUri, String imageSize) {
        mMovies = new ArrayList<>();
        mImageAdapter = new ImageAdapter(recyclerView.getContext(), imageUri, imageSize);

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get movie data
                int index = recyclerView.getChildLayoutPosition(view);
                MovieData movie = mMovies.get(index);

                // create intent and put movie data.
                Intent intent = new Intent(recyclerView.getContext(), MovieActivity.class);
                intent.putExtra(MovieData.class.getSimpleName(), movie);

                // call the new activity.
                recyclerView.getContext().startActivity(intent);
            }
        };
    }

    /**
     * From interface ModelUpdate.
     * Used to update the list of movies.
     *
     * @param list {@link #mMovies}
     */
    @Override
    public void update(List list) {
        mMovies.clear();

        if (list == null) {
            return;
        }
        mMovies = list;

        notifyDataSetChanged();
    }

    /**
     * From RecyclerView.Adapter.
     * Creates new ViewHolder.
     *
     * @param parent
     * @param viewType
     * @return ViewHolder
     */
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.main_view_item, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view, mImageAdapter);
        view.setOnClickListener(mOnClickListener);

        return viewHolder;
    }

    /**
     * From RecyclerView.Adapter.
     * It is used to update the ViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(mMovies.get(position).getPosterPath().replaceAll("^/", ""));
    }

    /**
     * Get the size of the data.
     *
     * @return The size of the data.
     */
    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}
