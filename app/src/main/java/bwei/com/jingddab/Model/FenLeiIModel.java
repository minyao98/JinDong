package bwei.com.jingddab.Model;

import java.util.Map;

public interface FenLeiIModel {
    //获取左侧列表数据
    void getLeftList(String url, Map<String,String> map, FenLeiGetLeftListener getLeftListener);
    //获取右侧列表数据
    void getRightList(String url, Map<String,String> map,FenLeiGetRightListener getRightListener);
}
