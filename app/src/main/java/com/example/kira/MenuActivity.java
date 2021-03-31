package com.example.kira;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onPlayClicked(View view) {
        Intent intent=new Intent(this, GameActivity.class);
        startActivityForResult(intent,0);
    }

    public void onRecordsClicked(View view){
        Intent intent=new Intent(this, RecordsActivity.class);
        startActivityForResult(intent,0);
    }
}
