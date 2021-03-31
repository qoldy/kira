package com.example.kira;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {
    RecordsAdapter adapter;
    SQLiteHelper helper;
    ArrayList<Integer> records;
    ListView listViewRecords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        init();
    }

    private void init(){
        listViewRecords=findViewById(R.id.list_records);
        helper=new SQLiteHelper(this, "records.db", null, 1);
        records=helper.readRecords();
        adapter=new RecordsAdapter(this,records);
        listViewRecords.setAdapter(adapter);
    }
}
