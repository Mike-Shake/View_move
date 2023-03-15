package com.example.view_move;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnView(View view){
        startActivity(new Intent(this,DragViewTest.class));
    }

    public void btnViewGroup(View view){
        startActivity(new Intent(this, DragViewGroupTest.class));
    }
}