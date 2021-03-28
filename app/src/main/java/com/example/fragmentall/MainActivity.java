package com.example.fragmentall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragment(Fragment1.newInstance());
//        Button btn1 = findViewById(R.id.btnFragment1);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getFragment(Fragment1.newInstance());
//            }
//        });
//        Button btn2 = findViewById(R.id.btnFragment2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getFragment(Fragment2.newInstance());
//            }
//        });
    }

    private void getFragment(Fragment fragment) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,fragment).commit();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCloseAppEvent(EventCloseApp closeApp){
        finish();
    }
}