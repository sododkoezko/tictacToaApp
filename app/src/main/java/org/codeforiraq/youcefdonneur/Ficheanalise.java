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

public class Ficheanalise extends AppCompatActivity {
    TextInputEditText phone,santé,globileb,globiler,démog,déma,accép;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/");
    Button button;
    SharedPreferences sharedPreferences1;
    static final String MYKEY="sec";



    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifielesang);
        phone =findViewById(R.id.ap);
        santé=findViewById(R.id.bp);
        démog=findViewById(R.id.abp);
        globileb =findViewById(R.id.an);
        globiler=findViewById(R.id.bn);
        accép=findViewById(R.id.abn);
        déma =findViewById(R.id.on);
        button=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone1=phone.getText().toString();
                String santé1=santé.getText().toString();
                String démog1=démog.getText().toString();
                String globileb1=globileb.getText().toString();
                String globiler1=globiler.getText().toString();
                String accép1=accép.getText().toString();
                String déma1=déma.getText().toString();


                databaseReference.child("Fichier d'analyse").child(phone1).child("L'état de santé").setValue(santé1);
                databaseReference.child("Fichier d'analyse").child(phone1).child("le nombre de globule blancs").setValue(globileb1);
                databaseReference.child("Fichier d'analyse").child(phone1).child("le nombre de globule rouge").setValue(globiler1);
                databaseReference.child("Fichier d'analyse").child(phone1).child("Contité d'hémoglobine").setValue(démog1);
                databaseReference.child("Fichier d'analyse").child(phone1).child("Contité d'hématocrite").setValue(déma1);
                databaseReference.child("Fichier d'analyse").child(phone1).child("Acceptation").setValue(accép1);
                Toast.makeText(Ficheanalise.this, "Envoyer", Toast.LENGTH_SHORT).show();
                finish();
                //  sharedPreferences1 = getSharedPreferences(MYKEY,0);
                //SharedPreferences.Editor editor=sharedPreferences1.edit();


                //editor.commit();
                Intent i=new Intent(Ficheanalise.this,InterfaceAdmin.class);
                startActivity(i);

            }
        });

    }
}