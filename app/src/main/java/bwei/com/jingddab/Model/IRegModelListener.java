package bwei.com.jingddab.Model;

public interface IRegModelListener {
    //获取数据成功
    void showRegJsonSuccess(String json);
    //获取数据失败
    void showRegJsonError(String error);
}
