package bwei.com.jingddab.Model;

import java.util.List;

import bwei.com.jingddab.BeanUtils.GGGBean;
import bwei.com.jingddab.BeanUtils.ShouyeBean;
import bwei.com.jingddab.BeanUtils.Util;
import bwei.com.jingddab.Http.HttpConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ModelImpl implements IModel{


    @Override
    public void getnetjson(final Getjson getjson) {
        Observable<ShouyeBean> user = Util.getmInstance().getnetjson(HttpConfig.net).getUser();
        user.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouyeBean>() {
                    @Override
                    public void accept(ShouyeBean shouyeBean) throws Exception {
                        getjson.getnetjson(shouyeBean);
                    }

                });
    }

    @Override
    public void getjiugonggejson(final Getjiugongge getjiugongge) {
        Observable<GGGBean> getjiugongge1 = Util.getmInstance().getnetjson(HttpConfig.net).getjiugongge();
        getjiugongge1.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GGGBean>() {
                    @Override
                    public void accept(GGGBean jiugongge_bean) throws Exception {
                        List<GGGBean.DataBean> data = jiugongge_bean.getData();
                        getjiugongge.getJiugongge(data);
                    }
                });
    }
}
