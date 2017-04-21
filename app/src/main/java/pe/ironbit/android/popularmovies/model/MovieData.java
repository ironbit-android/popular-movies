package pe.ironbit.android.popularmovies.model;

/**
 * Simple POJO class for MovieData information.
 * No setter methods.
 */
public class MovieData {
    /**
     * The original title of the movie.
     * Requirements: original title.
     */
    private String mOriginalTitle;

    /**
     * The thumbnail of the movie.
     * Requirements: movie poster.
     */
    private String mPosterPath;

    /**
     * The synopsis of the movie.
     * Requirements: plot synopsis.
     */
    private String mOverview;

    /**
     * The user voting.
     * Requirements: user rating.
     */
    private float mVoteAverage;

    /**
     * The date of the release of the movie.
     * Requirements: release date.
     */
    private String mReleaseDate;

    /**
     * Unique constructor
     *
     * @param originalTitle The original title of the movie.
     * @param posterPath    The thumbnail of the movie.
     * @param overview      The synopsis of the movie.
     * @param voteAverage   The user voting of the movie.
     * @param releaseDate   The date of the release of the movie.
     */
    public MovieData(String originalTitle,
                     String posterPath,
                     String overview,
                     float voteAverage,
                     String releaseDate) {
        mOriginalTitle = originalTitle;
        mPosterPath = posterPath;
        mOverview = overview;
        mVoteAverage = voteAverage;
        mReleaseDate = releaseDate;
    }

    /**
     * Get original movie title.
     * @return {@link #mOriginalTitle}
     */
    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    /**
     * Get the movie poster.
     * @return {@link #mPosterPath}
     */
    public String getPosterPath() {
        return mPosterPath;
    }

    /**
     * Get the movie synopsis.
     * @return {@link #mOverview}
     */
    public String getOverview() {
        return mOverview;
    }

    /**
     * Get user rating of the movie.
     * Float number #0.0 format.
     * @return {@link #mVoteAverage}
     */
    public float getVoteAverage() {
        return mVoteAverage;
    }

    /**
     * Get release date of the movie.
     * @return {@link #mReleaseDate}
     */
    public String getReleaseDate() {
        return mReleaseDate;
    }
}
