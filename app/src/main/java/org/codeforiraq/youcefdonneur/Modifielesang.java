package org.codeforiraq.youcefdonneur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Modifielesang extends AppCompatActivity {
    TextInputEditText contitéAP,contitéBP,contitéABP,contitéAN,contitéBN,contitéABN,contitéoP,contitéoN;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/");
    Button button;
    SharedPreferences sharedPreferences1;
    static final String MYKEY="sec";



    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifielesang);
        contitéAP =findViewById(R.id.ap);
        contitéBP=findViewById(R.id.bp);
        contitéABP=findViewById(R.id.abp);
        contitéAN =findViewById(R.id.an);
        contitéBN=findViewById(R.id.bn);
        contitéABN=findViewById(R.id.abn);
        contitéoP =findViewById(R.id.op);
        contitéoN=findViewById(R.id.on);
        button=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ap=contitéAP.getText().toString();
                String bp=contitéBP.getText().toString();
                String abp=contitéABP.getText().toString();
                String an=contitéAN.getText().toString();
                String bn=contitéBN.getText().toString();
                String abn=contitéABN.getText().toString();
                String op=contitéoP.getText().toString();
                String on=contitéoN.getText().toString();
                databaseReference.child("Quantité").child("Quantité A+").setValue(ap);
                databaseReference.child("Quantité").child("Quantité B+").setValue(bp);
                databaseReference.child("Quantité").child("Quantité AB+").setValue(abp);
                databaseReference.child("Quantité").child("Quantité A-").setValue(an);
                databaseReference.child("Quantité").child("Quantité B-").setValue(bn);
                databaseReference.child("Quantité").child("Quantité AB-").setValue(abn);
                databaseReference.child("Quantité").child("Quantité o+").setValue(op);
                databaseReference.child("Quantité").child("Quantité o-").setValue(on);
                Toast.makeText(Modifielesang.this, "Modifié", Toast.LENGTH_SHORT).show();
                finish();
              //  sharedPreferences1 = getSharedPreferences(MYKEY,0);
                //SharedPreferences.Editor editor=sharedPreferences1.edit();


                //editor.commit();
                Intent i=new Intent(Modifielesang.this,InterfaceAdmin.class);
                startActivity(i);

            }
        });

    }
}