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
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.like.LikeButton;
import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.TwirlEffect;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mauker.materialsearchview.MaterialSearchView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView imageView;
    Bitmap bitmapOriginal;
    TextView textView;
    LikeButton likeButton;
    MaterialSearchView searchView;
    PushAgent mPushAgent;
    private ArrayList<String> list = new ArrayList<String>();

    private int[] recommend_book = new int[]
            {R.drawable.book, R.drawable.book, R.drawable.book, R.drawable.book};
    private String[] recommend_book_state = new String[]
            {"可借"};
    private String[] recommend_book_name = new String[]
            {"失落的黄金国"};
    private String[] recommend_book_writer = new String[]
            {"作者：【英】"};
    private String[] recommend_book_location = new String[]
            {"总馆-9楼北计算机应用借阅室"};
    private String[] recommend_book_value = new String[]
            {"TP393.092.2/8027"};
    public String[] recommend_book_from = new String[]
            {"根据你读过的图书《小王子》推荐"};
    private int[] toborrow_book_image = new int[]
            {R.drawable.book};
    private String[] toborrow_book_name = new String[]
            {"失落的黄金国"};
    private String[] toborrow__book_writer = new String[]
            {"作者：【英】"};
    private String[] toborrow_book_location = new String[]
            {"总馆-9楼北计算机应用借阅室"};
    private String[] toborrow_book_value = new String[]
            {"TP393.092.2/8027"};
    private String[] toborrow_book_state = new String[]
            {"可借"};

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
        PushAgent mPushAgent = PushAgent.getInstance(this);
        mPushAgent.enable();
        PushAgent.getInstance(this).onAppStart();
        MobclickAgent.setDebugMode(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        bitmapOriginal = BitmapFactory.decodeResource(getResources(),
                R.drawable.test);
        bitmapOriginal = CreateBitmap.getTransparentBitmao(bitmapOriginal, 70);

        LayoutInflater inflater = LayoutInflater.from(this);
        View cebian = (View) inflater.inflate(R.layout.nav_header_main, null);
        View think = (View) inflater.inflate(R.layout.think, null);
        View list = (View) inflater.inflate(R.layout.daijie_list, null);
        imageView = (ImageView) cebian.findViewById(R.id.nav_bg);
        imageView.setImageBitmap(createBitmap_ScriptIntrinsicBlur(bitmapOriginal, 16.0f));
        textView = (TextView) think.findViewById(R.id.like_number);
        likeButton = (LikeButton) think.findViewById(R.id.like_button);
        //待借
        List<Map<String, Object>> listItems_toborrow =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < toborrow_book_image.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("toborrow_book_image", toborrow_book_image[i]);
            listItem.put("toborrow_book_name", toborrow_book_name[i]);
            listItem.put("toborrow__book_writer", toborrow__book_writer[i]);
            listItem.put("toborrow_book_location", toborrow_book_location[i]);
            listItem.put("toborrow_book_value", toborrow_book_value[i]);
            listItem.put("toborrow_book_state", toborrow_book_state[i]);
            listItems_toborrow.add(listItem);
        }
        SimpleAdapter simpleAdapter_toborrow = new SimpleAdapter(this, listItems_toborrow,
                R.layout.content_main,
                new String[]{"toborrow_book_image", "toborrow_book_name", "toborrow__book_writer", "toborrow_book_location"
                        , "toborrow_book_value", "toborrow_book_state"},
                new int[]{R.id.toborrow_book_image, R.id.toborrow_book_name, R.id.toborrow_book_writer, R.id.toborrow_book_location,
                        R.id.toborrow_book_value, R.id.toborrow_book_state});
        JazzyListView list_toborrow = (JazzyListView) findViewById(R.id.toborrow_list);
        list_toborrow.setAdapter(simpleAdapter_toborrow);
        list_toborrow.setTransitionEffect(new TwirlEffect());
        SetListViewHeight.setListViewHeight(list_toborrow);
        //待借
        //推荐
        List<Map<String, Object>> listItem_recommend =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 1; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("recommend_book", recommend_book[0]);
            listItem.put("recommend_book_from", recommend_book_from[0]);
            listItem.put("recommend_book_state", recommend_book_state[0]);
            listItem.put("recommend_book_name", recommend_book_name[0]);
            listItem.put("recommend_book_writer", recommend_book_writer[0]);
            listItem.put("recommend_book_location", recommend_book_location[0]);
            listItem.put("recommend_book_value", recommend_book_value[0]);
            listItem_recommend.add(listItem);
        }
        SimpleAdapter simpleAdapter_recommend = new SimpleAdapter(this, listItem_recommend,
                R.layout.recommand,
                new String[]{"recommend_book", "recommend_book_state", "recommend_book_name"
                        , "recommend_book_writer", "recommend_book_location", "recommend_book_value","recommend_book_from"},
                new int[]{R.id.recommend_book, R.id.recommend_book_state, R.id.recommend_book_name,
                        R.id.recommend_book_writer, R.id.recommend_book_location, R.id.recommend_book_value,R.id.recommend_book_from});
        JazzyListView list_recommend = (JazzyListView) findViewById(R.id.recommend_list);
        list_recommend.setAdapter(simpleAdapter_recommend);
        list_recommend.setTransitionEffect(new TwirlEffect());
        SetListViewHeight.setListViewHeight(list_recommend);
        //推荐
