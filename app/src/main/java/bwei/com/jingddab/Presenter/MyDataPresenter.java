package bwei.com.jingddab.Presenter;


import java.util.List;

import bwei.com.jingddab.BeanUtils.ShangplbBean;
import bwei.com.jingddab.Model.MyDataMoudle;
import bwei.com.jingddab.View.DataView;

public class MyDataPresenter implements DataPresenter {

    private final MyDataMoudle myDataMoudle;
    DataView dataView;

    public  MyDataPresenter(DataView dataView){
        this.dataView = dataView;
        myDataMoudle = new MyDataMoudle();
    }

    @Override
    public void success(List<ShangplbBean.DataBean> list) {
        dataView.toBackHome(list);
    }

    @Override
    public void eroor() {

    }

    public void netWork(String url) {

        myDataMoudle.getData(url,this);


    }
}