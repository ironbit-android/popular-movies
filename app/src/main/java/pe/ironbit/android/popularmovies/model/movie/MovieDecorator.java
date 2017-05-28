package pe.ironbit.android.popularmovies.model.movie;

import java.text.SimpleDateFormat;

/**
 * Helper class of the MovieData class.
 * The class can change the date format.
 * The NewDatePattern represents the desire date format.
 * The OldDatePattern represents the format of the MovieData.
 */
public class MovieDecorator {
    /**
     * The Movie POJO class.
     */
    private MovieData mMovieData;

    /**
     * The new release date (new date format)
     */
    private String mReleaseDate;

    /**
     * The date format in the MovieData class.
     */
    private String mOldDatePattern;

    /**
     * The new date format.
     */
    private String mNewDatePattern;

    /**
     * Constructor.
     * Inject the MovieData information.
     *
     * @param movieData {@link #mMovieData}
     */
    public MovieDecorator(MovieData movieData) {
        mMovieData = movieData;
    }

    /**
     * Set the date format in the MovieData class.
     *
     * @param pattern {@link #mOldDatePattern}
     */
    public void setOldDatePattern(String pattern) {
        mOldDatePattern = pattern;
    }

    /**
     * Set the new date format.
     *
     * @param pattern {@link #mNewDatePattern}
     */
    public void setNewDatePattern(String pattern) {
        mNewDatePattern = pattern;
    }

    /**
     * Get the release date in the new format.
     *
     * @return {@link #mReleaseDate}
     * @throws java.text.ParseException
     */
    public String getReleaseDate() throws java.text.ParseException {
        return getReleaseDate(mNewDatePattern);
    }

    /**
     * Get the release date in the new format using the parameter format.
     *
     * @param pattern The new date release format.
     * @return {@link #mReleaseDate}
     * @throws java.text.ParseException
     */
    public String getReleaseDate(String pattern) throws java.text.ParseException {
        if (mReleaseDate == null) {
            SimpleDateFormat newFormatter = new SimpleDateFormat(pattern);
            SimpleDateFormat oldFormatter = new SimpleDateFormat(mOldDatePattern);
            mReleaseDate = newFormatter.format(oldFormatter.parse(mMovieData.getReleaseDate()));
        }
        return mReleaseDate;
    }
}
