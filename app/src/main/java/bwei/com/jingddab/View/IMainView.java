package bwei.com.jingddab.View;

import android.content.Context;

import java.util.List;

import bwei.com.jingddab.BeanUtils.GGGBean;
import bwei.com.jingddab.BeanUtils.ShouyeBean;

public interface IMainView {

    void setadapter(Context context, ShouyeBean shouye_bean);

    void setadapter1( List<GGGBean.DataBean> data);

}
