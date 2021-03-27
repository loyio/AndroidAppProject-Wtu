package com.loyio.transferdataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);

        TextView tvSecond = (TextView) findViewById(R.id.textview_second);

        String name = getIntent().getStringExtra("data_first");
        tvSecond.setText("ActivityFirst传过来的数据："+name);

    }

    @Override
    public void onBackPressed() {
        EditText etSecond = (EditText) findViewById(R.id.inputSecond);
        Intent intent = new Intent();
        intent.putExtra("data_second", etSecond.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}