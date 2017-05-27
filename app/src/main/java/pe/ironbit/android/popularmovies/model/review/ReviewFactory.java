package pe.ironbit.android.popularmovies.model.review;

/**
 * Factory for ReviewData.
 */
public final class ReviewFactory {

    /**
     * Private unique constructor
     */
    private ReviewFactory() {
    }

    /**
     * Create ReviewData object from parameters.
     *
     * @param id      {@see ReviewData#mId}
     * @param author  {@see ReviewData#mAuthor}
     * @param content {@see ReviewData#mContent}
     * @param url     {@see ReviewData#mUrl}
     * @return ReviewData object.
     */
    public static ReviewData createReviewData(String id, String author, String content, String url) {
        return new ReviewData(id, author, content, url);
    }
}
