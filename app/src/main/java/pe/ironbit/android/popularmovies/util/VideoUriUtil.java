package pe.ironbit.android.popularmovies.util;

import android.net.Uri;

import pe.ironbit.android.popularmovies.model.video.VideoData;

public final class VideoUriUtil {
    private VideoUriUtil() {
    }

    private static final String YOUTUBE_PATH = "embed";

    private static final String YOUTUBE_NAME = "youtube";

    private static final String YOUTUBE_URL = "http://www.youtube.com";

    public static Uri generateVideoUri(VideoData data) {
        if (data == null) {
            return null;
        }

        if (!YOUTUBE_NAME.equals(data.getSite().toLowerCase())) {
            return null;
        }

        return Uri.parse(YOUTUBE_URL)
                  .buildUpon()
                  .appendPath(YOUTUBE_PATH)
                  .appendPath(data.getKey())
                  .build();
    }
}
