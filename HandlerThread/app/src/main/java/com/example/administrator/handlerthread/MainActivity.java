package com.example.administrator.handlerthread;

import android.content.DialogInterface;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private Button starButton=null;
    private Button stopButton=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        starButton=(Button)findViewById(R.id.starbutton);
        starButton.setOnClickListener(new StarButtonListener());
        stopButton=(Button)findViewById(R.id.stopbutton);
        stopButton.setOnClickListener(new StopButtonListener());
    }
    Handler handler=new Handler();
    class StarButtonListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            handler.post(updateThread);
        }
    }
    class StopButtonListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            handler.removeCallbacks(updateThread);
        }
    }
    Runnable updateThread=new Runnable(){

        @Override
        public void run() {
            System.out.println("UpdateThread");
            Log.v("tag","UpdateThread");
            handler.postDelayed(updateThread,2000);
        }
    };
}
