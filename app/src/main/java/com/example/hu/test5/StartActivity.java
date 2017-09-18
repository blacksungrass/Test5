package com.example.hu.test5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            startActivity((Intent) msg.obj);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        SharedPreferences sharedPreferences = getSharedPreferences("ss", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");
        Intent intent = null;
        if ("".equals(token)) {
            intent = new Intent(this, LoginActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        Message msg = new Message();
        msg.obj = intent;
        handler.sendMessageDelayed(msg, 3000);
    }
}
