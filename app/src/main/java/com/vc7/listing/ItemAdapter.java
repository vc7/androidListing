package com.vc7.listing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vincent on 2016/10/31.
 */

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater = null;
    private ArrayList<Item> itemList;

    public ItemAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Item getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_item,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.headerTextView = (TextView)convertView.findViewById(R.id.headerTextView);
            viewHolder.titleTextView = (TextView)convertView.findViewById(R.id.titleTextView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Item item = getItem(position);
        viewHolder.headerTextView.setText(item.getHeader());
        viewHolder.titleTextView.setText(item.getTitle());

        return convertView;
    }

    private static class ViewHolder {
        TextView headerTextView;
        TextView titleTextView;
    }
}
