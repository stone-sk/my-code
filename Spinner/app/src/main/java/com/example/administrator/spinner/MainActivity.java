package com.example.administrator.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String[] countriesStr ={"广州","从化","武汉","汕头"};
    private TextView mytextView;
    private Spinner  myspinner;
    private ArrayAdapter adapter;
    private Button mybutton_add;
    private Button mybutton_remove;
    private EditText myeditext;
    private List allCountries;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allCountries=new ArrayList();
        for (int i=0;i<countriesStr.length;i++){
            allCountries.add(countriesStr[i]);
        }
        mytextView =(TextView) findViewById(R.id.mytestview);
        myspinner =(Spinner)findViewById(R.id.myspinner);
        mybutton_add=(Button)findViewById(R.id.insert) ;
        mybutton_remove=(Button)findViewById(R.id.delete);
        myeditext=(EditText)findViewById(R.id.myEditext);
        adapter =new ArrayAdapter(this,android.R.layout.simple_spinner_item,allCountries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        myspinner.setAdapter(adapter);
        mybutton_add.setOnClickListener(new  Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                String newCountry=myeditext.getText().toString();
                for (int i=0;i<adapter.getCount();i++){
                    if(newCountry.equals(adapter.getItem(i))){
                        return;
                    }
                }
                if (!newCountry.equals("")){
                    adapter.add(newCountry);
                    int position =adapter.getPosition(newCountry);
                    myspinner.setSelection(position);
                    myeditext.setText("");
                }
            }
        });
        mybutton_remove.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(myspinner.getSelectedItem()!=null){
                    adapter.remove(myspinner.getSelectedItem().toString());
                    myeditext.setText("");
                    if (adapter.getCount()==0){
                        mytextView.setText("");
                    }
                }
            }
        });
        myspinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int arg2, long arg3) {
                mytextView.setText(arg0.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {
            }
        }
        );

        myAnimation= AnimationUtils.loadAnimation(this,R.anim.myanim);
        myspinner.setOnTouchListener(new Spinner.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.startAnimation(myAnimation);
                v.setVisibility(View.VISIBLE);
                return false;
            }
        });
        myspinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.spinner,menu);
        return true;
    }
}
