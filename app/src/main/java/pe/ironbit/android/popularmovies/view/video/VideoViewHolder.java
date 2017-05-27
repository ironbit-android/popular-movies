package pe.ironbit.android.popularmovies.view.video;

import android.support.v7.widget.RecyclerView;
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
     * Unique constructor.
     * @param itemView the holder view.
     */
    public VideoViewHolder(View itemView) {
        super(itemView);

        mName = (TextView) itemView.findViewById(R.id.module_movie_video_name);
        mType = (TextView) itemView.findViewById(R.id.module_movie_video_type);
    }

    /**
     * Populate data for the holder.
     *
     * @param name the name of the video.
     * @param type the type of the video.
     */
    public void bind(String name, String type) {
        mName.setText(name);
        mType.setText(type);
    }
}
