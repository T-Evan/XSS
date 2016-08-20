package com.example.administrator.xss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by Administrator on 2016/7/11.
 */
public class Set extends AppCompatActivity {

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
        setContentView(R.layout.set);

    }
    public void back(View view) {
        Intent it=new  Intent(Set.this,MainActivity.class);
        Set.this.startActivity(it);
        this.finish();

    }
}