package com.example.administrator.xss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.TwirlEffect;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mauker.materialsearchview.MaterialSearchView;
import xyz.hanks.library.SmallBang;
import xyz.hanks.library.SmallBangListener;


public class Thinks  extends AppCompatActivity {

    private SmallBang mSmallBang;
    MaterialSearchView searchView;

    public String likenumber = "18";
    private int[] avatar = new int[]
            {R.drawable.avatar, R.drawable.avatar
                    , R.drawable.avatar, R.drawable.avatar};
    public String[] user_name = new String[]
            {"张寰瑾"};
    private String[] think_book_name = new String[]
            {"失落的黄金国"};
    private int[] think_book_image = new int[]
            {R.drawable.book};
    public String[] think_book_writer = new String[]
            {"英]戴维·塞达里斯"};
    private String[] user_think = new String[]
            {"一段被遗忘的历史，他确实不可能属于那些恢弘的记述，因为一切都徒劳的简直可笑"};
    private String[] send_time = new String[]
            {"6月22日 19：00"};
    private String[] like_number = new String[]
            {"12", "13", "14", "15"};
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
        setContentView(R.layout.think);
        mSmallBang = SmallBang.attach2Window(this);

        List<Map<String, Object>> listItems_think =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 4; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("avatar", avatar[0]);
            listItem.put("user_name", user_name[0]);
            listItem.put("user_think", user_think[0]);
            listItem.put("think_book_image", think_book_image[0]);
            listItem.put("think_book_name", think_book_name[0]);
            listItem.put("think_book_writer", think_book_writer[0]);
            listItem.put("send_time", send_time[0]);
            listItem.put("like_number", like_number[i]);
            listItems_think.add(listItem);
        }
        SimpleAdapter simpleAdapter_think = new SimpleAdapter(this, listItems_think,
                R.layout.think_content,
                new String[]{"avatar", "user_name", "user_think", "think_book_image"
                        , "think_book_name", "think_book_writer", "send_time", "like_number"},
                new int[]{R.id.avatar, R.id.user_name, R.id.user_think, R.id.think_book_image
                        , R.id.think_book_name, R.id.think_book_writer, R.id.send_time, R.id.like_number});
        JazzyListView list_think = (JazzyListView) findViewById(R.id.think_list);

        // 为ListView设置Adapter
        list_think.setAdapter(simpleAdapter_think);
        list_think.setTransitionEffect(new TwirlEffect());
        SetListViewHeight.setListViewHeight(list_think);
        MaterialRefreshLayout materialRefreshLayout;
        materialRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.refresh);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefresh();
                    }
                },1000);
            }
        });}

    private void toast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    public void like(View view){

        mSmallBang.bang(view);
        mSmallBang.setmListener(new SmallBangListener() {
            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationEnd() {
                toast("heart+1");

            }
        });
    }
    public void think_like(View view) {
        like(view);
    }
    public void back(View view) {
        Intent it=new  Intent(Thinks.this,MainActivity.class);
        Thinks.this.startActivity(it);
        this.finish();

    }
}