package bwei.com.jingddab.FragmentM;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import bwei.com.jingddab.BeanUtils.GGGBean;
import bwei.com.jingddab.BeanUtils.ShouyeBean;
import bwei.com.jingddab.KongJian.MyAdapterggg;
import bwei.com.jingddab.Model.ModelImpl;
import bwei.com.jingddab.Presenter.PresenterImpl;
import bwei.com.jingddab.R;
import bwei.com.jingddab.View.IMainView;
import bwei.com.jingddab.activity.CaptureActivity;

import static android.content.ContentValues.TAG;

public class ShouYeFragment extends Fragment implements IMainView {
    private XRecyclerView xrc;
    private View inflate;
    List<String> lunbolist = new ArrayList<>();
    List<GGGBean.DataBean> data;
    private MyAdapterggg myadapter;
    Handler handler = new Handler();
    private View view;
    private int mDistanceY;
    private ImageView syss;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shouye, container, false);
        xrc = view.findViewById(R.id.xrc);
        PresenterImpl mypresenter = new PresenterImpl();
        mypresenter.getmv1(this, new ModelImpl());
        mypresenter.getmv(getContext(), this, new ModelImpl());
        inflate = View.inflate(getContext(), R.layout.shouye_xbanner, null);
        xrc.addHeaderView(inflate);
        initView(view);
        initPermission();
        return view;

    }

    private void initView(@NonNull final View view) {
        syss = (ImageView) view.findViewById(R.id.syss);
        syss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);

                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public void setadapter(Context context, ShouyeBean shouye_bean) {


        List<ShouyeBean.DataBean> data1 = shouye_bean.getData();
        for (int i = 0; i < data1.size(); i++) {
            lunbolist.add(data1.get(i).getIcon());
        }
        XBanner myxbanner = inflate.findViewById(R.id.myxbanner);
        myxbanner.setData(lunbolist, null);
        myxbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getContext()).load(lunbolist.get(position)).into((ImageView) view);
            }
        });
        myadapter = new MyAdapterggg(context, data, shouye_bean);
        xrc.setAdapter(myadapter);
        xrc.setLayoutManager(new LinearLayoutManager(context));
        xrc.setLoadingMoreEnabled(false);
        xrc.setLoadingListener(new XRecyclerView.LoadingListener() {

            private FrameLayout fg;

            @Override
            public void onRefresh() {
                fg = view.findViewById(R.id.fg);
                fg.setVisibility(View.GONE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fg.setVisibility(View.VISIBLE);
                        xrc.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {

            }
        });

        xrc.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
                FrameLayout f1_frag = view.findViewById(R.id.fg);
                int toolbarHeight = f1_frag.getBottom();

                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= 300) {
                    float scale = (float) mDistanceY / 300;
                    float alpha = scale * 255;
                    f1_frag.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));

                } else {
                    //将标题栏的颜色设置为完全不透明状态
                    f1_frag.setBackgroundResource(R.color.colorAccent);

                }
            }
        });


    }

    @Override
    public void setadapter1(List<GGGBean.DataBean> data) {
        this.data = data;

    }
    private void initPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]	{
                    Manifest.permission.CAMERA}, 1);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "接收到数据-----: ");
        Bundle bundle = data.getBundleExtra("data");
        String string = bundle.getString("result");
    }
}
