package com.example.administrator.xss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.twotoasters.jazzylistview.JazzyListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShuDan_details extends AppCompatActivity {
    TextView textView;

    private int[] shudan_book_image = new int[]
            {R.drawable.book};
    private String[] shudan_book_state = new String[]
            {"可借"};
    private String[] shudan_book_name = new String[]
            {"失落的黄金国"};
    private String[] shudan__book_writer = new String[]
            {"作者：【英】"};
    private String[] shudan_book_location = new String[]
            {"总馆-9楼北计算机应用借阅室"};
    private String[] shudan_book_value = new String[]
            {"TP393.092.2/8027"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shudan_details);

        List<Map<String, Object>> listItems_shudan =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 4; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("shudan_book_image", shudan_book_image[0]);
            listItem.put("shudan_book_name", shudan_book_name[0]);
            listItem.put("shudan__book_writer", shudan__book_writer[0]);
            listItem.put("shudan_book_location", shudan_book_location[0]);
            listItem.put("shudan_book_value",shudan_book_value[0]);
            listItem.put("shudan_book_state",shudan_book_state[0]);
            listItems_shudan.add(listItem);
        }
        SimpleAdapter simpleAdapter_shudan = new SimpleAdapter(this, listItems_shudan,
                R.layout.shudan_details_content,
                new String[]{"shudan_book_image", "shudan_book_name", "shudan__book_writer", "shudan_book_location"
                        , "shudan_book_value", "shudan_book_state"},
                new int[]{R.id.shudan_book_image, R.id.shudan_book_name, R.id.shudan_book_writer, R.id.shudan_book_location,
                        R.id.shudan_book_value, R.id.shudan_book_state});
        JazzyListView list_toborrow = (JazzyListView) findViewById(R.id.shudan_details_list);
        list_toborrow.setAdapter(simpleAdapter_shudan);
        SetListViewHeight.setListViewHeight(list_toborrow);}

    public void back(View view) {
        Intent it = new Intent(ShuDan_details.this, ShuDan.class);
        ShuDan_details.this.startActivity(it);
        this.finish();

    }
}