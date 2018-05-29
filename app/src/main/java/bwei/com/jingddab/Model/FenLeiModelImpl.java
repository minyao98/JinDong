package bwei.com.jingddab.Model;

import android.util.Log;

import java.util.Map;

import bwei.com.jingddab.Http.HttpUtils;
import bwei.com.jingddab.Http.OkLoadListener;

public class FenLeiModelImpl implements FenLeiIModel{

    public static final String TAG = "FenLeiModelImpl=====";

    @Override
    public void getLeftList(String url, Map<String, String> map, final FenLeiGetLeftListener getLeftListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.okPost(url,map);
        httpUtils.setOkLoadListener(new OkLoadListener() {


            @Override
            public void okLoadSuccess(String json) {
                Log.d(TAG, "okLoadSuccess: "+json);
                //回调  
                getLeftListener.getLeftSuccess(json);
            }

            @Override
            public void okLoadError(String error) {
                Log.d(TAG, "失败: "+error);
                //回调  
                getLeftListener.getLeftError(error);
            }
        });
    }

    @Override
    public void getRightList(String url, Map<String, String> map, final FenLeiGetRightListener getRightListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.okPost(url,map);
        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Log.d(TAG, "okLoadSuccess: "+json);
                //回调
                getRightListener.getLeftSuccess(json);
            }

            @Override
            public void okLoadError(String error) {
                Log.d(TAG, "失败: "+error);
                //回调
                getRightListener.getLeftError(error);
            }
        });
    }
}
