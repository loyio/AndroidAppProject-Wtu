package me.loyio.listviewapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.datalist)
    ListView dataList;
    private String data[][]={{"Loyio","13578942555","123456@139.com"},
            {"Max","1300000000","99999@qq.com"},
            {"Key","15899887485", "qwer@163.com"}
    };
    private List<Map<String,String>> list = new ArrayList<>();
    private SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for (int i = 0; i < data.length; i++) {
            Map<String,String> map = new HashMap<>();
            map.put("name",this.data[i][0]);
            map.put("phone",this.data[i][1]);
            map.put("email",this.data[i][2]);
            this.list.add(map);
        }
        //adapter = new MyAdapter(this,list);
        this.adapter = new SimpleAdapter(this,this.list,R.layout.data_list,
                new String[]{"name","phone","email"},new int[]{R.id.nameTv,R.id.phoneTv,R.id.emailTv});
        this.dataList.setAdapter(adapter);
    }
}