package org.codeforiraq.youcefdonneur;

import static org.codeforiraq.youcefdonneur.Sing.MYKEY;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Userkisegel extends AppCompatActivity {
    LinearLayout ficheanalise,modifieprofile,rendesvous,infoapp,layout2,consieil,avantage;
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
    String getdate;
    String gettemps;

    SharedPreferences preferences1;
    String pref;
    String d;
    TextView textViewrendivo;






    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userkisegel);
        textView=findViewById(R.id.textView6);
        //layout=findViewById(R.id.layout1);
        //layout1=findViewById(R.id.d1);
      //  layout2=findViewById(R.id.d2);
        //bin=findViewById(R.id.b);
        //constraintLayout=findViewById(R.id.tion);
        imageView1=findViewById(R.id.imageView55);
        imageView2=findViewById(R.id.imageView22);
        //d3=findViewById(R.id.d3);
        textViewrendivo=findViewById(R.id.textView21);
        ficheanalise=findViewById(R.id.ficheanalise);
        modifieprofile=findViewById(R.id.modifieprofile);
        rendesvous=findViewById(R.id.rendesvous);
        infoapp=findViewById(R.id.infoapp);
        consieil=findViewById(R.id.condi);
        avantage=findViewById(R.id.avantage);




       // extras=getIntent().getExtras();
        //extras1=getIntent().getExtras();
       // String b=extras.getString("name");
       //  d=extras1.getString("phone");

        getdata();
        ficheanalise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fichedoneur=new Intent(Userkisegel.this, donneurFiche.class);
                startActivity(fichedoneur);
            }
        });
        modifieprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modifieprofile=new Intent(Userkisegel.this,MainActivity2.class);
                startActivity(modifieprofile);

            }
        });
        rendesvous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rendesvous=new Intent(Userkisegel.this,Rendivou.class);
                startActivity(rendesvous);
            }
        });
        infoapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoap=new Intent(Userkisegel.this,Infoapp.class);
                startActivity(infoap);

            }
        });
        consieil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dik=new Intent(Userkisegel.this,Conseils.class);
                startActivity(dik);
            }
        });
        avantage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jo=new Intent(Userkisegel.this,Avantage.class);
                startActivity(jo);
            }
        });



        /*constraintLayout.setOnClickListener(new View.OnClickListener() {
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
/*
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Userkisegel.this,MainActivity2.class);
                startActivity(i);
            }
        });
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fichedonneur=new Intent(Userkisegel.this,donneurFiche.class);
                startActivity(fichedonneur);
            }
        });

*/
    }
    public void getdata(){
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               preferences1=getSharedPreferences(MYKEY,0);
               pref= preferences1.getString("key","not found");

               Log.d("youcef logging", "pref : " + pref);
              if(snapshot.exists()) {
                  getname = snapshot.child("user").child(pref).child("name").getValue(String.class);
                  getage = snapshot.child("user").child(pref).child("l'age").getValue(String.class);
                  getsex = snapshot.child("user").child(pref).child("le sex").getValue(String.class);
                  gettypedesang = snapshot.child("user").child(pref).child("typedesang").getValue(String.class);
                  getdate = snapshot.child("les rendez vous").child(pref).child("Date").getValue(String.class);
                  gettemps=snapshot.child("les rendez vous").child(pref).child("temps").getValue(String.class);


                  textView.setText(getname);
                  textViewrendivo.setVisibility(View.VISIBLE);
                  textViewrendivo.setText("rendervous "+getdate+"a"+gettemps);
                  if(getsex.equals("Homme")){
                      imageView2.setImageResource(R.drawable.profilellll);
                  }
                  if(gettypedesang.equals("B-")){
                      imageView1.setImageResource(R.drawable.bloodbn);
                  }else if(gettypedesang.equals("A+")){
                      imageView1.setImageResource(R.drawable.bloodap);
                  }else if(gettypedesang.equals("A-")){

                      imageView1.setImageResource(R.drawable.downloadan);
                  }else if(gettypedesang.equals("AB+")){
                      imageView1.setImageResource(R.drawable.bloodabp);

                  }else if(gettypedesang.equals("o-")){

                      imageView1.setImageResource(R.drawable.clackon);
                  }else if(gettypedesang.equals("AB-")){

                      imageView1.setImageResource(R.drawable.bloodabn);
                  }else if(gettypedesang.equals("B+")){

                      imageView1.setImageResource(R.drawable.bfownbn);
                  }else{
                      imageView1.setImageResource(R.drawable.golena111);
                  }


              }else{
                  Toast.makeText(Userkisegel.this, "fild to load data", Toast.LENGTH_SHORT).show();
              }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
 /*   public void getdata1(){
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                preferences1=getSharedPreferences(MYKEY1,0);
                pref= preferences1.getString("ke","not foond");
                if(snapshot.exists()) {
                    getname = snapshot.child("user").child(pref).child("name").getValue(String.class);
                    getage = snapshot.child("user").child(pref).child("l'age").getValue(String.class);
                    getsex = snapshot.child("user").child(pref).child("le sex").getValue(String.class);
                    gettypedesang = snapshot.child("user").child(pref).child("typedesang").getValue(String.class);


                    textView.setText(getname);
                    if(gettypedesang.equals("B-")){
                        imageView1.setImageResource(R.drawable.bloodbn);
                    }else if(gettypedesang.equals("A+")){
                        imageView1.setImageResource(R.drawable.bloodap);
                    }else if(gettypedesang.equals("A-")){

                        imageView1.setImageResource(R.drawable.downloadan);
                    }else if(gettypedesang.equals("AB+")){

                        imageView1.setImageResource(R.drawable.bloodabp);
                    }else if(gettypedesang.equals("o-")){

                        imageView1.setImageResource(R.drawable.clackon);
                    }else if(gettypedesang.equals("AB-")){

                        imageView1.setImageResource(R.drawable.bloodabn);
                    }else if(gettypedesang.equals("B+")){

                        imageView1.setImageResource(R.drawable.bfownbn);
                    }else{
                        imageView1.setImageResource(R.drawable.golena111);
                    }
                 /* if(getsex.equals("Homme")){
                      imageView2.setImageDrawable(getResources().getDrawable(R.drawable.golen));
                  }

                }else{
                    Toast.makeText(Userkisegel.this, "fild to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }*/
}