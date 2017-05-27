package pe.ironbit.android.popularmovies.view.review;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.ironbit.android.popularmovies.R;
import pe.ironbit.android.popularmovies.model.review.ReviewData;
import pe.ironbit.android.popularmovies.view.base.ModelUpdate;

public class ReviewAdapter
        extends RecyclerView.Adapter<ReviewViewHolder>
        implements ModelUpdate {
    /**
     * Collection of the data.
     */
    private List<ReviewData> mList;

    /**
     * Unique constructor.
     */
    public ReviewAdapter() {
        mList = new ArrayList<>();
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.module_movie_review, parent, false);
        ReviewViewHolder viewHolder = new ReviewViewHolder(view, context);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position) {
        ReviewData data = mList.get(position);
        Uri uri = Uri.parse(data.getUrl());
        holder.bind(data.getAuthor(), data.getContent(), uri);
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
