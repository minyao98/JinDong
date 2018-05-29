package bwei.com.jingddab.KongJian;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import bwei.com.jingddab.R;

/**
 * 1.组合控件
 * 将原有的控件组合起来成为一个整体---控件
 * <p>
 * 1.根据需求，写布局文件
 * 2.布局文件---View
 * 3.逻辑
 * <p>
 * 2.自定义View
 * 3.自定义ViewGroup
 * <p>
 * 构造
 * onDraw
 * 绘制，文字，图片，颜色，形状
 * onMeasure
 * 测量
 * onLayout
 * 布局
 * onSizeChange
 * 当控件大小改变是调用
 * onTouchEvent
 * 处理触摸事件
 */

public class MySearchView extends LinearLayout {

    private EditText search_content;

    //1.
    //直接new的时候
    public MySearchView(Context context) {
        this(context, null);
    }

    public MySearchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //在布局文件里面时候控件的时候
    public MySearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化
        View view = View.inflate(context, R.layout.shouye_search, this);
        search_content = view.findViewById(R.id.search_content);
    }

    //获取输入的内容

    public String getContent() {
        return search_content.getText().toString();
    }

}
