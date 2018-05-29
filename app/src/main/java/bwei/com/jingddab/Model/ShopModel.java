package bwei.com.jingddab.Model;



import java.util.HashMap;
import java.util.Map;

import bwei.com.jingddab.BeanUtils.ShopBean;
import bwei.com.jingddab.Http.BaseObserver;
import bwei.com.jingddab.KongJian.RetrofitManager;
import bwei.com.jingddab.Presenter.IMShopPresenter;
import bwei.com.jingddab.Presenter.ShopPresenter;

/**
 * Created by huoxuebin on 2018/4/25.
 */

public class ShopModel {
    private IMShopPresenter imShopPresenter;

    public ShopModel(ShopPresenter imShopPresenter) {
        this.imShopPresenter=imShopPresenter;

    }


    public void getshop(final String s, int uid) {

        Map<String,String> map = new HashMap<>();

        map.put("uid", String.valueOf(uid));
        map.put("source","android");
        RetrofitManager.post(s, map, new BaseObserver<ShopBean>() {
            @Override
            public void success(ShopBean shopBean) {
                imShopPresenter.shop(shopBean);


            }

            @Override
            public void failure(int code) {

            }
        });
    }
}

