package pe.ironbit.android.popularmovies.request;

/**
 * It is used to select which web request will be performed.
 */
public final class Selector {
    /**
     * Option popular movies.
     */
    public static int POPULAR;

    /**
     * Option top rated movies.
     */
    public static int TOP_RATED;

    static {
        POPULAR = 1;
        TOP_RATED = 2;
    }

    /**
     * Save the option selected.
     */
    private int mValue;

    /**
     * Factory method for popular movies.
     * It is required to be an array of objects in order to be used with AsyncTask.
     * @return Array of Selector converted to Object.
     */
    public static Object[] createPopular() {
        return new Selector[] {new Selector(POPULAR)};
    }

    /**
     * Factory method for top rated movies.
     * It is required to be an array of objects in order to be used with AsyncTask.
     * @return Array of Selector converted to Object.
     */
    public static Object[] createTopRated() {
        return new Selector[] {new Selector(TOP_RATED)};
    }

    /**
     * Unique and private constructor.
     * Use only the factory methods.
     * @param value
     */
    private Selector(int value) {
        mValue = value;
    }

    /**
     * Compare the option.
     * @param value The option.
     * @return Whether the options are the same.
     */
    public boolean is(int value) {
        return mValue == value;
    }
}
