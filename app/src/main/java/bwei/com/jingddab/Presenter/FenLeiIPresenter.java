package bwei.com.jingddab.Presenter;

import bwei.com.jingddab.Model.FenLeiIModel;
import bwei.com.jingddab.View.FenLeiIMainView;

public interface FenLeiIPresenter {
    //显示左侧列表
    void showLeftToView(FenLeiIModel iModel, FenLeiIMainView iMainView);
    //显示右侧列表
    void showRightToView(FenLeiIModel iModel, FenLeiIMainView iMainView);
}
