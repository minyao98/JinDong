package bwei.com.jingddab.Presenter;

import android.content.Context;

import bwei.com.jingddab.Model.IModel;
import bwei.com.jingddab.View.IMainView;

public interface IPresenter {

    void getmv(Context context, IMainView iview, IModel imode);

    void getmv1( IMainView iview, IModel imode);
}
