package com.example.administrator.xss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.umeng.analytics.MobclickAgent;


public class Login_2 extends AppCompatActivity {

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
        setContentView(R.layout.login_2);

    }
    public void login(View view) {
        Intent it=new  Intent(Login_2.this,Login_3.class);
        Login_2.this.startActivity(it);
    }
    public void back(View view) {
        Intent it=new  Intent(Login_2.this,Login_1.class);
        Login_2.this.startActivity(it);
    }
}