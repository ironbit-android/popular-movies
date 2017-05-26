package pe.ironbit.android.popularmovies.model.video;

/**
 * POJO class that contains information about the movie trailers (or videos).
 */
public class VideoData {
    /**
     * The movie id in the web movie database.
     * Example: "533ec654c3a36854480003eb".
     */
    private String mId;

    /**
     * The movie id of the trailer in the site web page.
     * Example: "SUXWAEX2jlg".
     */
    private String mKey;

    /**
     * The name of the movie trailer.
     * Example: "Official Trailer".
     */
    private String mName;

    /**
     * The web page where the movie trailer is stored.
     * Example: "YouTube".
     */
    private String mSite;

    /**
     * The type of movie trailer.
     * Example: "Trailer".
     */
    private String mType;

    /**
     * Unique constructor and set all parameters.
     *
     * @param id   {@link #mId}
     * @param key  {@link #mKey}
     * @param name {@link #mName}
     * @param site {@link #mSite}
     * @param type {@link #mType}
     */
    public VideoData(String id, String key, String name, String site, String type) {
        mId = id;
        mKey = key;
        mName = name;
        mSite = site;
        mType = type;
    }

    /**
     * Get the movie id.
     *
     * @return String
     */
    public String getId() {
        return mId;
    }

    /**
     * Get the movie trailer id of the web site.
     *
     * @return String
     */
    public String getKey() {
        return mKey;
    }

    /**
     * Get the movie trailer name.
     *
     * @return String
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the movie trailer web site.
     *
     * @return String
     */
    public String getSite() {
        return mSite;
    }

    /**
     * Get the movie trailer type.
     *
     * @return String
     */
    public String getType() {
        return mType;
    }
}
