package com.example.administrator.xss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShuJia extends AppCompatActivity {
    GridView grid;
    private int[] book_image = new int[]
            {R.drawable.book, R.drawable.book, R.drawable.book, R.drawable.book, R.drawable.book,
                    R.drawable.book, R.drawable.book, R.drawable.book};
    private String[] book_name = new String[]
            {"你好,抑郁", "你好,抑郁", "你好,抑郁", "你好,抑郁", "你好,抑郁", "你好,抑郁", "你好,抑郁", "你好,抑郁",};
    private String[] book_state = new String[]
            {"还可以看15天", "还可以看15天", "还可以看15天", "还可以看15天", "还可以看15天", "还可以看15天", "还可以看15天", "还可以看15天",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shujia);
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < book_image.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("book_image", book_image[i]);
            listItem.put("book_name", book_name[i]);
            listItem.put("book_state", book_state[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems,
                R.layout.shujia_content, new String[]{"book_image", "book_name", "book_state"}
                , new int[]{R.id.book_image, R.id.book_name, R.id.book_state});
        grid = (GridView) findViewById(R.id.shujia_gridview);
        grid.setAdapter(simpleAdapter);

    }

    public void back(View view) {
        Intent it = new Intent(ShuJia.this, MainActivity.class);
        ShuJia.this.startActivity(it);
        this.finish();

    }

}