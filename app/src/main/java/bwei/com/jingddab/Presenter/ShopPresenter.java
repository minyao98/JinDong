package bwei.com.jingddab.Presenter;


import bwei.com.jingddab.BeanUtils.ShopBean;
import bwei.com.jingddab.Model.ShopModel;
import bwei.com.jingddab.View.IMshopview;


/**
 * Created by huoxuebin on 2018/4/25.
 */

public class ShopPresenter implements IMShopPresenter {

    private ShopModel shopModel;
    private IMshopview iMshopview;

    public ShopPresenter(IMshopview iMshopview) {
        this.iMshopview=iMshopview;
        shopModel = new ShopModel(this);


    }

    public void getshop(String s, int uid) {
        shopModel.getshop(s,uid);

    }

    @Override
    public void shop(ShopBean shopBean) {
        iMshopview.shop(shopBean);

    }
}
