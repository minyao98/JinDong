package bwei.com.jingddab.BeanUtils;

import bwei.com.jingddab.Http.MyRetrofit;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Util {
    private volatile static Util util = null;

    private Util() {

    }

    public static Util getmInstance() {
        if (util == null) {
            synchronized (Util.class) {
                if (util == null) {
                    util = new Util();
                }
            }
        }
        return util;
    }

    public MyRetrofit getnetjson(String uri) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(uri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MyRetrofit testservive = retrofit.create(MyRetrofit.class);
        return testservive;

    }
}
