package org.codeforiraq.youcefdonneur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Userkisegel extends AppCompatActivity {
    LinearLayout layout,layout1,layout2,bin;
    ConstraintLayout constraintLayout;
    private TextView textView;
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/");
    Bundle extras,extras1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userkisegel);
        textView=findViewById(R.id.textView6);
        layout=findViewById(R.id.layout1);
        layout1=findViewById(R.id.d1);
        layout2=findViewById(R.id.d2);
        bin=findViewById(R.id.b);
        constraintLayout=findViewById(R.id.tion);
        extras=getIntent().getExtras();
        extras1=getIntent().getExtras();
        String b=extras.getString("name");
        String d=extras1.getString("phone");
        textView.setText(b);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s=new Intent(Userkisegel.this,MainActivity5.class);
                startActivity(s);
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Userkisegel.this,Rendivou.class);
                intent.putExtra("phone",d);
                startActivity(intent);
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Userkisegel.this,MainActivity2.class);
                startActivity(i);
            }
        });


    }
}