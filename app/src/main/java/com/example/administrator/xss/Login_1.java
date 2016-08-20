package com.example.administrator.xss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by Administrator on 2016/5/18.
 */
public class Login_1 extends AppCompatActivity {

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
        setContentView(R.layout.login_1);

    }
    public void login(View view) {
      Intent it=new  Intent(Login_1.this,Login_2.class);
        Login_1.this.startActivity(it);
    }
}