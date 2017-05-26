package pe.ironbit.android.popularmovies.model.video;

/**
 * Builder class for the MovieData.
 */
public class VideoBuilder {
    /**
     * {@see VideoData#mId}
     */
    private String mId;

    /**
     * {@see VideoData#mKey}
     */
    private String mKey;

    /**
     * {@see VideoData#mName}
     */
    private String mName;

    /**
     * {@see VideoData#mSite}
     */
    private String mSite;

    /**
     * {@see VideoData#mType}
     */
    private String mType;

    /**
     * Static factory for one line builder statement.
     *
     * @return VideoBuilder
     */
    public static VideoBuilder builder() {
        return new VideoBuilder();
    }

    /**
     * Unique constructor.
     */
    public VideoBuilder() {
        clear();
    }

    /**
     * Set all fields to empty string.
     *
     * @return VideoBuilder
     */
    public VideoBuilder clear() {
        mId = "";
        mKey = "";
        mName = "";
        mSite = "";
        mType = "";
        return this;
    }

    /**
     * Creates a VideoData object using the factory.
     *
     * @return VideoData
     */
    public VideoData build() {
        return VideoFactory.createVideoData(mId, mKey, mName, mSite, mType);
    }

    /**
     * Set the movie id for the movie database.
     *
     * @param id {@see VideoData#mId}
     * @return VideoBuilder
     */
    public VideoBuilder setId(String id) {
        mId = id;
        return this;
    }

    /**
     * Set the movie trailer id for the web site.
     *
     * @param key {@see VideoData#mKey}
     * @return VideoBuilder
     */
    public VideoBuilder setKey(String key) {
        mKey = key;
        return this;
    }

    /**
     * Set the movie trailer name.
     *
     * @param name {@see VideoData#mName}
     * @return VideoBuilder
     */
    public VideoBuilder setName(String name) {
        mName = name;
        return this;
    }

    /**
     * Set the movie trailer web site.
     *
     * @param site {@see VideoData#mSite}
     * @return VideoBuilder
     */
    public VideoBuilder setSite(String site) {
        mSite = site;
        return this;
    }

    /**
     * Set the movie trailer type.
     *
     * @param type {@see VideoData#mType}
     * @return VideoBuilder
     */
    public VideoBuilder setType(String type) {
        mType = type;
        return this;
    }
}
