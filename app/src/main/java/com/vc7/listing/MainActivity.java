package com.vc7.listing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("ListView", "clicked " + position);
        }
    };

    ArrayList<Item> listItems = new ArrayList<Item>();
    ItemAdapter listAdapter;
    Intent formIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listItems.add(new Item("2016/10/20", "陰天 - 鋼筆繪日記"));
        this.listItems.add(new Item("2016/10/12", "下雨天 - 鋼筆繪日記"));
        this.listItems.add(new Item("2016/09/23", "吃太飽了 - 鋼筆繪日記"));

        ListView listView = (ListView)findViewById(R.id.listView);
        listAdapter = new ItemAdapter(this);
        listAdapter.setItemList(this.listItems);

        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(listener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                switch (resultCode) {
                    case RESULT_OK:
                        String title = data.getStringExtra("title");
                        String header = data.getStringExtra("header");

                        Item item = new Item(header, title);
                        listItems.add(0, item);
                        listAdapter.notifyDataSetChanged();
                        break;
                    default:
                        break;
                }
            default:
                break;
        }
    }

    public void addItem(View view) {
        formIntent = new Intent(this, FormActivity.class);
        startActivityForResult(formIntent, 1);
    }
}
