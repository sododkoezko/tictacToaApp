package org.codeforiraq.youcefdonneur;

import static org.codeforiraq.youcefdonneur.Sing.MYKEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class donneurFiche extends AppCompatActivity {
    DatabaseReference myRef= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/");
    TextInputEditText santé,globileb,globiler,démog,déma,accép;
    String santé1,démog1,globileb1, globiler1,accép1, déma1;
    TextView textView1,textView2,textView4,textView5,textView6,textView7;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donneur_fiche);
        SharedPreferences preferences1=getSharedPreferences(MYKEY,0);
        String pref= preferences1.getString("key","not foond");
        santé=findViewById(R.id.santé);
        démog=findViewById(R.id.démog);
        globileb =findViewById(R.id.globileb);
        globiler=findViewById(R.id.globiler);
        accép=findViewById(R.id.accép);
        déma =findViewById(R.id.déma);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()) {
                    santé1 = snapshot.child("Fichier d'analyse").child("L'état de santé").getValue(String.class);
                    démog1 = snapshot.child("Fichier d'analyse").child("Contité d'hémoglobine").getValue(String.class);
                    globileb1 = snapshot.child("Fichier d'analyse").child("Cle nombre de globule blancs").getValue(String.class);
                    globiler1 = snapshot.child("Fichier d'analyse").child("le nombre de globule rouge").getValue(String.class);
                    déma1 = snapshot.child("Fichier d'analyse").child("Contité d'hématocrite").getValue(String.class);
                    accép1 = snapshot.child("Fichier d'analyse").child("Acceptation").getValue(String.class);

                    santé.setText(santé1);
                    démog.setText(démog1);

                    globileb.setText(globileb1);
                    globiler.setText(globiler1);
                    déma.setText(déma1);
                    accép.setText(accép1);

                }

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