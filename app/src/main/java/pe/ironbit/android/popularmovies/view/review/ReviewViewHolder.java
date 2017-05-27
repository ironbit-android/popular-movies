package pe.ironbit.android.popularmovies.view.review;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pe.ironbit.android.popularmovies.R;

public class ReviewViewHolder extends RecyclerView.ViewHolder {
    /**
     * The web page of the review.
     */
    private String mUrl;

    /**
     * The name of the reviewer.
     */
    private TextView mAuthor;

    /**
     * The content of the review.
     */
    private TextView mContent;

    /**
     * Unique constructor.
     *
     * @param itemView the holder view.
     */
    public ReviewViewHolder(View itemView) {
        super(itemView);

        mAuthor = (TextView) itemView.findViewById(R.id.module_movie_review_author);
        mContent = (TextView) itemView.findViewById(R.id.module_movie_review_content);
    }

    /**
     * Populate data for the holder.
     *
     * @param author  the author of the review.
     * @param content the content of the review.
     * @param url     the url of the review.
     */
    public void bind(String author, String content, String url) {
        mAuthor.setText(author);
        mContent.setText(content);
        mUrl = url;
    }
}
