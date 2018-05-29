package bwei.com.jingddab.Model;

import com.google.gson.Gson;

import java.util.Map;

import bwei.com.jingddab.BeanUtils.RegBean;
import bwei.com.jingddab.Http.HttpUtils;
import bwei.com.jingddab.Http.OkLoadListener;

public class RegModelImpl implements IRegModel{
    @Override
    public void showRegnJson(String url, Map<String, String> map, final IRegModelListener iRegModelListener) {
        //在Model层进行网络请求
        HttpUtils httputils = HttpUtils.getHttpUtils();
        //使用POST方式进行请求
        httputils.okPost(url, map);
        httputils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                //请求成功
                //进行解析
                Gson gson = new Gson();
                RegBean regBean = gson.fromJson(json, RegBean.class);
                String code = regBean.getCode();
                if (code.equals("0")) {//判断当code等于0时为注册成功 否则为登录失败
                    iRegModelListener.showRegJsonSuccess(regBean.getMsg());
                }else {
                    //请求失败  code不为0
                    iRegModelListener.showRegJsonError(regBean.getMsg());
                }
            }

            @Override
            public void okLoadError(String error) {
                //请求失败
                iRegModelListener.showRegJsonError(error);
            }

        });
    }
}
