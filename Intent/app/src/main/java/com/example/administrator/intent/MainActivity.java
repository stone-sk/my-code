package com.example.administrator.intent;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button=(Button)findViewById(R.id.Button1);
        final EditText phoneNum=(EditText)findViewById(R.id.Editext1);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = phoneNum.getText().toString();
                if (PhoneNumberUtils.isGlobalPhoneNumber(call)) {
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://"+call));
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this,R.string.notify_incorent_phonenum,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
