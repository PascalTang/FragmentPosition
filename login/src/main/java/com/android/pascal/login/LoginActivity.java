package com.android.pascal.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.pascal.mylibrary.LibClass;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void aaa(){
        LibClass.ccc();
    }
}
