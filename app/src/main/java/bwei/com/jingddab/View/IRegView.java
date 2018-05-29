package bwei.com.jingddab.View;

public interface IRegView {
    //登录成功的回调
    void showLoginSuccess();
    //登录失败的回调
    void showLoginError(String error);
    //获取输入的手机号
    String getMobile();
    //获取输入的密码
    String getPassword();
}
