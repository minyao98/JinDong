package bwei.com.jingddab.View;

import java.util.List;

import bwei.com.jingddab.BeanUtils.LeftBean;
import bwei.com.jingddab.BeanUtils.RightBean;

public interface FenLeiIMainView {
    //显示左侧列表
    void showLeftView(List<LeftBean.DataBean> list);
    //显示右侧
    void showRightView(List<RightBean.DataBean> list);
    //获取分类的cid
    String getCid();
}
