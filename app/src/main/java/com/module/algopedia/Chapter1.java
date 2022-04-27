package com.module.algopedia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

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

public class Chapter1 extends AppCompatActivity {

    TabItem tabItem3;
    Button next,previous;
    int position;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    String[] chapter1 = {"1.1 Basic Terminology", "1.2 Classification of Data Structures", "1.3 Operations on Data Structures", "1.4 Abstract Data Type", "1.5 Algorithms", "1.6 Time and Space Complexity", "1.7 Notations"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(Color.parseColor("#111133"));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blue));
        }
        ActionBar actionBar = getSupportActionBar();
        String title= getIntent().getStringExtra("title");
        String subtitle= getIntent().getStringExtra("subtitle");


        int i = getIntent().getIntExtra("position",0);


        tabItem3=findViewById(R.id.tab3);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        String something = chapter1[i];

        getSupportActionBar().setTitle("Topic : "+title);
        getSupportActionBar().setSubtitle(something);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#111133"));
        actionBar.setBackgroundDrawable(colorDrawable);

        tabLayout=findViewById(R.id.tablayout1);
        viewPager=findViewById(R.id.viewpager);

        FragmentAdapter fragmentAdapter=new FragmentAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragmentAdapter.addFrament(new Learn_Fragments(),"Learn");
        fragmentAdapter.addFrament(new Code_Fragment(),"Code");
        fragmentAdapter.addFrament(new Visualise_Fragment(),"Visualize");
        fragmentAdapter.addFrament(new Watch_Fragment(),"Watch");


        viewPager.setAdapter(fragmentAdapter);
        tabLayout.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3){
                   // viewPager.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        position=i;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    if(position==6);
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


    private void display(int number)
    {
        getSupportActionBar().setSubtitle(chapter1[number]);
    }
}