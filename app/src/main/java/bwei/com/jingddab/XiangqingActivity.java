package bwei.com.jingddab;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;


import butterknife.BindView;
import butterknife.ButterKnife;
import bwei.com.jingddab.BeanUtils.AddShopBean;
import bwei.com.jingddab.Http.HttpUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class XiangqingActivity extends Activity {

    private static final String TAG ="XiangqingActivity---" ;

    @BindView(R.id.img)
    SimpleDraweeView img;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.pid)
    TextView pid;
    @BindView(R.id.shop)
    Button shop;
    private int pid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        ButterKnife.bind(this);

        //接受值
        Intent intent = getIntent();
        String img1 = intent.getStringExtra("photo");
        String name1 = intent.getStringExtra("name");
        String price1 = intent.getStringExtra("price");
        pid1 = intent.getExtras().getInt("pid");
        Toast.makeText(this,pid1+"",Toast.LENGTH_SHORT).show();

        //赋值
        Glide.with(this).load(img1).into(img);
        name.setText(name1);
        price.setText(price1);
        pid.setText(""+ pid1);
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("person", MODE_PRIVATE);
        String username = sharedPreferences.getString("username",null);

        if(username!=null){
            //点击添加到购物车
            shopping();

        }else{
            //点击添加到购物车
            shopping();
        }
    }

    //添加
    private void shopping() {

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofit2.Call<AddShopBean> android = HttpUtil.getInsance("http://120.27.23.105/product/").getApi().doGet("android", 13939, pid1);

                android.enqueue(new retrofit2.Callback<AddShopBean>() {
                    @Override
                    public void onResponse(retrofit2.Call<AddShopBean> call, retrofit2.Response<AddShopBean> response) {

                        AddShopBean body = response.body();

                        if(body.getMsg().equals("加购成功")){
                            Toast.makeText(XiangqingActivity.this,body.getMsg(),Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(XiangqingActivity.this,body.getMsg(),Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(retrofit2.Call<AddShopBean> call, Throwable t) {

                    }
                });
            }
        });
    }
}
