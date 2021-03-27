package com.loyio.loginfuncactivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainLoginActivity extends AppCompatActivity {

    @BindView(R.id.etAccount)
    EditText mEtAccount;

    @BindView(R.id.etPasswd)
    EditText mEtPasswd;

    @BindView(R.id.btnLogin)
    Button btnLoginMy;

    @BindView(R.id.btnReset)
    Button btnResetMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    void LoginBtn(View view){
        if (TextUtils.isEmpty(mEtAccount.getText()) || TextUtils.isEmpty(mEtPasswd.getText())){
            Toast.makeText(this, "请输入账号和密码！！！", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "恭喜你, "+mEtAccount.getText().toString()+"登录成功！！", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btnReset)
    void ResetBtn(View view){
        mEtAccount.setText(null);
        mEtPasswd.setText(null);
        Toast.makeText(this, "已清除账号和密码！！！", Toast.LENGTH_SHORT).show();
    }
}