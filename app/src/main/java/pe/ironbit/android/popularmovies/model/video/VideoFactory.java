package pe.ironbit.android.popularmovies.model.video;

/**
 * Factory for VideoData.
 */
public final class VideoFactory {
    /**
     * Private unique constructor.
     */
    private VideoFactory() {
    }

    /**
     * Create VideoData object from the parameters.
     *
     * @param id   {@see VideoData#mId}
     * @param key  {@see VideoData#mKey}
     * @param name {@see VideoData#mName}
     * @param site {@see VideoData#mSite}
     * @param type {@see VideoData#mType}
     * @return VideoData object.
     */
    public static VideoData createVideoData(String id, String key, String name, String site, String type) {
        return new VideoData(id, key, name, site, type);
    }
}
