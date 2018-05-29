package bwei.com.jingddab.Model;

import java.util.Map;

public interface ILoginModel {
    //获取数据的回调方法
    void showLoginJson(String url, Map<String,String> map, ILoginModelListener iLoginModelListener);
}
