package com.android.pascal.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.pascal.login.LoginActivity;
import com.android.pascal.mylibrary.LibClass;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        LibClass.ccc();
//        LoginActivity.aaa();

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, Fragment1.newInstance(position), "f1")
                    //.addToBackStack("fname")
                    .commit();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, Fragment1.newInstance(position), "f1")
                        //.addToBackStack("fname")
                        .commit();
                break;
            case R.id.btn2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, Fragment2.newInstance("hello world"), "f2")
                        //.addToBackStack("fname")
                        .commit();
                break;
        }
    }

    private int position = 0 ;
    public void setPosition(int i){
        position = i;
    }
}
