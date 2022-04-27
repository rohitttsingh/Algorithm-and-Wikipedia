package com.module.algopedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.tiper.MaterialSpinner;

public class SourceDistribution extends AppCompatActivity {

    ProgressDialog progressDialog;
    ArrayAdapter<String> adapterItem;

    MaterialSpinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9,spinner10,spinner11,spinner12,spinner13,spinner14,spinner15;

    String[] chapter1 = {"1.1 Basic Terminology", "1.2 Classification of Data Structures", "1.3 Operations on Data Structures", "1.4 Abstract Data Type", "1.5 Algorithms", "1.6 Time and Space Complexity", "1.7 Notations"};
    String[] chapter2 = {"2.1 Introduction", "2.2 Declaration of Arrays", "2.3 Accessing the Elements of an Array", "2.4 Storing Values in Arrays", "2.5 Operations on Arrays", "2.6 Pointers and Arrays", "2.7 Arrays of Pointers", "2.8 Two-dimensional Arrays", "2.9 Operations on Two-Dimensional Arrays", "2.10 Multi-dimensional Arrays", "2.11 Applications of Arrays"};
    String[] chapter3 = {"3.1 Introduction", "3.2 Operations on Strings", "3.3 Arrays of Strings ", "3.4 Pointers and Strings"};
    String[] chapter4 = {"4.1 Introduction", "4.2 Nested Structures", "4.3 Arrays of Structures", "4.4 Structures and Functions", "4.5 Self-referential Structures", "4.6 Unions", "4.7 Arrays of Union Variables"};
    String[] chapter5 = {"5.1 Introduction", "5.2 Singly Linked Lists", "5.3 Circular Linked Lists", "5.4 Doubly Linked Lists", "5.5 Circular Doubly Linked Lists", "5.6 Header Linked Lists", "5.7 Multi-linked Lists", "5.8 Applications of Linked Lists"};

    String[] chapter6={"6.1 Introduction to Stacks","6.2 Array Representation of Stacks","6.3 Operations on a Stack","6.4 Linked Representation of Stacks","6.5 Operations on a Linked Stack","6.6 Applications of Stacks"};
    String[] chapter7={"7.1 Array Representation of Queues","7.2 Linked Representation of Queues","7.3 Types of Queues","7.4 Applications of Queues"};
    String[] chapter8={"8.1 Introduction","8.2 Types of Trees","8..3 Creating a Binary Tree from a General Tree","8.4 Traversing a Binary Tree","8.5 Huffman’s Tree","8.6 Applications of Trees"};
    String[] chapter9={"9.1 Binary Search Trees","9.2 Operations on Binary Search Trees","9.3 Threaded Binary Trees","9.4 AVL Trees","9.5 Red-Black Trees","9.6 Splay Trees"};

    String[] chapter10={"10.1 Introduction to M-Way Search Trees","10.2 B Trees","10.3 B+ Trees","10.4 2-3 Trees","10.5 Trie"};
    String[] chapter11={"11.1 Binary Heaps","11.2 Binomial Heaps","11.3 Fibonacci Heaps","11.4 Comparison of Binary","11.5 Applications of Heaps"};
    String[] chapter12={"12.1 Introduction","12.2 Graph Terminology","12.3 Directed Graphs","12.4 Representation of Graphs","12.5 Graph Traversal Algorithms","12.6 Topological Sorting","12.7 Shortest Path Algorithms","12.8 Applications of Graphs"};
    String[] chapter13={"13.1 Introduction to Searching","13.2 Linear Search","13.3 Binary Search","13.4 Interpolation Search","13.5 Jump Search ","13.6 Introduction to Sorting","13.7 Bubble Sort" , "13.8 Insertion Sort" , "13.9 Selection Sort" , "13.10 Merge Sort" , "13.11 Quick Sort" , "13.11 Radix Sort" , "13.12 Heap Sort" , "13.13 Shell Sort" , "13.15 Tree Sort" , "13.16 Comparison of Sorting Algorithms" , "13.17 External Sorting"};
    String[] chapter14={"14.1 Introduction " , "14.2 Hash Tables" , "14.3 Hash Functions " , "14.4 Different Hash Functions","14.5 Collisions","14.6 Pros and Cons of Hashing" , "14.7 Applications of Hashing Real World Applications of Hashing"};
    String[] chapter15={"15.1 Introduction " , "15.2 Algorithms" , "15.3 Containers " , "15.4 Functions","15.5 Iterators"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_distribution);

