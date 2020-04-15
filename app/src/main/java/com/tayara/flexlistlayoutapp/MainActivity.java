package com.tayara.flexlistlayoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tayara.flexlistlayoutapp.flexlistlayout.FlexListLayout;

public class MainActivity extends AppCompatActivity {

    FlexListLayout flexListLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flexListLayout = findViewById(R.id.flex_view);
        flexListLayout.addItem("Test");
        flexListLayout.addItem("Test");
        flexListLayout.addItem("Test");
        flexListLayout.addItem("Test");
        flexListLayout.addItem("Test");
        flexListLayout.addItem("Test");
        flexListLayout.addItem("Test");
        flexListLayout.addItem("Test");
        flexListLayout.addItem("Test");
    }
}
