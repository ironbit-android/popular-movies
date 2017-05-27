package pe.ironbit.android.popularmovies.view.video;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import pe.ironbit.android.popularmovies.R;

public class VideoViewHolder extends RecyclerView.ViewHolder {
    /**
     * The name of the video.
     */
    private TextView mName;

    /**
     * The type of the video.
     */
    private TextView mType;

    /**
     * The uri of the movie video.
     */
    private Uri mUri;

    /**
     * Unique constructor.
     * @param itemView the holder view.
     */
    public VideoViewHolder(View itemView, final Context context) {
        super(itemView);

        mName = (TextView) itemView.findViewById(R.id.module_movie_video_name);
        mType = (TextView) itemView.findViewById(R.id.module_movie_video_type);

        View view = itemView.findViewById(R.id.module_movie_video_icon);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUri == null || TextUtils.isEmpty(mUri.toString())) {
                    return;
                }

                Intent intent = new Intent(Intent.ACTION_VIEW, mUri);
                context.startActivity(intent);
            }
        });
    }

    /**
     * Populate data for the holder.
     *
     * @param name the name of the video.
     * @param type the type of the video.
     */
    public void bind(String name, String type, Uri uri) {
        mName.setText(name);
        mType.setText(type);
        mUri = uri;
    }
}
