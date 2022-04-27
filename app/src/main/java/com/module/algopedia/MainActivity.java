package com.module.algopedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    Button lets_start,aboutusbtn;
    ProgressDialog progressDialog;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lets_start=findViewById(R.id.letsstart);
        welcome=findViewById(R.id.welcome);
        aboutusbtn=findViewById(R.id.aboutusbtn);
        floatingActionButton = findViewById(R.id.fab);

        ActionBar actionBar=getSupportActionBar();
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#0a0a16"));
        actionBar.setBackgroundDrawable(colorDrawable);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(),ChatBotActivity.class));
                Crisp.configure(getApplicationContext(), "fc6d1481-7f8e-43f7-a68b-537055b1880c");
                Intent crispIntent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(crispIntent);
//                super.onStart();
            }
        });

        lets_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                Thread splashTread = new Thread(){


                    @Override

                    public void run() {

                        try {

                            sleep(1000);

                          //  startActivity(new Intent(MainActivity.this,SourceDistribution.class));
                            startActivity(new Intent(MainActivity.this,SourceDistribution.class));


                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }

                        super.run();

                    }

                };

                splashTread.start();
            }
        });
        aboutusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                Thread splashTread = new Thread(){


                    @Override

                    public void run() {

                        try {

                            sleep(1000);

                            startActivity(new Intent(MainActivity.this,AboutUs.class));


                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }

                        super.run();

                    }

                };

                splashTread.start();
            }
        });



    }

    @Override
    public void onBackPressed() {

        progressDialog.dismiss();
        finish();
    }

    public void functionToast(View view){
        Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_LONG).show();

    }

    public void functionToast2(View view){
        Toast.makeText(MainActivity.this,"When you see it clearly, You learn it effectively",Toast.LENGTH_LONG).show();

    }
    public void  gotoAboutusFunc()
    {
        gotoAboutus();
    }

    public void gotoAboutus(){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        Thread splashTread = new Thread(){


            @Override

            public void run() {

                try {

                    sleep(1000);

                    startActivity(new Intent(MainActivity.this,AboutUs.class));


                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                super.run();

            }

        };

        splashTread.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.exit) {
            Toast.makeText(MainActivity.this, "Exited", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (id == R.id.aboutus) {

            gotoAboutus();
        }
        return super.onOptionsItemSelected(item);
    }

}