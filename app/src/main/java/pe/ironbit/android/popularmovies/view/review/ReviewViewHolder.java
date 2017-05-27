package pe.ironbit.android.popularmovies.view.review;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import pe.ironbit.android.popularmovies.R;

public class ReviewViewHolder extends RecyclerView.ViewHolder {
    /**
     * The web page of the review.
     */
    private Uri mUri;

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
    public ReviewViewHolder(View itemView, final Context context) {
        super(itemView);

        mAuthor = (TextView) itemView.findViewById(R.id.module_movie_review_author);
        mContent = (TextView) itemView.findViewById(R.id.module_movie_review_content);

        View view = itemView.findViewById(R.id.module_movie_review_icon);
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
     * @param author  the author of the review.
     * @param content the content of the review.
     * @param uri     the uri of the review.
     */
    public void bind(String author, String content, Uri uri) {
        mAuthor.setText(author);
        mContent.setText(content);
        mUri = uri;
    }
}
