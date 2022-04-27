package com.module.algopedia;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;


public class Learn_Fragments extends Fragment {

    LottieAnimationView lottieAnimationView;
    TextView tv;
    Button refresh;
    public Learn_Fragments(){}


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_learn__fragments, container, false);


    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lottieAnimationView=view.findViewById(R.id.noinerrnet);
        lottieAnimationView.setVisibility(View.INVISIBLE);
        tv=view.findViewById(R.id.tv);
        refresh=view.findViewById(R.id.refresh);

        WebView webView = view.findViewById(R.id.webviewlearn);
        webView.setWebViewClient(new HelloWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.programiz.com/dsa/bubble-sort#:~:text=Bubble%20sort%20is%20a%20sorting,is%20called%20a%20bubble%20sort");
        super.onViewCreated(view, savedInstanceState);

      int a=  isNetworkAvailable();

        if (a == 1) {

            lottieAnimationView.setVisibility(View.VISIBLE);
            tv.setVisibility(View.INVISIBLE);
            refresh.setVisibility(View.VISIBLE);


        } else if (a == 0) {
            lottieAnimationView.setVisibility(View.INVISIBLE);
            tv.setVisibility(View.VISIBLE);
            refresh.setVisibility(View.INVISIBLE);


        }

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Learn_Fragments.class));
            }
        });



    }
    public int isNetworkAvailable() {

            ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connectivityManager != null) {


                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (capabilities != null) {
                        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {

                            return 0;
                        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {

                           return 0;
                        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {

                            return 0;
                        }
                    }
                }
            }

            return 1;

        }

    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}