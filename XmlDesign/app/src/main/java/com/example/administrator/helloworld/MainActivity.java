package com.example.administrator.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioButton r1 = null;
    RadioButton r2 = null;
    RadioButton r3 = null;
    RadioButton r4 = null;
    RadioGroup radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获得单选按钮组
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        // 获得单选按钮
        r1 = (RadioButton) findViewById(R.id.a);
        r2 = (RadioButton) findViewById(R.id.b);
        r3 = (RadioButton) findViewById(R.id.c);
        r4 = (RadioButton) findViewById(R.id.d);
        r1.setClickable(true);
        // 监听单选按钮
        //radioGroup.setOnCheckedChangeListener(mChangeRadio);
        Button btn1_sure = (Button) findViewById(R.id.sure);
        Button btn2_cancel = (Button) findViewById(R.id.cancel);
        btn1_sure.setOnClickListener(new btn1_sure());//为Button设置监听事件
        btn2_cancel.setOnClickListener(new btn2_cancel());
    }
    class btn1_sure implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String ans="";
            if(r1.isChecked()){
                ans="1920年";
            }else if(r2.isChecked()){
                ans="1921年";
            }else if(r3.isChecked()){
                ans="1922年";
            }else if(r4.isChecked()){
                ans="1923年";
            }
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,other.class);
            Bundle bundle=new Bundle();
            bundle.putString("ans",ans);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
    class btn2_cancel implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            radioGroup.clearCheck();
            setTitle("");
        }
    }
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
//当requestCode、resultCode同时为0，也就是处理特定的结果
        if (requestCode == 0
                && resultCode == 0) {
/* 取得来自Activity2 的数据，并显示于画面上 */
            Bundle bunde = data.getBundleExtra("result_bundle");
            String ans = bunde.getString("result_data");
            Log.i("zhouweizhi<<" , ans);
          //  tv_result.setText(ans);
        }
    }
}
