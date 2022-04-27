package com.module.algopedia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TabHost;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Chapter3 extends AppCompatActivity {

    TabItem tabItem3;
    Button next,previous;
    int position;

    String[] chapter3 = {"3.1 Introduction", "3.2 Operations on Strings", "3.3 Arrays of Strings ", "3.4 Pointers and Strings"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter3);

        ActionBar actionBar = getSupportActionBar();
        String title= getIntent().getStringExtra("title");
        String subtitle= getIntent().getStringExtra("subtitle");


        int i = getIntent().getIntExtra("position",0);


        tabItem3=findViewById(R.id.tab3);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        String something = chapter3[i];

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(Color.parseColor("#111133"));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blue));
        }
        getSupportActionBar().setTitle("Topic : "+title);
        getSupportActionBar().setSubtitle(something);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#111133"));
        actionBar.setBackgroundDrawable(colorDrawable);



        position=i;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(position==3);
                else {
                    position=position+1;
                    display(position);
                }
            }


        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position==0);
                else{
                    position=position-1;
                    display(position);
                }
            }
        });

    }

//    public void nextFunction(View view){
//
//        if(position==6);
//        else {
//            position=position+1;
//            getSupportActionBar().setSubtitle(chapter1[position]);
//        }
//
//    }
//    public void nextFunction(int position){
//
//        if(position==6);
//        else {
//            position=position+1;
//            getSupportActionBar().setSubtitle(chapter1[position]);
//        }
//
//    }
//    public void previousFunction(View view ){
//
//
//        if (position==0);
//        else{
//            position=position-1;
//            getSupportActionBar().setSubtitle(chapter1[position]);
//        }
//    }
//    public void previousFunction(int position ){
//
//
//        if (position==0);
//        else{
//            position=position-1;
//            getSupportActionBar().setSubtitle(chapter1[position]);
//        }
//    }

    private void display(int number)
    {
        getSupportActionBar().setSubtitle(chapter3[number]);
    }
}