package bwei.com.jingddab.Model;

import java.util.Map;

public interface IRegModel {
    //获取数据的回调方法
    void showRegnJson(String url, Map<String, String> map, IRegModelListener iRegModelListener);
}
