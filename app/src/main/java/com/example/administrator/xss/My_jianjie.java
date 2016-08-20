package com.example.administrator.xss;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.flyco.systembar.SystemBarHelper;
import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.TwirlEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class My_jianjie extends AppCompatActivity{
        AppBarLayout mAppbar;
        CollapsingToolbarLayout mCollapsingToolbar;
        Toolbar mToolbar;
        TextView mNickname;
        public String likenumber = "18";
        private int[] avatar = new int[]
                {R.drawable.test};
        public String[] user_name = new String[]
                {"一碗"};
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
                {"12"};

        private JazzyListView jazzyListView;
        private Toolbar toolbar;
        private TextView floatTitle;
        ImageView imageView;
        Bitmap bitmapOriginal;
        private ImageView headerBg;

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
        public void add(View view) {
        }
        public void back(View view) {
                Intent it=new  Intent(My_jianjie.this,MainActivity.class);
                My_jianjie.this.startActivity(it);
                this.finish();

        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.jianjie_statusbar);
                mAppbar =(AppBarLayout)findViewById(R.id.appbar);
                mCollapsingToolbar=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
                mToolbar=(Toolbar)findViewById(R.id.toolbar);
                mNickname=(TextView)findViewById(R.id.nickname);
                bitmapOriginal = BitmapFactory.decodeResource(getResources(),
                        R.drawable.test);
                LayoutInflater inflater = LayoutInflater.from(this);
                bitmapOriginal = CreateBitmap.getTransparentBitmao(bitmapOriginal, 70);
                imageView = (ImageView)findViewById(R.id.jianjie_bg);
                imageView.setImageBitmap(createBitmap_ScriptIntrinsicBlur(bitmapOriginal, 16.0f));

                SystemBarHelper.immersiveStatusBar(this, 0);
                SystemBarHelper.setHeightAndPadding(this, mToolbar);
                mAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                        @Override
                        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                boolean showTitle = mCollapsingToolbar.getHeight() + verticalOffset <= mToolbar.getHeight();
                                boolean showTitle = mCollapsingToolbar.getHeight() + verticalOffset <= mToolbar.getHeight() * 2;
                                mNickname.setVisibility(showTitle ? View.VISIBLE : View.GONE);
                        }
                });

                List<Map<String, Object>> listItems_think =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 6; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("avatar", avatar[0]);
            listItem.put("user_name", user_name[0]);
            listItem.put("user_think", user_think[0]);
            listItem.put("think_book_image", think_book_image[0]);
            listItem.put("think_book_name", think_book_name[0]);
            listItem.put("think_book_writer", think_book_writer[0]);
            listItem.put("send_time", send_time[0]);
            listItem.put("like_number", like_number[0]);
            listItems_think.add(listItem);
        }
        SimpleAdapter simpleAdapter_think = new SimpleAdapter(this, listItems_think,
                R.layout.think_content,
                new String[]{"avatar", "user_name", "user_think", "think_book_image"
                        , "think_book_name", "think_book_writer", "send_time", "like_number"},
                new int[]{R.id.avatar, R.id.user_name, R.id.user_think, R.id.think_book_image
                        , R.id.think_book_name, R.id.think_book_writer, R.id.send_time, R.id.like_number});
        JazzyListView list_think = (JazzyListView) findViewById(R.id.jianjie_list);

        // 为ListView设置Adapter
        list_think.setAdapter(simpleAdapter_think);
        list_think.setTransitionEffect(new TwirlEffect());
        SetListViewHeight.setListViewHeight(list_think);
        }

}





