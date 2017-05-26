package pe.ironbit.android.popularmovies.model;

import java.io.Serializable;

/**
 * Simple POJO class for MovieData information.
 * No setter methods.
 */
public class MovieData implements Serializable {
    /**
     * The identifier of the movie.
     */
    private String mId;

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
     *
     * @param id            The identifier of the movie.
     * @param originalTitle The original title of the movie.
     * @param posterPath    The thumbnail of the movie.
     * @param overview      The synopsis of the movie.
     * @param voteAverage   The user voting of the movie.
     * @param releaseDate   The date of the release of the movie.
     */
    public MovieData(String id,
                     String originalTitle,
                     String posterPath,
                     String overview,
                     double voteAverage,
                     String releaseDate) {
        mId = id;
        mOriginalTitle = originalTitle;
        mPosterPath = posterPath;
        mOverview = overview;
        mVoteAverage = voteAverage;
        mReleaseDate = releaseDate;
    }

    /**
     * Get the identifier of the movie
     *
     * @return {@link #mId}
     */
    public String getId() {
        return mId;
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
     * Double number #0.0 format.
     * @return {@link #mVoteAverage}
     */
    public double getVoteAverage() {
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
