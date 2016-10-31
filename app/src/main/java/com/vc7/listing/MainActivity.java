package com.vc7.listing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    ArrayList<String> listItems = new ArrayList<String>();
    ItemAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);
        listAdapter = new ItemAdapter(this);
        listAdapter.setItemList(this.listItems);

        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(listener);

    }

    public void addItem(View view) {
        listItems.add("clicked");
        listAdapter.notifyDataSetChanged();
    }
}
