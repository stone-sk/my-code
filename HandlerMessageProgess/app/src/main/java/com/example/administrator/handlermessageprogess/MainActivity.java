package com.example.administrator.handlermessageprogess;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private ProgressBar bar=null;
    private Button button=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar=(ProgressBar)findViewById(R.id.probar);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new ButtonListener());
    }
    class ButtonListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            bar.setVisibility(View.VISIBLE);
            updateBarHandler.post(updateThread);
        }
    }
    Handler updateBarHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            bar.setProgress(msg.arg1);
            updateBarHandler.post(updateThread);
        }
    };
    Runnable updateThread =new Runnable() {
        int i=0;
        @Override
        public void run() {
            System.out.println("Begin Thread");
            i=i+10;
            Message msg=updateBarHandler.obtainMessage();
            msg.arg1=i;
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            updateBarHandler.sendMessage(msg);
            if(i==100){
                updateBarHandler.removeCallbacks(updateThread);
            }
        }
    };
}
