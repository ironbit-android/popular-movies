package pe.ironbit.android.popularmovies.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.model.MovieData;

/**
 * Used in RecyclerView.
 * It contains the data.
 * It creates the ViewHolders.
 * It updates the ViewHolders.
 *
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> implements ModelUpdate {

    /**
     * Uri base for the images.
     * The images are retrieved from internet.
     */
    private String mImageUri;

    /**
     * The size of the images.
     * The images are retrieved from internet.
     */
    private String mImageSize;

    /**
     * The data or the list of movies retrieved from internet.
     */
    private List<MovieData> mMovies;

    /**
     * Unique constructor.
     * @param imageUri  {@link #mImageUri}
     * @param imageSize {@link #mImageSize}
     */
    public MovieAdapter(String imageUri, String imageSize) {
        mImageUri = imageUri;
        mImageSize = imageSize;
        mMovies = new ArrayList<>();
    }

    /**
     * From interface ModelUpdate.
     * Used to update the list of movies.
     * @param list {@link #mMovies}
     */
    @Override
    public void updateList(List<MovieData> list) {
        if (list == null) {
            return;
        }

        mMovies.clear();
        mMovies = list;
        notifyDataSetChanged();
    }

    /**
     * From RecyclerView.Adapter.
     * Creates new ViewHolder.
     * @param parent
     * @param viewType
     * @return ViewHolder
     */
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.main_view_item, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(context, view, mImageUri, mImageSize);

        return viewHolder;
    }

    /**
     * From RecyclerView.Adapter.
     * It is used to update the ViewHolder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(mMovies.get(position).getPosterPath().replaceAll("^/", ""));
    }

    /**
     * Get the size of the data.
     * @return The size of the data.
     */
    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}
