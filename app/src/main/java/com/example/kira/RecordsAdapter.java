package com.example.kira;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordsAdapter extends BaseAdapter {
    ArrayList<Integer> records;
    private LinearLayout recordLay;
    private LayoutInflater recordInf;

    RecordsAdapter(Context c, ArrayList<Integer> theRecords){
        records=theRecords;
        recordInf=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        recordLay=(LinearLayout)recordInf.inflate(R.layout.list_item_record, parent, false);
        TextView textViewRecord = recordLay.findViewById(R.id.text_record);
        textViewRecord.setText(Integer.toString(records.get(position)));
        recordLay.setTag(position);
        return recordLay;
    }
}
