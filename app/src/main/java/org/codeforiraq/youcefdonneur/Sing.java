package org.codeforiraq.youcefdonneur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sing extends AppCompatActivity {
    TextInputEditText name,phone,password,confpassword,typedesang,email,sex;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/");
    private Button button;
   // String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.h);
        password=findViewById(R.id.password);
        confpassword=findViewById(R.id.conf);
        typedesang=findViewById(R.id.typedesang);
        email=findViewById(R.id.email);
        sex=findViewById(R.id.sex);
        button=findViewById(R.id.button3);
//b="";
        check2();
        check1();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt=name.getText().toString();
                String phonetxt=phone.getText().toString();
                String typedesangtxt=typedesang.getText().toString();
                String passwordtxt=password.getText().toString();
                String conpss=confpassword.getText().toString();
                String sextxt=sex.getText().toString();
                String emailtxt=email.getText().toString();
                if(nametxt.isEmpty()||emailtxt.isEmpty()||
                        typedesangtxt.isEmpty()||passwordtxt.isEmpty()||conpss.isEmpty()||sextxt.isEmpty()||emailtxt.isEmpty()){
                    Toast.makeText(Sing.this, "Compléter tous les champs", Toast.LENGTH_SHORT).show();
                    name.setError("entrer ");
                    phone.setError("entrer ");
                    email.setError("entrer ");
                    typedesang.setError("entrer ");
                    password.setError("entrer ");
                    confpassword.setError("entrer ");
                    sex.setError("entrer ");
                    email.setError("entrer ");
                }
                else{
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phonetxt)){
                                Toast.makeText(Sing.this, "is alredy rejidtred", Toast.LENGTH_SHORT).show();
                            } else  if(!password.getText().toString().equals(confpassword.getText().toString())){
                                Toast.makeText(Sing.this, "le mot de passe ne correspond pas", Toast.LENGTH_SHORT).show();
                            }else{
                                databaseReference.child("user").child(phonetxt).child("name").setValue(nametxt);
                                databaseReference.child("user").child(phonetxt).child("l'age").setValue(emailtxt);
                                databaseReference.child("user").child(phonetxt).child("typedesang").setValue(typedesangtxt);
                                databaseReference.child("user").child(phonetxt).child("password").setValue(passwordtxt);
                                databaseReference.child("user").child(phonetxt).child("le sex").setValue(sextxt);
                                Toast.makeText(Sing.this, "rejistred", Toast.LENGTH_SHORT).show();
                                finish();
                                Intent i=new Intent(Sing.this,Userkisegel.class);
                                i.putExtra("name",nametxt);

                                startActivity(i);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }

            }


        });




    }

    private void check2() {
        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup=findViewById(R.id.n2);
                radioGroup.setVisibility(View.VISIBLE);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        RadioButton radioButton=findViewById(i);
                        switch(radioButton.getId()){
                            case R.id.homme:{
                                //b=radioButton.getText().toString();
                                sex.setText(radioButton.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }break;
                            case R.id.famme:{
                                //b=radioButton.getText().toString();
                                sex.setText(radioButton.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }break;
                        }
                    }
                });

            }
        });
    }

    private void check1() {
        typedesang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup2 = findViewById(R.id.n1);
                radioGroup2.setVisibility(View.VISIBLE);
                radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        RadioButton radioButton1 = findViewById(i);
                        switch (radioButton1.getId()) {
                            case R.id.a: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.ax: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.b: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.bx: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.fi: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.fx: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.homme: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.abx: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                        }
                    }
                });
            }
        });
    }}