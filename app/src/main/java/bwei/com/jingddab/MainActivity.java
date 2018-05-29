package bwei.com.jingddab;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;

import bwei.com.jingddab.FragmentM.FaXainFragment;
import bwei.com.jingddab.FragmentM.FenLeiFragment;
import bwei.com.jingddab.FragmentM.GouWuCheFragment;
import bwei.com.jingddab.FragmentM.ShouYeFragment;
import bwei.com.jingddab.FragmentM.WoDeFragment;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        BotomBar();
    }

    private void BotomBar() {
        //BottomTabBar配置
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(200, 200)
                .setFontSize(0)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("首页", R.drawable.sy1, ShouYeFragment.class)
                .addTabItem("分类", R.drawable.fl1, FenLeiFragment.class)
                .addTabItem("发现", R.drawable.fx1, FaXainFragment.class)
                .addTabItem("购物车", R.drawable.gwc, GouWuCheFragment.class)
                .addTabItem("我的", R.drawable.wd1, WoDeFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

    private void initView() {
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);
    }
}
