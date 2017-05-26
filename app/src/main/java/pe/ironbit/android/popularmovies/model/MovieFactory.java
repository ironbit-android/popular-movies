package pe.ironbit.android.popularmovies.model;

/**
 * Helper class for creation of MovieData and MovieDecorator classes.
 * The class is final.
 */
public final class MovieFactory {
    /**
     * Private constructor.
     */
    private MovieFactory() {
    }

    /**
     * Factory method used to create MovieData objects.
     * @param id            {@link MovieData#mId}
     * @param originalTitle {@link MovieData#mOriginalTitle}
     * @param posterPath    {@link MovieData#mPosterPath}
     * @param overview      {@link MovieData#mOverview}
     * @param voteAverage   {@link MovieData#mVoteAverage}
     * @param releaseDate   {@link MovieData#mReleaseDate}
     * @return {@link MovieData}
     */
    public static MovieData createMovie(String id,
                                        String originalTitle,
                                        String posterPath,
                                        String overview,
                                        double voteAverage,
                                        String releaseDate) {
        return new MovieData(id, originalTitle, posterPath, overview, voteAverage, releaseDate);
    }

    /**
     * Factory method used to create MovieDecorator objects from MovieData arguments.
     * @param id            {@link MovieData#mId}
     * @param originalTitle {@link MovieData#mOriginalTitle}
     * @param posterPath    {@link MovieData#mPosterPath}
     * @param overview      {@link MovieData#mOverview}
     * @param voteAverage   {@link MovieData#mVoteAverage}
     * @param releaseDate   {@link MovieData#mReleaseDate}
     * @return {@link MovieDecorator}
     */
    public static MovieDecorator createDecorator(String id,
                                                 String originalTitle,
                                                 String posterPath,
                                                 String overview,
                                                 double voteAverage,
                                                 String releaseDate) {
        return new MovieDecorator(createMovie(id, originalTitle, posterPath, overview, voteAverage, releaseDate));
    }

    /**
     * Factory method used to create MovieDecorator objects from MovieData.
     * @param movieData {@link MovieData}
     * @return {@link MovieDecorator}
     */
    public static MovieDecorator createDecorator(MovieData movieData) {
        return new MovieDecorator(movieData);
    }
}
