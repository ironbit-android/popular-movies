package pe.ironbit.android.popularmovies.model.review;

/**
 * Builder class for the ReviewData.
 */
public class ReviewBuilder {
    /**
     * {@see ReviewData#mId}
     */
    String mId;

    /**
     * {@see ReviewData#mAuthor}
     */
    String mAuthor;

    /**
     * {@see ReviewData#mContent}
     */
    String mContent;

    /**
     * {@see ReviewData#mUrl}
     */
    String mUrl;

    /**
     * Static factory for one line builder statement.
     *
     * @return ReviewBuilder.
     */
    public static ReviewBuilder builder() {
        return new ReviewBuilder();
    }

    /**
     * Unique constructor.
     */
    public ReviewBuilder() {
        clear();
    }

    /**
     * Create a ReviewData object using the factory.
     *
     * @return ReviewData.
     */
    public ReviewData build() {
        return ReviewFactory.createReviewData(mId, mAuthor, mContent, mUrl);
    }

    /**
     * Set all fields to empty string.
     *
     * @return ReviewBuilder.
     */
    public ReviewBuilder clear() {
        mId = "";
        mAuthor = "";
        mContent = "";
        mUrl = "";
        return this;
    }

    /**
     * Set review id.
     *
     * @param id {@see ReviewData#mId}
     * @return ReviewBuilder.
     */
    public ReviewBuilder setId(String id) {
        mId = id;
        return this;
    }

    /**
     * Set review author.
     *
     * @param author {@see ReviewData#mAuthor}
     * @return ReviewBuilder.
     */
    public ReviewBuilder setAuthor(String author) {
        mAuthor = author;
        return this;
    }

    /**
     * Set review content.
     *
     * @param content {@see ReviewData#mContent}
     * @return ReviewBuilder.
     */
    public ReviewBuilder setContent(String content) {
        mContent = content;
        return this;
    }

    /**
     * Set review url.
     *
     * @param url {@see ReviewData#mUrl}
     * @return ReviewBuilder.
     */
    public ReviewBuilder setUrl(String url) {
        mUrl = url;
        return this;
    }
}
