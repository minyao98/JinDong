package bwei.com.jingddab;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;

public class YinDy extends AppCompatActivity {

    /**
     * 秒后跳转
     */
    int o = 1;
    private TextView time;
    private Timer timer;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(o<0){
                Intent intent = new Intent(YinDy.this,MainActivity.class);
                startActivity(intent);
                finish();
            }else{
                handler.sendEmptyMessageDelayed(1000,1000);
                time.setText(o+"秒后跳转");
                o--;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dy);

        time = (TextView) findViewById(R.id.time);
        handler.sendEmptyMessageDelayed(1000,1000);

    }
}
