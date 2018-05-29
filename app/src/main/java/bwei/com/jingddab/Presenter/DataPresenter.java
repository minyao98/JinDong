package bwei.com.jingddab.Presenter;

import java.util.List;

import bwei.com.jingddab.BeanUtils.ShangplbBean;

public interface DataPresenter {
    void success(List<ShangplbBean.DataBean> list);
    void eroor();
}
