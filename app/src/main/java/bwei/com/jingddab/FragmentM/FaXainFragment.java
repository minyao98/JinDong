package bwei.com.jingddab.FragmentM;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import bwei.com.jingddab.R;

public class FaXainFragment extends Fragment {
    private WebView Web;
    String url="https://h5.m.jd.com/active/faxian/list/article-list.html";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.faxian, container, false);

        initView(view);

        return view;
    }

    private View initView(@NonNull final View view) {
        Web = (WebView) view.findViewById(R.id.web);
        WebSettings webSettings = Web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        Web.loadUrl(url);
        return view;

    }
}
