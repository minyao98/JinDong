package bwei.com.jingddab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

import bwei.com.jingddab.FragmentM.ShouYeFragment;
import bwei.com.jingddab.FragmentM.WoDeFragment;
import bwei.com.jingddab.Model.ILoginModel;
import bwei.com.jingddab.Model.ILoginModelListener;
import bwei.com.jingddab.Model.LoginModelImpl;
import bwei.com.jingddab.Presenter.PresenterImpl;
import bwei.com.jingddab.View.ILoginView;

public class Wode_dlzc extends AppCompatActivity implements View.OnClickListener,ILoginView {

    private EditText login_mobile;
    private EditText login_password;
    private Button login;
    private TextView reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wode_dlzc);
        initView();

    }

    private void initView() {
        login_mobile = (EditText) findViewById(R.id.login_mobile);
        login_password = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        reg = (TextView) findViewById(R.id.reg);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                //点击登陆
                PresenterImpl presenter = new PresenterImpl();
                presenter.getLoginJson(new LoginModelImpl(),Wode_dlzc.this);
                break;
            case R.id.reg:
                //点击注册
                Intent intent =new Intent(Wode_dlzc.this,RegActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    @Override
    public void showLoginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Wode_dlzc.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLoginError(String error) {
        Toast.makeText(this, "登录失败："+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getMobile() {
        return login_mobile.getText().toString();
    }

    @Override
    public String getPassword() {
        return login_password.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
