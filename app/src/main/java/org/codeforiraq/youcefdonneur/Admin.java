package org.codeforiraq.youcefdonneur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admin extends AppCompatActivity {
LinearLayout layout;
Button button;
TextView sing;
    private FirebaseAuth mAuth;
    TextInputEditText phone,password;
    SharedPreferences sharedPreferences;
    static final String MYKEY1="admin";
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/");
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        button=findViewById(R.id.button);
        phone=findViewById(R.id.s1);
        password=findViewById(R.id.s2);
        sing=findViewById(R.id.textView14);
        mAuth = FirebaseAuth.getInstance();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone1=phone.getText().toString();
                String password1=password.getText().toString();

                if(phone1.isEmpty()||password1.isEmpty()){
                    Toast.makeText(Admin.this, "Compléter tous les champs", Toast.LENGTH_SHORT).show();
                }
                else{

                   // if(!phone1.isEmpty()||!password1.isEmpty()){
                     //   emailAuth(phone1,password1);
                    //}



                  databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phone1)){
                                String getpassword=snapshot.child(phone1).child("password").getValue(String.class);
                                if(getpassword.equals(password1)){
                                    Toast.makeText(Admin.this, "seccessfully loghged in", Toast.LENGTH_SHORT).show();
                                    sharedPreferences = getSharedPreferences(MYKEY1,0);
                                    SharedPreferences.Editor editor=sharedPreferences.edit();
                                    editor.putString("ke",phone1);
                                    editor.commit();
                                    Intent g=new Intent(Admin.this,Userkisegel.class);

                                   // g.putExtra("phone",phone1);
                                    startActivity(g);

                                }
                                else{
                                    Toast.makeText(Admin.this, "Wrong Password", Toast.LENGTH_SHORT).show();

                                }
                            } else{
                                Toast.makeText(Admin.this, "Wrong Password", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });}
                emailAuth(phone1,password1);


                 }

        });

        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r2=new Intent(Admin.this,Sing.class);
                startActivity(r2);
            }
        });


    }
    private void emailAuth(String em,String pass){
        mAuth.signInWithEmailAndPassword(em, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Admin.this, "Authentication seccess.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Admin.this,AdminKISEJEL.class);
                            startActivity(intent);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Admin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });

    }
}