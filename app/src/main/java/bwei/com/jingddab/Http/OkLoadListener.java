package bwei.com.jingddab.Http;

/**
 * Created by gjl on 2018/4/25.
 */

public interface OkLoadListener {
    void okLoadSuccess(String json);
    void okLoadError(String error);
}
