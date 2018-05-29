package bwei.com.jingddab.Presenter;

import bwei.com.jingddab.Model.ILoginModel;
import bwei.com.jingddab.Model.IRegModel;
import bwei.com.jingddab.View.ILoginView;
import bwei.com.jingddab.View.IRegView;

public interface IPresenter_loginandreg {
    //登录的回调方法
    void getLoginJson(ILoginModel iLoginModel, ILoginView iLoginView);
    //注册的回调方法
    void getRegJson(IRegModel iRegModel, IRegView iRegView);
}
