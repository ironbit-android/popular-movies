package pe.ironbit.android.popularmovies.view.video;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pe.ironbit.android.popularmovies.R;

/**
 *
 */
public class VideoViewHolder extends RecyclerView.ViewHolder {
    /**
     *
     */
    private TextView mName;

    /**
     *
     */
    private TextView mType;

    /**
     * @param itemView
     */
    public VideoViewHolder(View itemView) {
        super(itemView);

        mName = (TextView) itemView.findViewById(R.id.module_movie_video_name);
        mType = (TextView) itemView.findViewById(R.id.module_movie_video_type);
    }

    /**
     * @param name
     * @param type
     */
    public void bind(String name, String type) {
        mName.setText(name);
        mType.setText(type);
    }
}
