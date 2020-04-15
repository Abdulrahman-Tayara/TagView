package com.tayara.flexlistlayoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tayara.flexlistlayoutapp.flexlistlayout.FlexListLayout;

public class MainActivity extends AppCompatActivity {

    FlexListLayout tagView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tagView = findViewById(R.id.tag_view);
        tagView.addItem("Sunday ");
        tagView.addItem("Monday");
        tagView.addItem("Tuesday");
        tagView.addItem("Wednesday");
        tagView.addItem("Thursday");
        tagView.addItem("Friday");
        tagView.addItem("Saturday");
    }
}
