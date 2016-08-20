package com.example.administrator.xss;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.TwirlEffect;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class News extends AppCompatActivity{
    private int[] avatar = new int[]
            {R.drawable.test, R.drawable.avatar
                    , R.drawable.test};
    public String[] user_name = new String[]
            {"带带", "呆呆", "带带"};
    private String[] send_time = new String[]
            {"5月15日 19：00", "6月22日 19：00", "4月8日 19：00", "1月1日 19：00"};
    private String[] user_news = new String[]
            {"欢迎和小书生共度后青春期~","赞同了你的见解“青春是一张花样的纸...”","你有1本图书五天内到期"};
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
        setContentView(R.layout.news);
        List<Map<String, Object>> listItems_think =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < user_name.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("avatar", avatar[i]);
            listItem.put("user_name", user_name[i]);
            listItem.put("user_news", user_news[i]);
            listItem.put("send_time", send_time[i]);
            listItems_think.add(listItem);
        }
        SimpleAdapter simpleAdapter_think = new SimpleAdapter(this, listItems_think,
                R.layout.news_content,
                new String[]{"avatar", "user_name", "user_news","send_time"},
                new int[]{R.id.avatar, R.id.user_name, R.id.user_news,R.id.send_time});
        JazzyListView list_think = (JazzyListView) findViewById(R.id.news_list);
        // 为ListView设置Adapter
        list_think.setAdapter(simpleAdapter_think);
        list_think.setTransitionEffect(new TwirlEffect());


        SetListViewHeight.setListViewHeight(list_think);

    }


    public void back(View view) {
        Intent it=new  Intent(News.this,MainActivity.class);
        News.this.startActivity(it);
        this.finish();
    }
}