     //   autoCompleteTextView=findViewById(R.id.filled_exposed_dropdown);
        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        spinner3=findViewById(R.id.spinner3);
        spinner4=findViewById(R.id.spinner4);
        spinner5=findViewById(R.id.spinner5);
        spinner6=findViewById(R.id.spinner6);
        spinner7=findViewById(R.id.spinner7);
        spinner8=findViewById(R.id.spinner8);
        spinner9=findViewById(R.id.spinner9);
        spinner10=findViewById(R.id.spinner10);
        spinner11=findViewById(R.id.spinner11);
        spinner12=findViewById(R.id.spinner12);
        spinner13=findViewById(R.id.spinner13);
        spinner14=findViewById(R.id.spinner14);
        spinner15=findViewById(R.id.spinner15);


        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(Color.parseColor("#111133"));
        }
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blue));
        }
        ActionBar actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#111133"));
        actionBar.setBackgroundDrawable(colorDrawable);





////////////////////////////////////SPINNER 1/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter1);

                adapter.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {

                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SourceDistribution.this,Chapter1.class);
                intent.putExtra("title","1. Introduction To DSA");
                intent.putExtra("subtitle", materialSpinner.getSelectedItem().toString());
                intent.putExtra("position",i);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

////////////////////////////////////SPINNER 2/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter2 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter2);

        adapter2.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SourceDistribution.this,Chapter2.class);
                intent.putExtra("title","2. Arrays");
                intent.putExtra("subtitle", materialSpinner.getSelectedItem().toString());
                intent.putExtra("position",i);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

////////////////////////////////////SPINNER 3/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter3 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter3);

        adapter3.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner3.setAdapter(adapter3);

        spinner3.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SourceDistribution.this,Chapter3.class);
                intent.putExtra("title","3. Operations on Strings");
                intent.putExtra("subtitle", materialSpinner.getSelectedItem().toString());
                intent.putExtra("position",i);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

////////////////////////////////////SPINNER 4/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter4 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter4);

        adapter4.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner4.setAdapter(adapter4);

        spinner4.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });
////////////////////////////////////SPINNER 5/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter5 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter5);

        adapter5.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner5.setAdapter(adapter5);

        spinner5.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

////////////////////////////////////SPINNER 6/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter6 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter6);

        adapter6.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner6.setAdapter(adapter6);

        spinner6.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

////////////////////////////////////SPINNER 7/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter7 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter7);

        adapter7.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner7.setAdapter(adapter7);

        spinner7.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });
////////////////////////////////////SPINNER 8/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter8 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter8);

        adapter8.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner8.setAdapter(adapter8);

        spinner8.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

////////////////////////////////////SPINNER 9/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter9 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter9);

        adapter9.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner9.setAdapter(adapter9);

        spinner9.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

////////////////////////////////////SPINNER 10/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter10 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter10);

        adapter10.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner10.setAdapter(adapter10);

        spinner10.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

////////////////////////////////////SPINNER 11/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter11 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter11);

        adapter11.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner11.setAdapter(adapter11);

        spinner11.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

////////////////////////////////////SPINNER 12/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter12 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter12);

        adapter12.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner12.setAdapter(adapter12);

        spinner12.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

////////////////////////////////////SPINNER 13/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter13 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter13);

        adapter13.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner13.setAdapter(adapter13);

        spinner13.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                //Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SourceDistribution.this,Chapter13.class);
                intent.putExtra("title","13. Searching and Sorting");
                intent.putExtra("subtitle", materialSpinner.getSelectedItem().toString());
                intent.putExtra("position",i);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });
////////////////////////////////////SPINNER 14/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter14 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter14);

        adapter14.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner14.setAdapter(adapter14);

        spinner14.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });


////////////////////////////////////SPINNER 15/////////////////////////////////////////////////////////////////////////////////////////

        ArrayAdapter adapter15 = new ArrayAdapter(
                getApplicationContext(),R.layout.list_item_drawable_text,chapter15);

        adapter15.setDropDownViewResource(R.layout.spinner_drop_layout);


        spinner15.setAdapter(adapter15);

        spinner15.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                Toast.makeText(SourceDistribution.this," Opening... "+materialSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

    }//



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public void gotoAboutus(){
        progressDialog = new ProgressDialog(SourceDistribution.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        Thread splashTread = new Thread(){


            @Override

            public void run() {

                try {

                    sleep(1000);

                    startActivity(new Intent(SourceDistribution.this,AboutUs.class));


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
            Toast.makeText(SourceDistribution.this, "Exited", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (id == R.id.aboutus) {

            progressDialog = new ProgressDialog(SourceDistribution.this);
            progressDialog.show();
            progressDialog.setContentView(R.layout.progress_dialog);
            progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            Thread splashTread = new Thread(){


                @Override

                public void run() {

                    try {

                        sleep(1000);

                        startActivity(new Intent(SourceDistribution.this,AboutUs.class));


                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                    super.run();

                }

            };

            splashTread.start();

        }
        return super.onOptionsItemSelected(item);
    }
}////////////////////////////////////////////////////////////////////////////////////