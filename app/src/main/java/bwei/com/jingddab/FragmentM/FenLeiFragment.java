package bwei.com.jingddab.FragmentM;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import bwei.com.jingddab.BeanUtils.LeftBean;
import bwei.com.jingddab.BeanUtils.RightBean;
import bwei.com.jingddab.FenLeiMyadapter.MyAdapter1;
import bwei.com.jingddab.FenLeiMyadapter.MyAdapter2;
import bwei.com.jingddab.Model.FenLeiModelImpl;
import bwei.com.jingddab.Presenter.FenLeiPresenterImpl;
import bwei.com.jingddab.R;
import bwei.com.jingddab.ShangPLBActivity;
import bwei.com.jingddab.View.FenLeiIMainView;

public class FenLeiFragment extends Fragment implements FenLeiIMainView{
    private static final String TAG = "MainActivity";
    private ListView ListviewLeft;
    private ListView ListviewRight;
    private List<LeftBean.DataBean> list;
    private String cid;
    private FenLeiPresenterImpl fenLeiPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fenlei, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        fenLeiPresenter = new FenLeiPresenterImpl();
        fenLeiPresenter.showLeftToView(new FenLeiModelImpl(),this);
    }

    private void initView(@NonNull final View view) {
        ListviewLeft = (ListView) view.findViewById(R.id.left_listview);
        ListviewRight = (ListView) view.findViewById(R.id.right_listview);

        //设置条目点击事件
        ListviewLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cid = list.get(position).getCid() + "";
                //调用p层的方法
                fenLeiPresenter.showRightToView(new FenLeiModelImpl(),FenLeiFragment.this);
            }
        });

    }

    @Override
    public void showLeftView(List<LeftBean.DataBean> list) {

        this.list=list;
        Log.d(TAG, "showLeftView: "+list);
        MyAdapter1 myAdapter1 = new MyAdapter1(getActivity(), list);
        ListviewLeft.setAdapter(myAdapter1);
        //显示右侧的默认值，就是cid=1
        int cid = list.get(0).getCid();
        this.cid=cid+"";

        fenLeiPresenter.showRightToView(new FenLeiModelImpl(),this);

    }

    @Override
    public void showRightView(List<RightBean.DataBean> list) {
        Log.d(TAG, "右侧------: "+list);
        MyAdapter2 myAdapter2 = new MyAdapter2(getActivity(), list);
        ListviewRight.setAdapter(myAdapter2);
    }

    @Override
    public String getCid() {
        return this.cid;
    }
}
