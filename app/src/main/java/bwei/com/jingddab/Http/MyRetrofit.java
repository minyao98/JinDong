package bwei.com.jingddab.Http;

import java.util.Map;

import bwei.com.jingddab.BeanUtils.GGGBean;
import bwei.com.jingddab.BeanUtils.GoodsBean;
import bwei.com.jingddab.BeanUtils.ShouyeBean;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by admin on 2018/5/12.
 */

public interface MyRetrofit {

    @GET("ad/getAd")
    Observable<ShouyeBean> getUser();

    @GET("product/getCatagory")
    Observable<GGGBean> getjiugongge();

}
