package pe.ironbit.android.popularmovies.view.video;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.model.video.VideoData;
import pe.ironbit.android.popularmovies.util.VideoUriUtil;
import pe.ironbit.android.popularmovies.view.base.ModelUpdate;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder>
                          implements ModelUpdate {
    /**
     * Collection of the data.
     */
    private List<VideoData> mList;

    /**
     * Unique constructor.
     */
    public VideoAdapter() {
        mList = new ArrayList<>();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.module_movie_video, parent, false);
        VideoViewHolder viewHolder = new VideoViewHolder(view, context);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        VideoData data = mList.get(position);
        Uri uri = VideoUriUtil.generateVideoUri(data);
        holder.bind(data.getName(), data.getType(), uri);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void update(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        mList.clear();
        mList = list;
        notifyDataSetChanged();
    }
}
