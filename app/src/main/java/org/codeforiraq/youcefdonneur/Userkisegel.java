package org.codeforiraq.youcefdonneur;

import static org.codeforiraq.youcefdonneur.Sing.MYKEY;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Userkisegel extends AppCompatActivity {
    LinearLayout layout,layout1,layout2,bin;
    ConstraintLayout constraintLayout;
    private TextView textView;
    ImageView imageView1,imageView2,imageView3,imageView4;
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/");
    Bundle extras,extras1;
    String value;
    String getname;
    String getage;
    String getsex;
    String gettypedesang;







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
        imageView1=findViewById(R.id.imageView24);
        imageView2=findViewById(R.id.imageView22);




        extras=getIntent().getExtras();
        extras1=getIntent().getExtras();
        String b=extras.getString("name");
        String d=extras1.getString("phone");


        getdata();
        textView.setText(getname);
        if(gettypedesang.equals("B-")){
            imageView1.setImageResource(R.drawable.blood);
        }else if(gettypedesang.equals("A+")){
            imageView1.setImageResource(R.drawable.gibha);
        }else if(gettypedesang.equals("A-")){
            imageView1.setImageResource(R.drawable.giblna);
        }else if(gettypedesang.equals("AB+")){
            imageView1.setImageResource(R.drawable.down);
        }else if(gettypedesang.equals("o-")){
            imageView1.setImageResource(R.drawable.clack);
        }else if(gettypedesang.equals("AB-")){
            imageView1.setImageResource(R.drawable.blo);
        }else if(gettypedesang.equals("B-")){
            imageView1.setImageResource(R.drawable.bfown);
        }else{
            imageView1.setImageResource(R.drawable.golen);
        }
       /* if(getsex.equals("Homme")){
            imageView2.setImageDrawable(getResources().getDrawable(R.drawable.golen));
        }*/

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
    public void getdata(){
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                SharedPreferences preferences1=getSharedPreferences(MYKEY,0);
                String pref= preferences1.getString("key","not foond");
               value=snapshot.getValue(String.class);
               getname=snapshot.child("user").child(pref).child("name").getValue(String.class);
                getage=snapshot.child("user").child(pref).child("l'age").getValue(String.class);
                 getsex=snapshot.child("user").child(pref).child("le sex").getValue(String.class);
                gettypedesang=snapshot.child("user").child(pref).child("typedesang").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}