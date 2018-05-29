package bwei.com.jingddab.Http;

/**
 * Created by gjl on 2018/4/25.
 */

public class HttpConfig {
    //登录的接口  请求参数：mobile手机号  必传参数  password密码  必传参数
    public static String login_url = "https://www.zhaoapi.cn/user/login";
    //注册的接口  请求参数：mobile手机号  必传参数  password密码  必传参数
    public static String reg_url = "https://www.zhaoapi.cn/user/reg";

    public static String net="http://120.27.23.105/";

    //分类
    public static String left_url = "https://www.zhaoapi.cn/product/getCatagory";
    public static String right_url = "https://www.zhaoapi.cn/product/getProductCatagory";

    //详情
    public static String xiangq_url = "http://120.27.23.105/product/getProductDetail";



}
