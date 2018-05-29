package bwei.com.jingddab;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import bwei.com.jingddab.BeanUtils.ShangplbBean;
import bwei.com.jingddab.KongJian.MyAdapter;
import bwei.com.jingddab.Presenter.MyDataPresenter;
import bwei.com.jingddab.View.DataView;

public class ShangPLBActivity extends AppCompatActivity implements DataView{

    private String url="https://www.zhaoapi.cn/product/getProducts?pscid=2";
    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            final List<ShangplbBean.DataBean> list = (List<ShangplbBean.DataBean>) msg.obj;


            MyAdapter myAdapter = new MyAdapter(ShangPLBActivity.this, list);

            rec.setAdapter(myAdapter);
            myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
                @Override
                public void itemClick(View v, int position) {
                    Intent intent = new Intent(ShangPLBActivity.this,XiangqingActivity.class);

                    //截取第一张
                    String[] split = list.get(position).getImages().split("\\|");

                    //传值
                    intent.putExtra("photo",split[0]);
                    intent.putExtra("name",list.get(position).getTitle());
                    intent.putExtra("price",list.get(position).getPrice()+"");

                    int pid = (int) list.get(position).getPid();

                    intent.putExtra("pid",pid);


                    startActivity(intent);
                }

                @Override
                public void itemLongClick(View v, int position) {

                }
            });

        }
    };
    private RecyclerView rec;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangplb);

       rec = findViewById(R.id.rec);
        final ImageView image=findViewById(R.id.image);

        MyDataPresenter presenter = new MyDataPresenter(this);
        presenter.netWork(url);
        rec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if (i%2==0){
                    rec.setLayoutManager(new LinearLayoutManager(ShangPLBActivity.this,LinearLayoutManager.VERTICAL,false));
                }else {
                    rec.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                }


                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(image,"rotation",0f,180f);
                objectAnimator.setDuration(500);
                objectAnimator.start();
            }
        });
    }

   @Override
    public void toBackHome(List<ShangplbBean.DataBean> list) {
        Message msg = new Message();
        msg.obj= list;

        handler.sendMessage(msg);
    }
}
