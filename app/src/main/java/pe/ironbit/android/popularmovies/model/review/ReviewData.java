package pe.ironbit.android.popularmovies.model.review;

/**
 * POJO class that contains information about the movie reviews.
 */
public class ReviewData {
    /**
     * The review id.
     */
    String mId;

    /**
     * The review author.
     */
    String mAuthor;

    /**
     * The review content.
     */
    String mContent;

    /**
     * The review url.
     */
    String mUrl;

    /**
     * Unique constructor.
     *
     * @param id      {@link #mId}
     * @param author  {@link #mAuthor}
     * @param content {@link #mContent}
     * @param url     {@link #mUrl}
     */
    public ReviewData(String id, String author, String content, String url) {
        mId = id;
        mAuthor = author;
        mContent = content;
        mUrl = url;
    }

    /**
     * Get the review id.
     *
     * @return String.
     */
    public String getId() {
        return mId;
    }

    /**
     * Get the review author.
     *
     * @return String.
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     * Get the review content.
     *
     * @return String.
     */
    public String getContent() {
        return mContent;
    }

    /**
     * Get the review url.
     *
     * @return String.
     */
    public String getUrl() {
        return mUrl;
    }
}
