package bwei.com.jingddab.Model;

import com.google.gson.Gson;

import java.util.Map;

import bwei.com.jingddab.BeanUtils.LoginBean;
import bwei.com.jingddab.Http.HttpUtils;
import bwei.com.jingddab.Http.OkLoadListener;

public class LoginModelImpl implements ILoginModel {
    @Override
    public void showLoginJson(String url, Map<String, String> map, final ILoginModelListener iLoginModelListener) {
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
                LoginBean loginBean = gson.fromJson(json, LoginBean.class);
                String code = loginBean.getCode();
                if (code.equals("0")) {//判断当code等于0时为登录成功 否则为登录失败
                    iLoginModelListener.showLoginJsonSuccess(loginBean.getMsg());
                }else {
                    //请求失败  code不为0
                    iLoginModelListener.showLoginJsonError(loginBean.getMsg());
                }
            }

            @Override
            public void okLoadError(String error) {
                //请求失败
                iLoginModelListener.showLoginJsonError(error);
            }


        });
    }
}
