package bwei.com.jingddab.Http;




import java.util.Map;

import bwei.com.jingddab.BeanUtils.AddShopBean;
import bwei.com.jingddab.BeanUtils.DeleteBean;
import bwei.com.jingddab.BeanUtils.QueryBean;
import bwei.com.jingddab.BeanUtils.UpBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2018/4/24.
 */

public interface GouApi {
    //添加
    @GET("addCart")
    Call<AddShopBean>doGet(@Query("source") String source, @Query("uid") int uid, @Query("pid") int pid);

    //查询
    @GET("getCarts")
    Call<QueryBean>doQuery(@Query("uid") int uid, @Query("source") String source);


//最主要更新 运用到加、减、全选

    @GET("updateCarts")Call<UpBean>update(@Query("uid") int uid, @QueryMap Map<String, String> params);


//删除

    @GET("product/deleteCart")Call<DeleteBean> del(@Query("uid") String uid, @Query("pid") String pid);
}
