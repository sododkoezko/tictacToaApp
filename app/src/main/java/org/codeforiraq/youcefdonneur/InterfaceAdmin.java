package org.codeforiraq.youcefdonneur;

import static org.codeforiraq.youcefdonneur.Sing.MYKEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InterfaceAdmin extends AppCompatActivity {
    ImageView imageView1,imageView2;
TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
String s1,s2, s3,s4, s5,s6, s7,s8;
Button button;
    DatabaseReference myRef= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_admin);
        imageView1=findViewById(R.id.imageView10);
        imageView2=findViewById(R.id.imageView14);

        textView1=findViewById(R.id.textView2);
        textView2=findViewById(R.id.textView3);
        textView3=findViewById(R.id.textView4);
        textView4=findViewById(R.id.textView5);
        textView5=findViewById(R.id.textView6);
        textView6=findViewById(R.id.textView9);
        textView7=findViewById(R.id.textView10);
        textView8=findViewById(R.id.textView11);
        button=findViewById(R.id.button7);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()) {
                    s1 = snapshot.child("Contité").child("Contité A+").getValue(String.class);
                    s2 = snapshot.child("Contité").child("Contité B+").getValue(String.class);
                    s3 = snapshot.child("Contité").child("Contité AB+").getValue(String.class);
                    s4 = snapshot.child("Contité").child("Contité A-").getValue(String.class);
                    s5 = snapshot.child("Contité").child("Contité B-").getValue(String.class);
                    s6 = snapshot.child("Contité").child("Contité AB-").getValue(String.class);
                    s7 = snapshot.child("Contité").child("Contité o+").getValue(String.class);
                    s8 = snapshot.child("Contité").child("Contité o-").getValue(String.class);
                    textView1.setText(s2+" poches");
                    textView2.setText(s5+" poches");
                    textView3.setText(s3+" poches");
                    textView4.setText(s6+" poches");
                    textView5.setText(s1+" poches");
                    textView6.setText(s4+" poches");
                    textView7.setText(s7+" poches");
                    textView8.setText(s8+" poches");


                }

                    imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(InterfaceAdmin.this,Modifielesang.class);
                startActivity(h);

            }
        });
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent fil=new Intent(InterfaceAdmin.this,fiche.class);
                        startActivity(fil);
                    }
                });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p=new Intent(InterfaceAdmin.this,fiche.class);
                startActivity(p);

            }
        });
    }

            /**
             * This method will be triggered in the event that this listener either failed at the server, or
             * is removed as a result of the security and Firebase Database rules. For more information on
             * securing your data, see: <a
             * href="https://firebase.google.com/docs/database/security/quickstart" target="_blank"> Security
             * Quickstart</a>
             *
             * @param error A description of the error that occurred
             */
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}