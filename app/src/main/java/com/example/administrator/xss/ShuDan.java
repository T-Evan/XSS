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

public class ShuDan extends AppCompatActivity {
    GridView grid;
    private int[] book_image = new int[]
            {R.drawable.bookimage1, R.drawable.bookimage2};
    private String[] book_name = new String[]
            {"回忆里的猖狂", "反正就是喜欢"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shudan);

        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < book_image.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("book_image", book_image[i]);
            listItem.put("book_name", book_name[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems,
                R.layout.shudan_content, new String[]{"book_image", "book_name"}
                , new int[]{R.id.book_image, R.id.book_name});
        grid = (GridView) findViewById(R.id.shudan_gridview);
        grid.setAdapter(simpleAdapter);

    }

    public void back(View view) {
        Intent it = new Intent(ShuDan.this, MainActivity.class);
        ShuDan.this.startActivity(it);
    }
    public void book_image(View view) {
        Intent it = new Intent(ShuDan.this, ShuDan_details.class);
        ShuDan.this.startActivity(it);
        this.finish();

    }
}