package bwei.com.jingddab.Presenter;

import android.util.Log;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import bwei.com.jingddab.BeanUtils.LeftBean;
import bwei.com.jingddab.BeanUtils.RightBean;
import bwei.com.jingddab.Http.HttpConfig;
import bwei.com.jingddab.Model.FenLeiGetLeftListener;
import bwei.com.jingddab.Model.FenLeiGetRightListener;
import bwei.com.jingddab.Model.FenLeiIModel;
import bwei.com.jingddab.View.FenLeiIMainView;

public class FenLeiPresenterImpl implements FenLeiIPresenter{
    private static final String TAG = "Presenter";

    @Override
    public void showLeftToView(FenLeiIModel iModel, final FenLeiIMainView iMainView) {
        Map<String, String> map = new HashMap<>();
        iModel.getLeftList(HttpConfig.left_url, map, new FenLeiGetLeftListener() {
            @Override
            public void getLeftSuccess(String json) {
                //解析
                Gson gson = new Gson();
                LeftBean leftBean = gson.fromJson(json, LeftBean.class);
                if (leftBean.getCode().equals("0")) {
                    iMainView.showLeftView(leftBean.getData());
                } else {
                    Log.d(TAG, "失败" + json);
                }
            }

            @Override
            public void getLeftError(String error) {
                Log.d(TAG, "getLeftError: " + error);
            }
        });
    }

    @Override
    public void showRightToView(FenLeiIModel iModel, final FenLeiIMainView iMainView) {
        Map<String, String> map = new HashMap<>();
        map.put("cid",iMainView.getCid());
        iModel.getRightList(HttpConfig.right_url, map, new FenLeiGetRightListener() {
            @Override
            public void getLeftSuccess(String json) {
                //解析
                Gson gson = new Gson();
                RightBean rightBean = gson.fromJson(json, RightBean.class);
                if (rightBean.getCode().equals("0")) {
                    iMainView.showRightView(rightBean.getData());
                } else {
                    Log.d(TAG, "失败" + json);
                }
            }

            @Override
            public void getLeftError(String error) {
                Log.d(TAG, "getLeftError: " + error);
            }
        });
    }
}
