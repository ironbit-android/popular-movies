package pe.ironbit.android.popularmovies.images;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Helper class for image resources.
 * Accepts only one size of images (constructor configuration).
 */
public class ImageAdapter {
    /**
     * Uri base of the location of the image repository.
     */
    private String mUriBase;

    /**
     * The size of the image.
     */
    private String mImageSize;

    /**
     * The context of the application.
     */
    private final Context mContext;

    /**
     * Unique Constructor
     * @param context   {@link #mContext}
     * @param uriBase   {@link #mUriBase}
     * @param imageSize {@link #mImageSize}
     */
    public ImageAdapter(final Context context, String uriBase, String imageSize) {
        mContext = context;
        mUriBase = uriBase;
        mImageSize = imageSize;
    }

    /**
     * Execute the loading process.
     * @param view    ImageView to load the image resource.
     * @param imageId the Id of the image resource.
     */
    public void setImage(ImageView view, String imageId) {
        Uri uri = createUri(imageId);
        Picasso.with(mContext).load(uri).into(view);
    }

    /**
     * Build the uri of the image resource.
     * @param imageId the Id of the image resource.
     * @return Uri of the image resource.
     */
    private Uri createUri(String imageId) {
        Uri.Builder builder = Uri.parse(mUriBase).buildUpon();
        builder.appendPath(mImageSize);
        builder.appendPath(imageId);
        return builder.build();
    }
}
