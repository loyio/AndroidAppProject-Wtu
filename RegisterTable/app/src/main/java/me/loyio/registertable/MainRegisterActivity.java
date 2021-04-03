package me.loyio.registertable;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainRegisterActivity extends AppCompatActivity {
    
    
    @BindView(R.id.etUsername)
    EditText mEtUsername;

    @BindView(R.id.etPasswd)
    EditText mEtPasswd;

    @BindView(R.id.etPasswdAgain)
    EditText mEtPasswdAgain;

    @BindView(R.id.rbMale)
    RadioButton mRbMale;

    @BindView(R.id.rbFemale)
    RadioButton mRbFemale;

    @BindView(R.id.spJob)
    Spinner mSpJob;

    @BindView(R.id.cbGame)
    CheckBox mCbGame;

    @BindView(R.id.cbMovie)
    CheckBox mCbMovie;

    @BindView(R.id.cbMusic)
    CheckBox mCbMusic;

    @BindView(R.id.cbSoccer)
    CheckBox mCbSoccer;

    @BindView(R.id.cbSwim)
    CheckBox mCbSwim;

    @BindView(R.id.cbTrip)
    CheckBox mCbTrip;

    @BindView(R.id.btnReg)
    Button mBtnReg;

    @BindView(R.id.btnReset)
    Button mBtnReset;

    CheckBox[] cbInterst = new CheckBox[6];
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);
        ButterKnife.bind(this);
        cbInterst[0]=mCbGame;
        cbInterst[1]=mCbMovie;
        cbInterst[2]=mCbMusic;
        cbInterst[3]=mCbSoccer;
        cbInterst[4]=mCbSwim;
        cbInterst[5]=mCbTrip;

    }

    @OnClick(R.id.btnReg) void onRegClicked(){
        String str = "";
        str += "用户名: " + mEtUsername.getText() + "\n";
        str += "密码: " + mEtPasswd.getText() + "\n";
        if (mRbMale.isChecked()){
            str += "性别: " + mRbMale.getText() + "\n";
        }else{
            str += "性别: " + mRbFemale.getText() + "\n";
        }
        str += "职业: " + mSpJob.getSelectedItem() + "\n";
        str += "兴趣: ";
        for (int i=0; i<6;i++){
            if(cbInterst[i].isChecked()){
                str += cbInterst[i].getText() + " ";
            }
        }
        new AlertDialog.Builder(this)
                .setTitle("注册信息")
                .setMessage(str)
                .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                })
                .show();
    }

    @OnClick(R.id.btnReset) void onResetClicked(){
        mEtUsername.setText("");
        mEtPasswd.setText("");
        mEtPasswdAgain.setText("");
        mRbMale.setChecked(true);
        mSpJob.setSelection(0);
        for (int i=0; i<6;i++){
            cbInterst[i].setChecked(false);
        }
        Toast.makeText(this, "已重置所有数据", Toast.LENGTH_LONG).show();
    }
}