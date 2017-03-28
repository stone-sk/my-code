package com.example.administrator.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class other extends AppCompatActivity {
    private Intent intent;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Bundle bundle =this.getIntent().getExtras();
        String ans =bundle.getString("ans");
        String sexText="";
        if(ans.equals("1921年")){
            sexText="正确";
        }else {
            sexText="错误";
        }
        TextView tv1=(TextView)findViewById(R.id.text1);
        tv1.setText("你的答案是:"+sexText);
        Button b1=(Button)findViewById(R.id.button_back);
        b1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                other.this.setResult(RESULT_OK,intent);
                other.this.finish();
            }
        });
    }
}
