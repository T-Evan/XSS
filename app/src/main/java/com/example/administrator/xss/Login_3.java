package com.example.administrator.xss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.umeng.analytics.MobclickAgent;


public class    Login_3 extends AppCompatActivity {

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        MobclickAgent.setDebugMode(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_3);
    }
    public void login(View view) {
      Intent it=new  Intent(Login_3.this,MainActivity.class);
        Login_3.this.startActivity(it);
    }
    public void back(View view) {
        Intent it=new  Intent(Login_3.this,Login_2.class);
        Login_3.this.startActivity(it);
    }
}