//      想法
//        List<Map<String, Object>> listItems_think =
//                new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < user_name.length; i++) {
//            Map<String, Object> listItem = new HashMap<String, Object>();
//            listItem.put("avatar", avatar[i]);
//            listItem.put("user_name", user_name[i]);
//            listItem.put("user_think", user_think[i]);
//            listItem.put("think_book_image", think_book_image[i]);
//            listItem.put("think_book_name", think_book_name[i]);
//            listItem.put("think_book_writer", think_book_writer[i]);
//            listItem.put("send_time", send_time[i]);
//            listItem.put("like_number", like_number[i]);
//            listItems_think.add(listItem);
//        }
//        SimpleAdapter simpleAdapter_think = new SimpleAdapter(this, listItems_think,
//                R.layout.think,
//                new String[]{"avatar", "user_name", "user_think", "think_book_image"
//                        , "think_book_name", "think_book_writer", "send_time", "like_number"},
//                new int[]{R.id.avatar, R.id.user_name, R.id.user_think, R.id.think_book_image
//                        , R.id.think_book_name, R.id.think_book_writer, R.id.send_time, R.id.like_number});
//        JazzyListView list_think = (JazzyListView) findViewById(R.id.think_list);
//
//        // 为ListView设置Adapter
//        list_think.setAdapter(simpleAdapter_think);
//        list_think.setTransitionEffect(new TwirlEffect());
//        SetListViewHeight.setListViewHeight(list_think);
//      想法

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.addHeaderView(cebian);
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



    private Bitmap createBitmap_ScriptIntrinsicBlur(Bitmap src, float r) {

        //Radius range (0 < r <= 25)
        if(r <= 0){
            r = 0.1f;
        }else if(r > 25){
            r = 25.0f;
        }

        Bitmap bitmap = Bitmap.createBitmap(
                src.getWidth(), src.getHeight(),
                Bitmap.Config.ARGB_8888);
        RenderScript renderScript = RenderScript.create(this);

        Allocation blurInput = Allocation.createFromBitmap(renderScript, src);
        Allocation blurOutput = Allocation.createFromBitmap(renderScript, bitmap);

        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(renderScript,
                Element.U8_4(renderScript));
        blur.setInput(blurInput);
        blur.setRadius(r);
        blur.forEach(blurOutput);

        blurOutput.copyTo(bitmap);
        renderScript.destroy();
        return bitmap;
    }



    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.top_menu) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.news) {
            Intent it=new  Intent(MainActivity.this,News.class);
            MainActivity.this.startActivity(it);
        } else if (id == R.id.bookshelves) {
            Intent it=new  Intent(MainActivity.this,ShuJia.class);
            MainActivity.this.startActivity(it);
        } else if (id == R.id.collec_tbook) {
            Intent it=new  Intent(MainActivity.this,ShuDan.class);
            MainActivity.this.startActivity(it);
        } else if (id == R.id.my_idea) {
            Intent it=new  Intent(MainActivity.this,My_jianjie.class);
            MainActivity.this.startActivity(it);

        } else if (id == R.id.setting) {
            Intent it=new  Intent(MainActivity.this,Set.class);
            MainActivity.this.startActivity(it);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    private void toast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }



    public void think_book(View view)
    {
        Intent it=new  Intent(MainActivity.this,Thinks.class);
        MainActivity.this.startActivity(it);
    }
    public void search(View view) {
        searchView.openSearch();

    }

    public void add(View view) {

    }
    public void topmenu(View view) {
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.openDrawer(GravityCompat.START);
    }
    public void toborrow_add(View view) {
    }
}
