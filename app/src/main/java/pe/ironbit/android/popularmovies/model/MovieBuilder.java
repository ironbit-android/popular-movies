package pe.ironbit.android.popularmovies.model;

/**
 * Builder for Movie information.
 */
public class MovieBuilder {
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
    private double mVoteAverage;

    /**
     * The date of the release of the movie.
     * Requirements: release date.
     */
    private String mReleaseDate;

    /**
     * Unique constructor
     * Assign initial values to variables.
     */
    public MovieBuilder() {
        clear();
    }

    /**
     * Assign initial values to variables.
     */
    public void clear() {
        mOriginalTitle = "";
        mPosterPath = "";
        mOverview = "";
        mVoteAverage = 0.0f;
        mReleaseDate = "";
    }

    /**
     * Set the original title.
     * @param originalTitle {@link #mOriginalTitle}
     * @return MovieBuilder
     */
    public MovieBuilder setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
        return this;
    }

    /**
     * Set the movie poster.
     * @param posterPath {@link #mPosterPath}
     * @return MovieBuilder
     */
    public MovieBuilder setPosterPath(String posterPath) {
        mPosterPath = posterPath;
        return this;
    }

    /**
     * Set the movie synopsis.
     * @param overview {@link #mOverview}
     * @return MovieBuilder
     */
    public MovieBuilder setOverview(String overview) {
        mOverview = overview;
        return this;
    }

    /**
     * Set the acerage rating
     * @param voteAverage {@link #mVoteAverage}
     * @return MovieBuilder
     */
    public MovieBuilder setVoteAverage(double voteAverage) {
        mVoteAverage = voteAverage;
        return this;
    }

    /**
     * Set the movie release date.
     * @param releaseDate {@link #mReleaseDate}
     * @return MovieBuilder
     */
    public MovieBuilder setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
        return this;
    }

    /**
     * Create the movie class.
     * @return {@link MovieData}
     */
    public MovieData build() {
        return MovieFactory.createMovie(mOriginalTitle, mPosterPath, mOverview, mVoteAverage, mReleaseDate);
    }
}
