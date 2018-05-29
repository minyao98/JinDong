package bwei.com.jingddab.Model;

public interface ILoginModelListener {
    //获取数据成功
    void showLoginJsonSuccess(String json);
    //获取数据失败
    void showLoginJsonError(String error);
}
