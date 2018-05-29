package bwei.com.jingddab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bwei.com.jingddab.FragmentM.WoDeFragment;
import bwei.com.jingddab.Model.RegModelImpl;
import bwei.com.jingddab.Presenter.PresenterImpl;
import bwei.com.jingddab.View.IRegView;

public class RegActivity extends AppCompatActivity implements View.OnClickListener,IRegView {

    private EditText login_mobile;
    private EditText login_password;
    private Button reg_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
    }

    private void initView() {
        login_mobile = (EditText) findViewById(R.id.login_mobile);
        login_password = (EditText) findViewById(R.id.login_password);
        reg_but = (Button) findViewById(R.id.reg_but);
        reg_but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg_but:
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                PresenterImpl presenter = new PresenterImpl();
                presenter.getRegJson(new RegModelImpl(),this);
                break;
            default:
                break;
        }
    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegActivity.this,Wode_dlzc.class);
        startActivity(intent);
    }

    @Override
    public void showLoginError(String error) {
        Toast.makeText(this, "注册失败"+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getMobile() {
        return login_mobile.getText().toString();
    }

    @Override
    public String getPassword() {
        return login_password.getText().toString();
    }
}
