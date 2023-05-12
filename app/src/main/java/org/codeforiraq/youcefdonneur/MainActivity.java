package org.codeforiraq.youcefdonneur;

import static org.codeforiraq.youcefdonneur.Sing.MYKEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 preferences=getSharedPreferences(MYKEY,0);

                    Intent j=new Intent(MainActivity.this,Admin.class);
                    startActivity(j);


            }
        },800);

    }
}