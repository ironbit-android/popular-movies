package pe.ironbit.android.popularmovies.view.movie;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.images.ImageAdapter;

/**
 * It extends RecyclerView.ViewHolder.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {
    /**
     * The ImageView of the layout item.
     */
    private ImageView mImage;

    /**
     * Helper class for image resources.
     *
     * @see ImageAdapter
     */
    private ImageAdapter mImageAdapter;

    /**
     * Unique constructor.
     *
     * @param itemView     The current layout item view.
     * @param imageAdapter Helper class for loading images on ImageView.
     */
    public MovieViewHolder(View itemView, ImageAdapter imageAdapter) {
        super(itemView);

        mImageAdapter = imageAdapter;
        mImage = (ImageView) itemView.findViewById(R.id.view_movie);
    }

    /**
     * It Updates the ImageView with the information of the imagePath.
     *
     * @param imagePath String with the code of the poster movie.
     */
    void bind(String imagePath) {
        mImageAdapter.setImage(mImage, imagePath);
    }
}
