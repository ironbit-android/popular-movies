package pe.ironbit.android.popularmovies.view;

import android.content.Context;
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
     * @see ImageAdapter
     */
    private ImageAdapter mImageAdapter;

    /**
     * Unique constructor.
     * @param context    The context of the activity.
     * @param itemView   The current layout item view.
     * @param imageUri   The uri for retrieve images from internet.
     * @param imageSize  The size of the images.
     */
    public MovieViewHolder(Context context, View itemView, String imageUri, String imageSize) {
        super(itemView);

        mImageAdapter = new ImageAdapter(context, imageUri, imageSize);
        mImage = (ImageView) itemView.findViewById(R.id.view_movie);
    }

    /**
     * It Updates the ImageView with the information of the imagePath.
     * @param imagePath String with the code of the poster movie.
     */
    void bind(String imagePath) {
        mImageAdapter.setImage(mImage, imagePath);
    }
}
