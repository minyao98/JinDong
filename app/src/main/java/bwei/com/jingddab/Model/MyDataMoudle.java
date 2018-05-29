package bwei.com.jingddab.Model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import bwei.com.jingddab.BeanUtils.ShangplbBean;
import bwei.com.jingddab.Http.OkhtttpUtils;
import bwei.com.jingddab.Presenter.DataPresenter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyDataMoudle implements DataMoudle{
    @Override
    public void getData(String url, final DataPresenter dataPresenter) {
        OkhtttpUtils.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();

                Gson gson = new Gson();

                ShangplbBean beandata = gson.fromJson(json, ShangplbBean.class);

                List<ShangplbBean.DataBean> list=beandata.getData();

                dataPresenter.success(list);

            }
        });
    }
}
