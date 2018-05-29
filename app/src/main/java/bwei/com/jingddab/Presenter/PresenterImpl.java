package bwei.com.jingddab.Presenter;

import android.content.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bwei.com.jingddab.BeanUtils.GGGBean;
import bwei.com.jingddab.BeanUtils.ShouyeBean;
import bwei.com.jingddab.Http.HttpConfig;
import bwei.com.jingddab.Model.Getjiugongge;
import bwei.com.jingddab.Model.Getjson;
import bwei.com.jingddab.Model.ILoginModel;
import bwei.com.jingddab.Model.ILoginModelListener;
import bwei.com.jingddab.Model.IModel;
import bwei.com.jingddab.Model.IRegModel;
import bwei.com.jingddab.Model.IRegModelListener;
import bwei.com.jingddab.View.ILoginView;
import bwei.com.jingddab.View.IMainView;
import bwei.com.jingddab.View.IRegView;

public class PresenterImpl implements IPresenter_loginandreg,IPresenter{

    public static final String TAG = "PresenterImpl=====";

    @Override
    public void getLoginJson(ILoginModel iLoginModel, final ILoginView iLoginView) {
        //创建Map集合
        Map<String, String> map = new HashMap<>();
        map.put("mobile", iLoginView.getMobile());
        map.put("password", iLoginView.getPassword());
        iLoginModel.showLoginJson(HttpConfig.login_url, map, new ILoginModelListener() {
            @Override
            public void showLoginJsonSuccess(String json) {
                //登录成功
                iLoginView.showLoginSuccess();
            }

            @Override
            public void showLoginJsonError(String error) {
                iLoginView.showLoginError(error);//登录失败
            }
        });

    }

    @Override
    public void getRegJson(IRegModel iRegModel, final IRegView iRegView) {
        //创建Map集合
        Map<String, String> map = new HashMap<>();
        map.put("mobile", iRegView.getMobile());
        map.put("password", iRegView.getPassword());
        iRegModel.showRegnJson(HttpConfig.reg_url, map, new IRegModelListener() {
            @Override
            public void showRegJsonSuccess(String json) {
                iRegView.showLoginSuccess();
            }

            @Override
            public void showRegJsonError(String error) {
                iRegView.showLoginError(error);
            }
        });
    }


    @Override
    public void getmv(final Context context, final IMainView iview, IModel imode) {
        imode.getnetjson(new Getjson() {
            @Override
            public void getnetjson(ShouyeBean shouye_bean) {
                iview.setadapter(context,shouye_bean);
            }
        });
    }

    @Override
    public void getmv1(final IMainView iview, IModel imode) {
        imode.getjiugonggejson(new Getjiugongge() {
            @Override
            public void getJiugongge(List<GGGBean.DataBean> data) {
                iview.setadapter1(data);
            }
        });
    }


}
